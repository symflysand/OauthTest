package com.flysand.service;

import com.flysand.model.entity.MOClient;
import com.flysand.model.object.ClientDetail;

import java.util.List;

/**
 * Title:ClientService.java
 * Location:com.flysand.service
 * Author:flysand
 * Date:2017年04月19 16:20:33
 * Description:
 **/
public interface  ClientService {

    public List<ClientDetail> getClientByClientId(String clientId);
}
