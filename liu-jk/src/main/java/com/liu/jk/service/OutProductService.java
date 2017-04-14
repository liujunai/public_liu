package com.liu.jk.service;

import com.liu.jk.vo.OutProductVO;

import java.util.List;

/**
 * Created by titanic on 17-4-13.
 */
public interface OutProductService {
    public List<OutProductVO> find(String inputDate);		//带条件查询，条件可以为null，既没有条件；返回list对象集合
}