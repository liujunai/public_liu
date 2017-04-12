package com.liu.jk.service.impl;

import com.liu.jk.dao.SysCodeDao;
import com.liu.jk.model.SysCode;
import com.liu.jk.service.SysCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by liu on 17-4-12.
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {
    @Resource
    SysCodeDao sysCodeDao;

    public List<SysCode> find(Map paraMap) {
        return sysCodeDao.find(paraMap);
    }

}