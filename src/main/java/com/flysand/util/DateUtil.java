package com.flysand.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Title:DateUtil.java
 * Location:com.flysand.util
 * Author:flysand
 * Date:2017年06月22 15:57:14
 * Description:
 **/
public class DateUtil {

    /**
     * 获取上周一的日期
     * @return
     */
    public static String getLastMonday(){
        LocalDate lastMonday = LocalDate.now().minusWeeks(1).with(DayOfWeek.MONDAY);
        return lastMonday.toString();
    }

    public static String getLastSunday(){
        LocalDate lastSunday = LocalDate.now().minusWeeks(1).with(DayOfWeek.SUNDAY);
        return lastSunday.toString();
    }

    /**
     * 返回几周前的某个星期几的日期
     * @param weeks 间隔的星期树
     * @param dayOfWeek 星期几
     * @return
     */
    public static String getPreWeekDays(int weeks, DayOfWeek dayOfWeek){
        LocalDate localDate = LocalDate.now().minusWeeks(weeks).with(dayOfWeek);
        return localDate.toString();
    }


}
