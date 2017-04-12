package com.liu.jk.dao.impl;

import com.liu.jk.dao.ContractDao;
import com.liu.jk.model.Contract;
import com.liu.jk.vo.ContractVO;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by liu on 17-4-11.
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
    public ContractDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.ContractMapper");
    }

    public void updateState(Map map) {
        super.getSqlSession().update(super.getNs()+".updateState", map);
    }


    public ContractVO view(String contractId) {
        return super.getSqlSession().selectOne(super.getNs()+".view",contractId);
    }
}