package com.liu.jk.service.impl;

import com.liu.jk.dao.ContractDao;
import com.liu.jk.model.Contract;
import com.liu.jk.pagination.Page;
import com.liu.jk.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liu on 17-4-11.
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    ContractDao contractDao;

    public List<Contract> findPage(Page page) {
        return contractDao.findPage(page);
    }

    public List<Contract> find(Map paraMap) {
        return contractDao.find(paraMap);
    }

    public Contract get(Serializable id) {
        return contractDao.get(id);
    }

    public void insert(Contract contract) {
        contract.setId(UUID.randomUUID().toString());
        contract.setState(0);					//0草稿1已上报
        contractDao.insert(contract);
    }

    public void update(Contract contract) {
        contractDao.update(contract);
    }

    public void deleteById(Serializable id) {
        contractDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        contractDao.delete(ids);
    }

    public void submit(Serializable[] ids) {
        Map map = new HashMap();
        map.put("state", 1);				//1已上报
        map.put("ids", ids);

        contractDao.updateState(map);
    }

    public void cancel(Serializable[] ids) {
        Map map = new HashMap();
        map.put("state", 0);				//0草稿
        map.put("ids", ids);

        contractDao.updateState(map);
    }

}