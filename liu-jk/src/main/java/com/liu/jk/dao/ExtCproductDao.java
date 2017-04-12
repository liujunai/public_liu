package com.liu.jk.dao;

import com.liu.jk.model.ExtCproduct;

import java.io.Serializable;


/**
 * Created by liu on 17-4-12.
 */
public interface ExtCproductDao extends BaseDao<ExtCproduct> {

    public void deleteByContractProductById(Serializable[] ids); //
    public void deleteByContractById(Serializable[] ids);
}
