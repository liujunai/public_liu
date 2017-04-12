package com.liu.jk.dao;

import com.liu.jk.model.ContractProduct;

import java.io.Serializable;

/**
 * Created by liu on 17-4-11.
 */
public interface ContractProductDao extends BaseDao<ContractProduct> {

    public void deleteByContractById(Serializable[] ids);
}