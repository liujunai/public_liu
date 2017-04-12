package com.liu.jk.dao.impl;


import com.liu.jk.dao.ExtCproductDao;
import com.liu.jk.model.ExtCproduct;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


/**
 * Created by liu on 17-4-12.
 */
@Repository
public class ExtCproductDaoImpl extends BaseDaoImpl<ExtCproduct> implements ExtCproductDao{
    public ExtCproductDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.ExtCproductMapper");
    }

    public void deleteByContractProductById(Serializable[] ids) {
        super.getSqlSession().delete(super.getNs()+".deleteByContractProductById",ids);
    }

    public void deleteByContractById(Serializable[] ids) {
        super.getSqlSession().delete(super.getNs()+".deleteByContractById",ids);
    }
}
