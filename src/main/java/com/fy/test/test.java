package com.fy.test;

import com.fy.util.MoreSheetExcelUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:test.java
 * Location:com.fy.test
 * Author:flysand
 * Date:2017年07月10 14:00:39
 * Description:
 **/
public class test {

    public static void main(String[] args) {
        List listSheet = new ArrayList();
        List title = new ArrayList();
        title.add("列1");
        title.add("列2");
        title.add("列3");
        title.add("列4");
        title.add("列5");

        List<Object[]> data = new ArrayList<Object[]>();

        Object[] objects = {"123","222","333","555","444"};
        data.add(objects);

        Map map1 = new HashMap();
        map1.put("sheetName","第一个sheet");
        map1.put("title",title);
        map1.put("data",data);

        listSheet.add(map1);
        String bookName = "我的excel表格";
        String filePath = MoreSheetExcelUtil.moreSheetExcel(listSheet,bookName);



    }
}
