package com.flysand.web.controller;

import com.flysand.config.MyConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Title:MyController.java
 * Location:com.flysand.web.controller
 * Author:flysand
 * Date:2017年07月04 17:45:37
 * Description:
 **/
@Controller
public class MyController {

    @RequestMapping("test1")
    public void test1(){
        MyConstants.t1++;
        MyConstants.t2++;
        MyConstants.l1.add(2);
        MyConstants.l2.add(3);
    }

    @RequestMapping("test2")
    public void test2(){
        System.out.println(MyConstants.t1);
        System.out.println(MyConstants.t2);
        System.out.println(MyConstants.l1.size());
        System.out.println(MyConstants.l2.size());
    }
}
