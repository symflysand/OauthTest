package com.flysand.access;

import com.flysand.oauth.MyUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/**
 * Title:MyAccessDecisionManager.java
 * Location:com.flysand.access
 * Author:flysand
 * Date:2017年04月14 17:59:40
 * Description:
 **/
public class MyAccessDecisionManager extends AbstractAccessDecisionManager {

    private static final Logger logger = LoggerFactory.getLogger(MyAccessDecisionManager.class);

    public MyAccessDecisionManager(List<AccessDecisionVoter<? extends Object>> decisionVoters) {
        super(decisionVoters);
    }

    /**
     *
     * @param authentication 用户认证信息
     * @param object filterInvocation
     * @param configAttributes 待访问资源所需的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
        logger.debug("visit user:"+user.getUsername());

        //如果当前资源不需要特殊权限
        if(configAttributes == null || configAttributes.isEmpty() ){
            return;
        }

        for (ConfigAttribute attribute : configAttributes){
            String attr = attribute.getAttribute() == null ? attribute.toString() : attribute.getAttribute();
            if(attr.equalsIgnoreCase("permitAll")){
                return;
            }
            for (GrantedAuthority grantedAuthority:authentication.getAuthorities()){
                if(grantedAuthority.getAuthority().equals(attr) || ("hasRole('"+grantedAuthority.getAuthority()+"')").equals(attr)){
                    return;
                }
            }
        }

        throw new AccessDeniedException("权限不足");
    }
}
