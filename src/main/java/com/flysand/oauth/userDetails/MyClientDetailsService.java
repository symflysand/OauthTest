package com.flysand.oauth.userDetails;

import com.flysand.model.object.ClientDetail;
import com.flysand.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

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

    @Autowired
    private ClientService clientService;
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
        /*InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = new InMemoryClientDetailsServiceBuilder();
        inMemoryClientDetailsServiceBuilder.withClient("test").secret("123456").authorities("ROLE_USER").resourceIds("myresource")
                .authorizedGrantTypes("password").scopes("read,write").autoApprove();
        ClientDetails details = null;
        try {
            ClientDetailsService clientDetailsService = inMemoryClientDetailsServiceBuilder.build();
             details = clientDetailsService.loadClientByClientId(clientId);
        }catch (Exception e){
            logger.error(e.getMessage());
        }*/
        List<ClientDetail> clients = clientService.getClientByClientId(clientId);

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Set<String> scope = new HashSet<String>();
        Set<String> grantTypes = new HashSet<String>();
        grantTypes.add("password");
        scope.add("read");
        for(ClientDetail clientDetail : clients){
            authorities.add(new SimpleGrantedAuthority(clientDetail.getRoleName()));
        }
        ClientDetails details = new MyClientDetails(clients.get(0).getClientId(),clients.get(0).getClientSecret(),clients
                .get(0).getSaltKey(),clients.get(0).getStatus(),authorities,scope,grantTypes);

        return details;
    }


}
