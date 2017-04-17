package com.liu.jk.service.impl;

import com.liu.jk.dao.ContractDao;
import com.liu.jk.dao.ExportDao;
import com.liu.jk.dao.ExportProductDao;
import com.liu.jk.model.Contract;
import com.liu.jk.model.Export;
import com.liu.jk.pagination.Page;
import com.liu.jk.service.ExportService;
import com.liu.jk.vo.ContractVO;
import com.liu.util.UtilFuns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by titanic on 17-4-14.
 */
@Service
public class ExportServiceImpl implements ExportService {

    @Resource
    ExportDao exportDao;
    @Resource
    ExportProductDao exportProductDao;
    @Resource
    ContractDao contractDao;


    public List<Export> findPage(Page page) {
        return exportDao.findPage(page);
    }


    public List<Export> find(Map paraMap) {
        return exportDao.find(paraMap);
    }


    public Export get(Serializable id) {
        return exportDao.get(id);
    }


    public void insert(String[]  contractIds) {
        /*
         * 1.根据合同id获得合同对象,获得合同号
         * 2.
         * 3.
         */

        //拼接合同号
        String contractNos = "";
        for (int i=0; i<contractIds.length; i++){
            ContractVO contract = contractDao.view(contractIds[i]);
            contractNos += contract.getContractNo() + "";
        }
        contractNos = UtilFuns.delLastChar(contractNos);

        Export export = new Export();
        export.setId(UUID.randomUUID().toString());

        //合同的ID集合
        export.setContractIds(UtilFuns.joinStr(contractIds,","));       //工具类,将数组拼接成以,分割
        //合同号
        export.setCustomerContract(contractNos);

        exportDao.insert(export);

    }


    public void update(Export export) {
        exportDao.update(export);
    }



    public void deleteById(Serializable id) {
        exportDao.deleteById(id);
    }


    public void delete(Serializable[] ids) {
        exportDao.delete(ids);
    }


    public void submit(Serializable[] ids) {
        Map map = new HashMap();
        map.put("state",1);
        map.put("ids",ids);
        exportDao.updateState(map);
    }


    public void cancel(Serializable[] ids) {
        Map map = new HashMap();
        map.put("state",0);
        map.put("ids",ids);
        exportDao.updateState(map);
    }

    public List<Contract> getContractList() {
        Map map = new HashMap();
        map.put("state",1);             //1已上报
        return contractDao.find(map);
    }
}
