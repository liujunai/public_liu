package com.liu.jk.dao.impl;

import com.liu.jk.dao.FactoryDao;
import com.liu.jk.model.Factory;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by liu on 17-4-11.
 */

@Repository
public class FactoryDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {
    public FactoryDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.FactoryMapper");
    }

    public void updateState(Map map) {
        super.getSqlSession().update(super.getNs()+".updateState", map);
    }
}
