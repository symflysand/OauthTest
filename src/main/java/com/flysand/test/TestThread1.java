package com.flysand.test;

/**
 * Title:TestThread1.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年07月04 15:47:02
 * Description:
 **/
public class TestThread1 {

    public static void main(String[] args) throws InterruptedException  {
        MyThread mt = new MyThread();

        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println("===total:"+Incons.flag);
    }
}

