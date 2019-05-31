package com.drxzt.asciimovie.dao;

import com.drxzt.asciimovie.entities.FilesDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FilesDoMapper {
    int deleteByPrimaryKey(Integer fileId);

    int insert(FilesDo record);

    int insertSelective(FilesDo record);

    FilesDo selectByPrimaryKey(Integer fileId);

    int updateByPrimaryKeySelective(FilesDo record);

    int updateByPrimaryKey(FilesDo record);
}