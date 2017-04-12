package com.liu.jk.service;

import com.liu.jk.model.SysCode;

import java.util.List;
import java.util.Map;

/**
 * Created by liu on 17-4-12.
 */
public interface SysCodeService {
    public List<SysCode> find(Map paraMap);			//带条件查询，条件可以为null，既没有条件；返回list对象集合
}