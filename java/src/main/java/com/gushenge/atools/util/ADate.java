package com.gushenge.atools.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ADate {
    public String stampToDate(int s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lt  = Long.parseLong(Integer.toString(s)) * 1000;
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    public String dateToStamp(String s) throws ParseException{
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date != null ? date.getTime() : 0;
        res = String.valueOf(ts/1000);
        return res;
    }
    public String getDate(){
        // HH:mm:ss
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    public String getStamp(){
        long timeStamp = System.currentTimeMillis();
        return String.valueOf(timeStamp).substring(0,10);
    }
}
