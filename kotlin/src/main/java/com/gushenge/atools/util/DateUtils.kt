package com.gushenge.atools.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {
    /*
     * 将时间戳转换为时间
     */
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    fun stampToDate(s: Int): String {
        val lt  = s.toLong() * 1000
        val date = Date(lt)
        return simpleDateFormat.format(date)
    }

    /*
     * 将时间转换为时间戳
     */
    @Throws(ParseException::class)
    fun dateToStamp(s: String): String {
        val date = simpleDateFormat.parse(s)
        val ts = date!!.time
        val stamp = ts/1000
        return stamp.toString()
    }
    fun getDate() : String{
        //获取当前时间
        val date = Date(System.currentTimeMillis())
        return simpleDateFormat.format(date)
    }

    fun getStamp():String{
        val timeStamp = System.currentTimeMillis()
        return timeStamp.toString().substring(0, 10)
    }
}
