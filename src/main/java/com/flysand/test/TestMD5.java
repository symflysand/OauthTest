package com.flysand.test;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Title:TestMD5.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年04月20 11:53:53
 * Description:
 **/
public class TestMD5 {

    public static void main(String args[]){

        String password = "123456";
        String saltKey = "11ab7e4a2119415ebb7bbff98b2c82ba";

        String md5pwd = DigestUtils.md5Hex(password);

        String md5salt = DigestUtils.md5Hex(DigestUtils.md5Hex(password)+saltKey);

        System.out.println(md5pwd);
        System.out.println(md5salt);
    }
}
