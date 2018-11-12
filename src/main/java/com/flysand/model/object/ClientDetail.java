package com.flysand.model.object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flysand.model.type.StatusType;

import java.io.Serializable;

/**
 * Title:ClientDetail.java
 * Location:com.flysand.model.object
 * Author:flysand
 * Date:2017年04月19 16:38:12
 * Description:
 **/
public class ClientDetail implements Serializable {
    private String clientId;
    private String clientSecret;
    private String roleName;
    private String saltKey;
    private StatusType status;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
