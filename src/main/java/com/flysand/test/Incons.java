package com.flysand.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title:Incons.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年07月04 16:23:58
 * Description:
 **/
public class Incons {

    static int flag = 0;

    static Map<String,Object> map = new ConcurrentHashMap<>();

    static AtomicInteger a = new AtomicInteger(0);

}
