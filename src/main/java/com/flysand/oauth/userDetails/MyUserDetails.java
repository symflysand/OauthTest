package com.flysand.oauth.userDetails;

import com.flysand.model.type.StatusType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Title:MyUserDetails.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月13 14:45:59
 * Description:
 **/
public class MyUserDetails implements UserDetails {

    private String username;

    private String password;

    private String saltKey;

    /**
     * 当前状态
     */
    private StatusType status;

    private Collection<? extends GrantedAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public MyUserDetails(){

    }

    /**
     * 实例化构造方法
     * @param username 用户名
     * @param password 密码（加盐后）
     * @param saltKey 盐值
     * @param status 状态
     * @param authorities 用户权限
     */
    public MyUserDetails(String username,String password,String saltKey,StatusType status,Collection<GrantedAuthority> authorities){
        this.username = username;
        this.password = password;
        this.saltKey = saltKey;
        this.status = status;
        this.authorities = authorities;
        this.accountNonExpired = isAccountNonExpired();
        this.accountNonLocked = isAccountNonLocked();
        this.credentialsNonExpired = isCredentialsNonExpired();
        this.enabled = isEnabled();
    }



    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return this.status!=StatusType.ACCOUNT_EXPIRED;
    }

    public boolean isAccountNonLocked() {
        return this.status!=StatusType.ACCOUNT_LOCKED;
    }

    public boolean isCredentialsNonExpired() {
        return this.status!=StatusType.CREDENTIAL_EXPIRED;
    }

    public boolean isEnabled() {
        return this.status!=StatusType.UNABLE;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
