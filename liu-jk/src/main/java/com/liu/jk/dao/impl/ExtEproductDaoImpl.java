package com.liu.jk.dao.impl;

import com.liu.jk.dao.ExtEproductDao;
import com.liu.jk.model.ExtEproduct;
import org.springframework.stereotype.Repository;

/**
 * Created by liu on 17-4-17.
 */
@Repository
public class ExtEproductDaoImpl extends BaseDaoImpl<ExtEproduct> implements ExtEproductDao {
    public ExtEproductDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.ExtEproductMapper");
    }
}