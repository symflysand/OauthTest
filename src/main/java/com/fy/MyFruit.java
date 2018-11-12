package com.fy;

/**
 * Title:MyFruit.java
 * Location:com.fy
 * Author:flysand
 * Date:2017年06月12 9:56:16
 * Description:
 **/
public class MyFruit {

    //@Fruit(id=1,name="我的水果")
    private String fruit;


    public String getFruit() {
        return fruit;
    }
    @Fruit(id=2,name="我的")
    public void setFruit(String fruit) {
        this.fruit = fruit;
    }
}
