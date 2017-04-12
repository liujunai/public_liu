package com.liu.jk.dao.impl;

import com.liu.jk.dao.SysCodeDao;
import com.liu.jk.model.SysCode;
import org.springframework.stereotype.Repository;

/**
 * Created by liu on 17-4-12.
 */
@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao {
    public SysCodeDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.SysCodeMapper");
    }
}