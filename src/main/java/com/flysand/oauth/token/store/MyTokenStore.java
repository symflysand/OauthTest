package com.flysand.oauth.token.store;

import com.alibaba.fastjson.JSON;
import com.flysand.oauth.userDetails.MyUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import redis.clients.jedis.Jedis;

import java.util.Collection;

/**
 * Title:MyTokenStore.java
 * Location:com.flysand.oauth.token.store
 * Author:flysand
 * Date:2017年04月26 16:56:46
 * Description:
 **/
public class MyTokenStore implements TokenStore {

    private static final Logger logger = LoggerFactory.getLogger(MyTokenStore.class);

    private Jedis jedis = new Jedis("localhost");

    private static final String ACCESS_TOKEN_KEY = "access";
    private static final String AUTHENTICATION_KEY = "authentication";

    public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        logger.debug("根据OAuth2AccessToken 读取用户认证信息");
        return readAuthentication(token.getValue());
    }

    public OAuth2Authentication readAuthentication(String token) {
        logger.debug("根据token读取用户认证信息");
        String authentication = jedis.hget(OAuth2Authentication.class.getName(),AUTHENTICATION_KEY+token);
        return authentication==null ? null : JSON.parseObject(authentication,OAuth2Authentication.class);
    }

    /**
     * 存储accessToken及其他相关信息
     *
     * @param token          生成的token
     * @param authentication 用户认证信息
     */
    public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        byte[] authenticationKey = SerializationUtils.serialize(AUTHENTICATION_KEY + token.getValue());
        //存储accessToken
        jedis.hset(OAuth2AccessToken.class.getName(), AUTHENTICATION_KEY + ((MyUserDetails) authentication.getPrincipal()).getUsername(), JSON.toJSONString(token));
        //根据token存储用户信息
        jedis.hset(OAuth2Authentication.class.getName(),AUTHENTICATION_KEY+token.getValue(),JSON.toJSONString(authentication));
    }

    /**
     * 根据access_token读取accessToken对象
     *
     * @param tokenValue token值
     * @return token对象
     */
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        logger.debug("readAccessToken by tokenValue");
        String token = jedis.get(ACCESS_TOKEN_KEY + tokenValue);
        return JSON.parseObject(token, DefaultOAuth2AccessToken.class);
    }

    /**
     * 从redis中移除accessToken
     *
     * @param token
     */
    public void removeAccessToken(OAuth2AccessToken token) {
        logger.debug("remove access token");
        jedis.del(ACCESS_TOKEN_KEY + token.getValue());
    }

    public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {

    }

    public OAuth2RefreshToken readRefreshToken(String tokenValue) {
        return null;
    }

    public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        return null;
    }

    public void removeRefreshToken(OAuth2RefreshToken token) {

    }

    public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {

    }

    /**
     * 根据认证信息查询token
     *
     * @param authentication
     * @return
     */
    public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        String accessToken = jedis.hget(OAuth2AccessToken.class.getName(), AUTHENTICATION_KEY + ((MyUserDetails) authentication.getPrincipal()).getUsername());
        return accessToken == null ? null : JSON.parseObject(accessToken, DefaultOAuth2AccessToken.class);
    }

    public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        return null;
    }

    public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        return null;
    }
}
