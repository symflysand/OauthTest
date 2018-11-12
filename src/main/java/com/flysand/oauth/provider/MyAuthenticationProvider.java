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
 * Title:MyAuthenticationProvider.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月20 9:44:38
 * Description:
 **/
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);

    private UserDetailsService userDetailsService;

    /**
     * 用户认证信息检查，主要用于密码匹配
     * @param userDetails 数据库中用户信息
     * @param authentication 传进来的认证信息
     * @throws AuthenticationException
     */
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        logger.debug("myAuthenticationProvider additionalchecks");
        if(authentication.getCredentials()==null){
            logger.error("authentication credentials is null");
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }
        String saltKey = ((MyUserDetails) userDetails).getSaltKey();
        if(!MD5Util.isValidPassword(userDetails.getPassword(),authentication.getCredentials().toString(),saltKey)){
            logger.error("password is not equal");
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials",
                    "Bad credentials"));
        }

    }

    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        logger.debug("myAuthenticationProvider retrieveUser");
        UserDetails userDetails = this.getUserDetailsService().loadUserByUsername(username);
        return userDetails;
    }

    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
