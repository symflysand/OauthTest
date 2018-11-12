package com.flysand.oauth.userDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetailsService;

/**
 * Title:MyClientDetailsUserDetailsService.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月20 10:48:29
 * Description:自定义client-user转换类
 **/
public class MyClientDetailsUserDetailsService implements UserDetailsService {

    private final ClientDetailsService clientDetailsService;

    public MyClientDetailsUserDetailsService(ClientDetailsService clientDetailsService){
        this.clientDetailsService = clientDetailsService;
    }
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyClientDetails clientDetails = (MyClientDetails) this.clientDetailsService.loadClientByClientId(username);
        return new MyUserDetails(clientDetails.getClientId(),clientDetails.getClientSecret(),clientDetails.getSaltKey(),clientDetails.getStatus(),clientDetails.getAuthorities());
    }
}
