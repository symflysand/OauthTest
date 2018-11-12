package com.flysand.oauth.provider;

import com.flysand.oauth.userDetails.MyUserDetails;
import com.flysand.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Title:MyClientAuthenticationProvider.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月20 10:18:56
 * Description:自定义client认证provider
 **/
public class MyClientAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(MyClientAuthenticationProvider.class);

    private UserDetailsService userDetailsService;

    /**
     * 验证client信息
     * @param userDetails client信息
     * @param authentication 认证信息
     * @throws AuthenticationException
     */
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        logger.debug("verify client info ");
        if(authentication.getCredentials()==null){
            logger.error("authentication credentials is null");
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

        MyUserDetails myUserDetails = (MyUserDetails)userDetails;
        String saleKey = myUserDetails.getSaltKey();
        if(!MD5Util.isValidPassword(myUserDetails.getPassword(),authentication.getCredentials().toString(),saleKey)){
            logger.error("password is not equal");
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

    }


    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails clientDetails = this.getUserDetailsService().loadUserByUsername(username);
        return clientDetails;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
