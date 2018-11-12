package com.flysand.service.impl;

import com.flysand.dao.MOUserMapper;
import com.flysand.dao.TUserMapper;
import com.flysand.model.entity.MOUser;
import com.flysand.model.entity.TUser;
import com.flysand.model.object.UserDetail;
import com.flysand.model.type.ErrorMsg;
import com.flysand.model.type.StatusType;
import com.flysand.service.UserService;
import com.flysand.util.UUIDUtil;
import com.github.pagehelper.PageHelper;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private MOUserMapper moUserMapper;

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

    public int addMOUser(String username, String password) {
        MOUser moUser = new MOUser();
        moUser.setUid(UUIDUtil.createUid(username));
        moUser.setUsername(username);
        String saltKey = UUIDUtil.createUid();
        moUser.setPassword(DigestUtils.md5Hex(DigestUtils.md5Hex(password)+saltKey));
        moUser.setSaltKey(saltKey);
        moUser.setStatus(StatusType.NORMAL.toString());
        int count = -1;
        try {
            count = moUserMapper.insert(moUser);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return count;
    }

    public List<UserDetail> getUserDetailByUserName(String username) {
        return moUserMapper.selectByUserName(username);
    }

    public ErrorMsg login(String username,String password){

        TUser user = userMapper.selectByUserName(username);
        if(user==null){
            return ErrorMsg.FAILED;
        }
        if (!user.getPassword().equals(DigestUtils.md5Hex(password))){
            return ErrorMsg.FAILED;
        }
        return ErrorMsg.SUCCESS;

    }

}
