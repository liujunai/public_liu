package com.liu.jk.service.impl;

import com.liu.jk.dao.OutProductDao;
import com.liu.jk.service.OutProductService;
import com.liu.jk.vo.OutProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by titanic on 17-4-13.
 */
@Service
public class OutProductServiceImpl implements OutProductService {
    @Resource
    OutProductDao outProductDao;

    public List<OutProductVO> find(String inputDate) {
        Map paraMap = new HashMap();
        paraMap.put("inputDate", inputDate);		//按条件查询，船期

        return outProductDao.find(paraMap);
    }

}