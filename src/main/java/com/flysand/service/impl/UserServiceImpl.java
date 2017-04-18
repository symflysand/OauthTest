package com.flysand.service.impl;

import com.flysand.dao.TUserMapper;
import com.flysand.model.entity.TUser;
import com.flysand.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


/**
 * Created by jianyi on 2017年3月31日 0031.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Transactional
    public int addUser(String username) {

        TUser user = new TUser();
        user.setUserName(username);
        String password = DigestUtils.md5Hex("123456");
        String uid = UUID.randomUUID().toString();
        user.setPassword(password);
        user.setUid(uid);
        int result = -1;
        try {
            result = userMapper.insert(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public List<TUser> getUsers(int pageIndex, int pageSize) {

        pageIndex = pageIndex > 0 ? pageIndex : 1;
        pageSize = pageSize > 0 ? pageSize : 10;
        PageHelper.startPage(pageIndex, pageSize);
        List<TUser> users = userMapper.getUsers();
        return users;
    }
}
