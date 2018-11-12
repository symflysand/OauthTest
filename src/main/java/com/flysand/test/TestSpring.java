package com.flysand.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import org.junit.Before;

/**
 * Title:TestSpring.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年05月02 14:34:21
 * Description:
 **/
public class TestSpring {

    private ApplicationContext applicationContext;
    private ShardedJedisPool shardedJedisPool;


    @Before
    public void before() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-context.xml");
        shardedJedisPool =(ShardedJedisPool) applicationContext.getBean("shardedJedisPool");
    }

    @Test
    public void test(){
        ShardedJedis jedis = shardedJedisPool.getResource();
        jedis.set("mytest","中文行不行");
        shardedJedisPool.close();
    }
}
