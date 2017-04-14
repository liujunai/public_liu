package com.liu.jk.dao;

import com.liu.jk.model.Export;

import java.util.Map;

/**
 * Created by titanic on 17-4-14.
 */
public interface ExportDao extends BaseDao<Export> {
    public void updateState(Map map);			//修改状态
}