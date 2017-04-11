package com.liu.jk.dao;

import com.liu.jk.model.Factory;

import java.util.Map;

/**
 * Created by liu on 17-4-11.
 */

public interface FactoryDao extends BaseDao<Factory> {
    public void updateState(Map map);			//修改状态
}
