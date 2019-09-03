package com.gushenge.atools.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ADate {

    /**
     * @param stamp 时间戳
     * @author Gushenge
     * @version 0.0.7
     * @return String
     * @description 时间戳转换成时间
     * */
    public String stampToDate(int stamp){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt  = Long.parseLong(Integer.toString(stamp)) * 1000;
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    /**
     * @param date 当前时间,格式为yyyy-MM-dd HH:mm:ss
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 时间转换成时间戳
     * */
    public int dateToStamp(String date) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date forDate = simpleDateFormat.parse(date);
        long ts = date != null ? forDate.getTime() : 0;
        res = String.valueOf(ts/1000);
        return Integer.parseInt(res);
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @return String
     * @description 获取当前时间
     * */
    public String getDate(){
        // HH:mm:ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 获取当前时间戳
     * */
    public int getStamp(){
        long timeStamp = System.currentTimeMillis();
        return Integer.parseInt(String.valueOf(timeStamp).substring(0,10));
    }
}
