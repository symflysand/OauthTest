package com.fy.util;


import java.text.SimpleDateFormat;

import java.util.Date;


/**
 * 日期工具类
 * 
 * @author dada
 */
public class DateUtils {

	public static String formatTime(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(pattern).format(date);
	}

}
