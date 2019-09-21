package com.gushenge.atools.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ADate {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat simpleDateFormat13 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    /**
     * @param stamp 时间戳
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.5
     * @return String
     * @description 时间戳转换成时间
     * */
    public String stampToDate(Long stamp){
        if (stamp.toString().length()==10){
            return simpleDateFormat.format(new Date(stamp* 1000));
        }else {
            return simpleDateFormat13.format(new Date(stamp));
        }
    }
    /**
     * @param date 当前时间,格式为yyyy-MM-dd HH:mm:ss
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.5
     * @return Long
     * @description 时间转换成时间戳
     * */
    public Long dateToStamp(String date) throws ParseException{
        if (date.length()<20){
           return  simpleDateFormat.parse(date).getTime()/1000;
        }else {
            return  simpleDateFormat13.parse(date).getTime();
        }
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.5
     * @return String
     * @description 获取当前时间(精确到秒)
     * */
    public String getDateToSecond(){
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.5
     * @return String
     * @description 获取当前时间(精确到毫秒)
     * */
    public String getDate(){
        return simpleDateFormat13.format(new Date(System.currentTimeMillis()));
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.5
     * @return int
     * @description 获取当前时间戳(十位)
     * */
    public int getStamp(){
        long timeStamp = System.currentTimeMillis();
        return Integer.parseInt(String.valueOf(timeStamp).substring(0,10));
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.5
     * @return int
     * @description 获取当前时间戳(十三位)
     * */
    public Long getStampAs13(){
        return System.currentTimeMillis();
    }
}
