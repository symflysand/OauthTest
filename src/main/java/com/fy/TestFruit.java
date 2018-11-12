package com.fy;

import java.lang.reflect.Field;

/**
 * Title:TestFruit.java
 * Location:com.fy
 * Author:flysand
 * Date:2017年06月12 10:02:16
 * Description:
 **/
public class TestFruit {

    public static void main(String[] args) {
        /*Field[] fields = MyFruit.class.getDeclaredFields();

        for (Field field:fields){

            if (field.isAnnotationPresent(Fruit.class)){
                Fruit fruit = field.getAnnotation(Fruit.class);
                System.out.println(fruit.id() + fruit.name());
            }
        }*/

        MyFruit myFruit = new MyFruit();
        System.out.println(myFruit.getFruit());

    }
}
