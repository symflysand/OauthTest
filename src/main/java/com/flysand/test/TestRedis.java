package com.flysand.test;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title:TestRedis.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年04月26 13:44:39
 * Description:
 **/
public class TestRedis {

    public static void main(String args[]){

        Jedis jedis = new Jedis("localhost");
        System.out.println("connection to redis server"+ jedis.ping());

        Map<String,String> map = new ConcurrentHashMap<String, String>();
        map.put("code", "123456");
        map.put("mobile", "13564598180");

        map.put("time", new Date().toString());

        jedis.hmset("13564598180",map);

        List<String> valueList = jedis.hmget("13564598180","code","mobile","time");
        System.out.print(valueList);


        System.out.println("read:"+jedis.get("testkey"));










    }
}
