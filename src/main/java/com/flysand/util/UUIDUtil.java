package com.flysand.util;

import java.util.UUID;

/**
 * Title:UUIDUtil.java
 * Location:com.flysand.util
 * Author:flysand
 * Date:2017年04月19 15:32:59
 * Description:uid生成工具类
 **/
public class UUIDUtil {

    /**
     * 创建一个随机UUID
     * @return
     */
    public static String createUid(){
        String randStr = UUID.randomUUID().toString();
        randStr = randStr.replaceAll("-","");
        return randStr;
    }

    /**
     * 创建一个随机UUID+key
     * @param key
     * @return
     */
    public static String createUid(String key){
        String randStr = UUID.randomUUID().toString() + key;
        randStr = randStr.replaceAll("-","");
        return randStr;
    }
}
