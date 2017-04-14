package com.liu.jk.service.impl;

import com.liu.jk.dao.ExportDao;
import com.liu.jk.model.Contract;
import com.liu.jk.model.Export;
import com.liu.jk.pagination.Page;
import com.liu.jk.service.ExportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by titanic on 17-4-14.
 */
@Service
public class ExportServiceImpl implements ExportService {

    @Resource
    ExportDao exportDao;

    @Override
    public List<Export> findPage(Page page) {
        return null;
    }

    @Override
    public List<Export> find(Map paraMap) {
        return null;
    }

    @Override
    public Export get(Serializable id) {
        return null;
    }

    @Override
    public void insert(String[] contractIds) {

    }

    @Override
    public void update(Export export, String[] mr_id, Integer[] mr_orderNo, Integer[] mr_cnumber, Double[] mr_grossWeight, Double[] mr_netWeight, Double[] mr_sizeLength, Double[] mr_sizeWidth, Double[] mr_sizeHeight, Double[] mr_exPrice, Double[] mr_tax, Integer[] mr_changed) {

    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public void delete(Serializable[] ids) {

    }

    @Override
    public void submit(Serializable[] ids) {

    }

    @Override
    public void cancel(Serializable[] ids) {

    }

    @Override
    public List<Contract> getContractList() {
        return null;
    }

    @Override
    public String getMrecordData(String exportId) {
        return null;
    }
}
