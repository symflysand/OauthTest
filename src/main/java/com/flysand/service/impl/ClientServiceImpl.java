package com.flysand.service.impl;

import com.flysand.dao.MOClientMapper;
import com.flysand.model.entity.MOClient;
import com.flysand.model.object.ClientDetail;
import com.flysand.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:ClientServiceImpl.java
 * Location:com.flysand.service.impl
 * Author:flysand
 * Date:2017年04月19 16:21:43
 * Description:
 **/
@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    private MOClientMapper clientMapper;

    public List<ClientDetail> getClientByClientId(String clientId) {
        List<ClientDetail> clientDetails= clientMapper.selectByClientId(clientId);
        return clientDetails;
    }
}
