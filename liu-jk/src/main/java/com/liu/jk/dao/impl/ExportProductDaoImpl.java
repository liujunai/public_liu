package com.liu.jk.dao.impl;

import com.liu.jk.dao.ExportProductDao;
import com.liu.jk.model.ExportProduct;
import org.springframework.stereotype.Repository;

/**
 * Created by liu on 17-4-17.
 */
@Repository
public class ExportProductDaoImpl extends BaseDaoImpl<ExportProduct> implements ExportProductDao{
    public ExportProductDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.ExportProductMapper");
    }
}