package com.flysand.test;

/**
 * Title:T4.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年07月04 16:47:41
 * Description:
 **/
public class T4 {


    public static void main(String[] args) throws Exception {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1："+Incons.flag+","+Incons.a.get());
                Incons.flag += 50;
                Incons.a.getAndIncrement();
            }
        }).start();
        System.out.println("主线程1："+Incons.flag+","+Incons.a.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2："+Incons.flag+","+Incons.a.get());
                Incons.flag += 30;
                Incons.a.getAndIncrement();
            }
        }).start();


        Thread.sleep(1000);
        System.out.println("主线程2："+Incons.flag+","+Incons.a.get());*/
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);

        t1.start();
        t2.start();

        Thread.sleep(1000);
        System.out.println(MyThread.i);
        System.out.println(MyThread.ai.get());

    }
}
