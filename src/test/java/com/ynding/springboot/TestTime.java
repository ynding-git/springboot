package com.ynding.springboot;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTime {
    public static void main(String[] args) throws InterruptedException, ParseException {
        long time = new Date().getTime();
        Thread.sleep(1000);
        long time2 = new Date().getTime();
        Date date = new Date(time);
        Date date2 = new Date(time2);

        System.out.println(date.compareTo(date2));
        String date1 = DateUtil.format(date,"YYYY-mm-dd HH:mm:ss");

        Date date3 = DateFormat.getDateInstance().parse("2019-09-29");
        System.out.println(new Date().compareTo(date3));

        System.out.println(new Date());
        System.out.println(DateFormat.getDateInstance().format(new Date())
                .equals(DateFormat.getDateInstance().format(new Date())));

        String s =  DateFormat.getDateTimeInstance().format(date);
        String s1 =  DateFormat.getDateTimeInstance().format(date2);

        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(null));

        System.out.println(time);
        System.out.println(s);
        System.out.println(s1);
    }
}
