package com.gushenge.atools.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {
    /*
     * 将时间戳转换为时间
     */
    fun stampToDate(s: Int): String {
        val res: String
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val lt  = s.toLong() * 1000
        val date = Date(lt)
        res = simpleDateFormat.format(date)
        return res
    }

    /*
     * 将时间转换为时间戳
     */
    @Throws(ParseException::class)
    fun dateToStamp(s: String): String {
        val res: String
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = simpleDateFormat.parse(s)
        val ts = date!!.time
        val stamp = ts/1000
        res = stamp.toString()
        return res
    }
}
