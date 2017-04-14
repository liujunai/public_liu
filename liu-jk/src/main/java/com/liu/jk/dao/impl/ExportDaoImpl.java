package com.liu.jk.dao.impl;

import com.liu.jk.dao.ExportDao;
import com.liu.jk.model.Export;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by titanic on 17-4-14.
 */
@Repository
public class ExportDaoImpl extends BaseDaoImpl<Export> implements ExportDao {

    public ExportDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.ExportMapper");
    }

    public void updateState(Map map) {
        super.getSqlSession().update(super.getNs()+".updateState", map);
    }
}