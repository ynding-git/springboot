package com.ynding.springboot;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
    public static void main(String[] args) {
        long time = new Date().getTime();
        Date date = new Date(time);

        String date1 = DateUtil.format(date,"YYYY-mm-dd HH:mm:ss");

        String s =  DateFormat.getDateTimeInstance().format(date);
        System.out.println(time);
        System.out.println(s);
    }
}
