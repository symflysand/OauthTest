package com.flysand.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title:MyThread.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年07月04 15:41:08
 * Description:
 **/
public class MyThread implements Runnable {

    static volatile int i = 0 ;

    static AtomicInteger ai = new AtomicInteger(0);

    public void run() {
        for (int m = 0; m < 100000; m++) {
            //i++;
            ai.getAndIncrement();
        }

        synchronized (this){
            for (int m = 0; m < 100000; m++) {
                i++;
                //ai.getAndIncrement();
            }
        }


       // System.out.println(Incons.flag);

    }
}

