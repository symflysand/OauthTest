package com.flysand.dao;

import com.flysand.model.entity.TUser;

import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> getUsers();
}