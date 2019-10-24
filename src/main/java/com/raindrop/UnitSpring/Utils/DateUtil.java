package com.raindrop.UnitSpring.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Description TODO 日期工具类
 * @Author Raindrop
 * @Date 2019/10/22
 */
public class DateUtil {
    private static SimpleDateFormat sdf;

    //格式化日期的类
    public static String format(String format, Object... date){
        if (format == null){
            format = "yyyy-MM-dd hh:mm:ss";
        }
        sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    //格式化String日期
    public static String Paste(String strDate, String format) throws ParseException {
        if (format == null){
            format = "yyyy-MM-dd hh:mm:ss";
        }
        sdf = new SimpleDateFormat(format);
        return sdf.format(sdf.parse(strDate));
    }


}
