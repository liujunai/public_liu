package com.liu.jk.service.impl;

import com.liu.jk.dao.ExtCproductDao;
import com.liu.jk.dao.SysCodeDao;
import com.liu.jk.model.ExtCproduct;
import com.liu.jk.model.SysCode;
import com.liu.jk.pagination.Page;
import com.liu.jk.service.ExtCproductService;
import com.liu.util.UtilFuns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by liu on 17-4-12.
 */
@Service
public class ExtCproductServiceImpl implements ExtCproductService {
    @Resource
    ExtCproductDao extCproductDao;

    @Resource
    SysCodeDao sysCodeDao;

    public List<ExtCproduct> findPage(Page page) {
        return extCproductDao.findPage(page);
    }

    public List<ExtCproduct> find(Map paraMap) {
        return extCproductDao.find(paraMap);
    }

    public ExtCproduct get(Serializable id) {
        return extCproductDao.get(id);
    }

    public void insert(ExtCproduct extCproduct) {
        extCproduct.setId(UUID.randomUUID().toString());
        //自动计算总金额=数量*单价		...修改，删除；同步合同总金额
        if(UtilFuns.isNotEmpty(extCproduct.getCnumber()) && UtilFuns.isNotEmpty(extCproduct.getPrice())){
            extCproduct.setAmount(extCproduct.getCnumber()*extCproduct.getPrice());
        }

        extCproductDao.insert(extCproduct);
    }

    public void update(ExtCproduct extCproduct) {
        extCproductDao.update(extCproduct);
    }

    public void deleteById(Serializable id) {
        extCproductDao.deleteById(id);
    }

    public void delete(Serializable[] ids) {
        extCproductDao.delete(ids);
    }

    public List<SysCode> getCtypeList() {
        Map paraMap = new HashMap();
        paraMap.put("parentId", "0104");			//sys_code_b 0104附件分类
        return sysCodeDao.find(paraMap);
    }

}