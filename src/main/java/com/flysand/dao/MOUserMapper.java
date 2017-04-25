package com.flysand.dao;

import com.flysand.model.entity.MOUser;
import com.flysand.model.object.UserDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MOUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(MOUser record);

    int insertSelective(MOUser record);

    MOUser selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(MOUser record);

    int updateByPrimaryKey(MOUser record);

    /**
     * 根据username查询用户详情
     * @param username 用户名 指定mybatis查询的参数名
     * @return 用户详情
     */
    List<UserDetail> selectByUserName(@Param("username") String username);
}