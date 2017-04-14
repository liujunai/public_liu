package com.liu.jk.dao.impl;

import com.liu.jk.dao.OutProductDao;
import com.liu.jk.vo.OutProductVO;
import org.springframework.stereotype.Repository;

/**
 * Created by titanic on 17-4-13.
 */
@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao {

    public OutProductDaoImpl() {
        //设置命名空间
        super.setNs("com.liu.jk.mapper.OutProductMapper");
    }
}