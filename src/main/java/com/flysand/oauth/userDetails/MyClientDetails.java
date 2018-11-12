package com.flysand.oauth.userDetails;

import com.flysand.model.type.StatusType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Title:MyClientDetails.java
 * Location:com.flysand.oauth
 * Author:flysand
 * Date:2017年04月19 16:51:42
 * Description:
 **/
public class MyClientDetails implements ClientDetails {

    private String clientId;

    private String ClientSecret;

    private String saltKey;

    private StatusType status;

    private Set<GrantedAuthority> authorities;

    private Set<String> scope;

    private Set<String> authorizedGrantTypes;

    public MyClientDetails(){

    }

    public MyClientDetails(String clientId,String clientSecret,String saltKey,StatusType status,Set<GrantedAuthority> authorities,Set<String> scope,Set<String> authorizedGrantTypes){
        this.clientId = clientId;
        this.ClientSecret = clientSecret;
        this.saltKey = saltKey;
        this.status = status;
        this.authorities = authorities;
        this.scope = scope;
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getClientId() {
        return clientId;
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

    public Set<String> getResourceIds() {
        return null;
    }

    public boolean isSecretRequired() {
        return false;
    }

    public String getClientSecret() {
        return ClientSecret;
    }

    public boolean isScoped() {
        return false;
    }

    public Set<String> getScope() {
        return scope;
    }

    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getAccessTokenValiditySeconds() {
        return null;
    }

    public Integer getRefreshTokenValiditySeconds() {
        return null;
    }

    public boolean isAutoApprove(String scope) {
        return false;
    }

    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
