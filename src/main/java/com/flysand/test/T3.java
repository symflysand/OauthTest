package com.flysand.test;

/**
 * Title:T3.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年07月04 11:29:11
 * Description:
 **/
public class T3 {

    public  static int count = 0;

    public static void inc(){
        /*try {
            Thread.sleep(1);
        }catch (Exception e){

        }*/
        count++;
        //System.out.println("结果："+T3.count);
    }

    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            new Thread(new Runnable() {
                public void run() {
                    T3.inc();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        System.out.println("结果："+T3.count);
    }

}
