package com.liu.jk.service.impl;

import com.liu.jk.dao.ContractDao;
import com.liu.jk.dao.ExportDao;
import com.liu.jk.dao.ExportProductDao;
import com.liu.jk.dao.ExtEproductDao;
import com.liu.jk.model.Contract;
import com.liu.jk.model.Export;
import com.liu.jk.model.ExportProduct;
import com.liu.jk.model.ExtEproduct;
import com.liu.jk.pagination.Page;
import com.liu.jk.service.ExportService;
import com.liu.jk.vo.ContractProductVO;
import com.liu.jk.vo.ContractVO;
import com.liu.jk.vo.ExtCproductVO;
import com.liu.util.UtilFuns;
import org.springframework.beans.BeanUtils;
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
    ExtEproductDao extEproductDao;
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
         * 1、根据合同id获得合同对象，获取合同号
		 * 2、将合同下的货物信息搬家到报运下的货物表中
		 * 3、将合同下的附件信息搬家到报运下的附件表中
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

        //处理货物信息
        for(int i=0;i<contractIds.length;i++){
            ContractVO contract = contractDao.view(contractIds[i]);

            for(ContractProductVO cp : contract.getContractProducts()){

                ExportProduct ep = new ExportProduct();
                ep.setId(UUID.randomUUID().toString());
                ep.setExportId(export.getId());					//绑定外键

                //数据搬家，将合同下的对应的货物信息写入到报运下的货物信息中
                ep.setFactoryId(cp.getFactory().getId());
                ep.setFactoryName(cp.getFactory().getFactoryName());
                ep.setProductNo(cp.getProductNo());
                ep.setPackingUnit(cp.getPackingUnit());
                ep.setCnumber(cp.getCnumber());
                ep.setBoxNum(cp.getBoxNum());
                ep.setPrice(cp.getPrice());

                exportProductDao.insert(ep);

                //处理附件信息
                for(ExtCproductVO extcp : cp.getExtCproducts()){
                    ExtEproduct extep = new ExtEproduct();

                    //copyProperties spring
                    BeanUtils.copyProperties(extcp, extep);		//spring工具类，数据的拷贝

                    extep.setId(UUID.randomUUID().toString());
                    extep.setExportProductId(ep.getId());		//绑定外键

                    extep.setFactoryId(extcp.getFactory().getId());
                    extep.setFactoryName(extcp.getFactory().getFactoryName());

                    extEproductDao.insert(extep);
                }
            }
        }
    }


    public void update(Export export, String[] mr_id, Integer[] mr_orderNo, Integer[] mr_cnumber, Double[] mr_grossWeight, Double[] mr_netWeight, Double[] mr_sizeLength,
                       Double[] mr_sizeWidth, Double[] mr_sizeHeight, Double[] mr_exPrice, Double[] mr_tax, Integer[] mr_changed){

        exportDao.update(export);
        //批量修改货物信息

        for(int i=0;i<mr_id.length;i++){
           // if(mr_changed[i]!=null && mr_changed[i]==1){			//修改标识，只有用户修改的行才进行更新

                ExportProduct ep = exportProductDao.get(mr_id[i]);

                ep.setOrderNo(mr_orderNo[i]);
                ep.setCnumber(mr_cnumber[i]);
                ep.setGrossWeight(mr_grossWeight[i]);
                ep.setNetWeight(mr_netWeight[i]);
                ep.setSizeLength(mr_sizeLength[i]);
                ep.setSizeWidth(mr_sizeWidth[i]);
                ep.setSizeHeight(mr_sizeHeight[i]);
                ep.setExPrice(mr_exPrice[i]);
                ep.setTax(mr_tax[i]);

                exportProductDao.update(ep);
           // }
        }
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

    //拼接JS串
    //function addTRRecord(objId, id, productNo, cnumber, grossWeight, netWeight, sizeLength, sizeWidth, sizeHeight, exPrice, tax)
    public String getMrecordData(String exportId){
        Map paraMap = new HashMap();
        paraMap.put("exportId", exportId);

        List<ExportProduct> oList = exportProductDao.find(paraMap );

        StringBuffer sBuf = new StringBuffer();
        for(ExportProduct ep : oList){
            sBuf.append("addTRRecord(\"mRecordTable\", \"").append(ep.getId()).append("\", \"").append(ep.getProductNo()).append("\", \"").append(ep.getCnumber()).append("\", \"").append(UtilFuns.convertNull(ep.getGrossWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getNetWeight())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeLength())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeWidth())).append("\", \"").append(UtilFuns.convertNull(ep.getSizeHeight())).append("\", \"").append(UtilFuns.convertNull(ep.getExPrice())).append("\", \"").append(UtilFuns.convertNull(ep.getTax())).append("\");");
        }

        return sBuf.toString();
    }

}
