package com.flysand.dao;

import com.flysand.model.entity.MOClient;
import com.flysand.model.object.ClientDetail;

import java.util.List;

public interface MOClientMapper {
    int deleteByPrimaryKey(String cid);

    int insert(MOClient record);

    int insertSelective(MOClient record);

    MOClient selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(MOClient record);

    int updateByPrimaryKey(MOClient record);

    List<ClientDetail> selectByClientId(String clientId);
}