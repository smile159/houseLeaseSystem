package com.xinxin.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author smile
 * @ClassName DateTimeUtils.java
 * @Description 时间工具类
 * @createTime 2022年05月07日 19:51:00
 */
public class DateTimeUtils {
    public static String getNowDateTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("现在的时间是："+format);
        return format;
    }
}
