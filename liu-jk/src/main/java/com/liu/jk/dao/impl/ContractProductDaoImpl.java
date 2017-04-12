package com.liu.jk.dao.impl;

import com.liu.jk.dao.ContractProductDao;
import com.liu.jk.model.ContractProduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by liu on 17-4-11.
 */
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {
    public ContractProductDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.ContractProductMapper");
    }


    public void deleteByContractById(Serializable[] ids) {
        super.getSqlSession().delete(super.getNs()+".deleteByContractById",ids);
    }
}