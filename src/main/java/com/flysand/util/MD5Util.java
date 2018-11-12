package com.flysand.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Title:MD5Util.java
 * Location:com.flysand.util
 * Author:flysand
 * Date:2017年04月21 10:26:24
 * Description:md5加密、加盐、验证
 **/
public class MD5Util {

    /**
     * 密码MD5加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    public static String md5(String password) {
        return DigestUtils.md5Hex(password);
    }

    /**
     * md5加盐加密
     * @param password 密码
     * @param saltKey 盐值
     * @return 加盐后的密码
     */
    public static String md5Salt(String password, String saltKey) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex(password) + saltKey);
    }

    /**
     * 比较加盐后的密码和原密码
     * @param saltPassword 加盐后的密码
     * @param password 原密码
     * @param saltKey 盐值
     * @return 比较结果
     */
    public static boolean isValidPassword(String saltPassword, String password, String saltKey) {
        return saltPassword.equals(MD5Util.md5Salt(password, saltKey));
    }
}
