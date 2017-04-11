package com.liu.jk.service.impl;

import com.liu.jk.dao.ContractProductDao;
import com.liu.jk.model.ContractProduct;
import com.liu.jk.pagination.Page;
import com.liu.jk.service.ContractProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liu on 17-4-11.
 */
@Service
public class ContractProductServiceImpl implements ContractProductService {
    @Resource
    ContractProductDao contractProductDao;

    public List<ContractProduct> findPage(Page page) {
        return contractProductDao.findPage(page);
    }

    public List<ContractProduct> find(Map paraMap) {
        return contractProductDao.find(paraMap);
    }

    public ContractProduct get(Serializable id) {
        return contractProductDao.get(id);
    }

    public void insert(ContractProduct contractProduct) {
        contractProduct.setId(UUID.randomUUID().toString());
        //自动计算总金额=数量*单价		...修改，删除；同步合同总金额
        contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());

        contractProductDao.insert(contractProduct);
    }

    public void update(ContractProduct contractProduct) {
        contractProductDao.update(contractProduct);
    }

    public void deleteById(Serializable id) {
        contractProductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractProductDao.delete(ids);
    }

}