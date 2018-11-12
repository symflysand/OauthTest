package com.fy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Title:Fruit.java
 * Location:com.fy
 * Author:flysand
 * Date:2017年06月12 9:53:22
 * Description:
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Fruit {
    public int id() default -1;

    public String name() default "";

}
