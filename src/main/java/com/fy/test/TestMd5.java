package com.fy.test;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Title:TestMd5.java
 * Location:com.fy.test
 * Author:flysand
 * Date:2017年07月13 10:35:43
 * Description:
 **/
public class TestMd5 {
    public static void main(String[] args) {
        String str = DigestUtils.md5Hex("pageIndex1pageSize10d6f34a2ba082146c67a7e6f8c5842604");
        System.out.println(str);
    }
}
