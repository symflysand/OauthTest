package com.flysand.test;

/**
 * Title:TestThread.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年07月03 15:37:59
 * Description:
 **/
public class TestThread extends Thread {


    public TestThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i<=50; i++){
            System.out.println("" + this.getName() + "----" + i);
            //当i为30时，该线程会把CPU时间让掉，让其他或者自己线程执行

            if(i == 30){
                this.yield();
            }
        }


    }

    public static void main(String[] args) {

        TestThread t1 = new TestThread("张三");
        TestThread t2 = new TestThread("李四");

        t1.start();
        t2.start();

    }
}
