package com.flysand.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.*;

/**
 * Title:MyClientDetailsService.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月17 11:39:49
 * Description:
 **/
public class MyClientDetailsService implements ClientDetailsService {

    private final static Logger logger = LoggerFactory.getLogger(MyClientDetailsService.class);


    /**
     * 根据clientId获取完整可授权的client
     *
     * @param clientId
     * @return
     * @throws ClientRegistrationException
     */
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        /*ClientDetailsServiceBuilder clientDetailsServiceBuilder =
                new ClientDetailsServiceBuilder().withClient("test").secret("123456").scopes("read,write").authorizedGrantTypes("password")
                .authorities("ROLE_USER").autoApprove();*/
        InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = new InMemoryClientDetailsServiceBuilder();
        inMemoryClientDetailsServiceBuilder.withClient("test").secret("123456").authorities("ROLE_USER").resourceIds("myresource")
                .authorizedGrantTypes("password").scopes("read,write").autoApprove();
        ClientDetails details = null;
        try {
            ClientDetailsService clientDetailsService = inMemoryClientDetailsServiceBuilder.build();
             details = clientDetailsService.loadClientByClientId(clientId);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return details;
    }


}
