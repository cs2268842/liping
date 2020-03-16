package com.jiuli.liping.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 2.1 String ->Timestamp
     * 20151101095440
     */
    public static Timestamp StringToTimestamp(String date){
        String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
        date = date.replaceAll(reg, "$1-$2-$3 $4:$5:$6");
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

    public static String getTime(Timestamp timestamp) {
        Date currentTime = timestamp;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(currentTime);
        return dateString;
    }

    public static String getNowTime(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String hehe = dateFormat.format( now );
        System.out.println(hehe);
        return hehe;
    }
}
