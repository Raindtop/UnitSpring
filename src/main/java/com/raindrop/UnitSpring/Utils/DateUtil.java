package com.raindrop.UnitSpring.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Description TODO 日期工具类
 * @Author Raindrop
 * @Date 2019/10/22
 */
public class DateUtil {
    private static SimpleDateFormat sdf;


    public static String Formate(String format, Object... date){
        sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String Formate(String format, String date){
        sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
