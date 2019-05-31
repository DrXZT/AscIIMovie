package com.drxzt.asciimovie.dao;

import com.drxzt.asciimovie.entities.LogDo;

public interface LogDoMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(LogDo record);

    int insertSelective(LogDo record);

    LogDo selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(LogDo record);

    int updateByPrimaryKey(LogDo record);
}