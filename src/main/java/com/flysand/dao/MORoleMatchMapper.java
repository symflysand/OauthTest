package com.flysand.dao;

import com.flysand.model.entity.MORoleMatch;

public interface MORoleMatchMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(MORoleMatch record);

    int insertSelective(MORoleMatch record);

    MORoleMatch selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(MORoleMatch record);

    int updateByPrimaryKey(MORoleMatch record);
}