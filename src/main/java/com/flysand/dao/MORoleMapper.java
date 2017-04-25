package com.flysand.dao;

import com.flysand.model.entity.MORole;

public interface MORoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(MORole record);

    int insertSelective(MORole record);

    MORole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(MORole record);

    int updateByPrimaryKey(MORole record);
}