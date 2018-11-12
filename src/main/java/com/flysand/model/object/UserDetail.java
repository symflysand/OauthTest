package com.flysand.model.object;

import com.flysand.model.type.StatusType;

import java.io.Serializable;

/**
 * Title:UserDetail.java
 * Location:com.flysand.model.object
 * Author:flysand
 * Date:2017年04月21 10:48:50
 * Description: 登录用户详情
 **/
public class UserDetail implements Serializable{

    private String username;

    private String password;

    private String saltKey;

    private StatusType status;

    private String roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSaltKey() {
        return saltKey;
    }

    public void setSaltKey(String saltKey) {
        this.saltKey = saltKey;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
