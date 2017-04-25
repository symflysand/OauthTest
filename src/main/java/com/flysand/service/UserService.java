package com.flysand.service;


import com.flysand.model.entity.TUser;
import com.flysand.model.object.UserDetail;

import java.util.List;

/**
 * Created by flysand on 2017年3月31日 0031.
 */
public interface UserService {


    int addUser(String username);

    List<TUser> getUsers(int pageIndex, int pageSize);

    int addMOUser(String username,String password);

    List<UserDetail> getUserDetailByUserName(String username);

}
