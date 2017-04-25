package com.flysand.oauth;

import com.flysand.model.object.UserDetail;
import com.flysand.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:MyUserDetailsService.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月13 14:43:11
 * Description:
 **/
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserService userService;

    /**
     * 根据用户名查询登录认证的用户
     *
     * @param username 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetail> userDetailList = userService.getUserDetailByUserName(username);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (UserDetail userDetail : userDetailList) {
            authorities.add(new SimpleGrantedAuthority(userDetail.getRoleName()));
        }
        UserDetails userDetails = new MyUserDetails(userDetailList.get(0).getUsername(), userDetailList.get(0).getPassword(),
                userDetailList.get(0).getSaltKey(), userDetailList.get(0).getStatus(), authorities);

        /*authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = new User("user", "123", authorities);*/
        return userDetails;
    }
}
