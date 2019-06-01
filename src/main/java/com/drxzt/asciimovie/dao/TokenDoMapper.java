package com.drxzt.asciimovie.dao;

import com.drxzt.asciimovie.entities.TokenDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TokenDoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TokenDo record);

    int insertSelective(TokenDo record);

    TokenDo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TokenDo record);

    int updateByPrimaryKey(TokenDo record);
}