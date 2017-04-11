package com.liu.jk.dao;

import com.liu.jk.model.Contract;

import java.util.Map;

/**
 * Created by liu on 17-4-11.
 */
public interface ContractDao extends BaseDao<Contract> {
    public void updateState(Map map);			//修改状态
}