package com.flysand.test;

import com.flysand.util.DateUtil;

import java.time.DayOfWeek;
import java.util.Calendar;

/**
 * Title:TestDate.java
 * Location:com.flysand.test
 * Author:flysand
 * Date:2017年06月22 16:00:27
 * Description:
 **/
public class TestDate {

    public static void main(String[] args) {
        String date = DateUtil.getLastMonday();
        System.out.println(date);

        String weekDay = DateUtil.getPreWeekDays(4, DayOfWeek.WEDNESDAY);
        System.out.println(weekDay);
    }
}
