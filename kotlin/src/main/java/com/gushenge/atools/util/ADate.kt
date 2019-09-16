package com.gushenge.atools.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

object ADate {

    /**
     * @param stamp 时间戳
     * @author Gushenge
     * @version 0.0.7
     * @return String
     * @description 时间戳转换成时间
     * */
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    fun stampToDate(s: Int): String {
        val lt  = s.toLong() * 1000
        val date = Date(lt)
        return simpleDateFormat.format(date)
    }

    /**
     * @param date 当前时间,格式为yyyy-MM-dd HH:mm:ss
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 时间转换成时间戳
     * */
    @Throws(ParseException::class)
    fun dateToStamp(s: String): String {
        val date = simpleDateFormat.parse(s)
        val ts = date!!.time
        val stamp = ts/1000
        return stamp.toString()
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @return String
     * @description 获取当前时间
     * */
    fun getDate() : String{
        //获取当前时间
        val date = Date(System.currentTimeMillis())
        return simpleDateFormat.format(date)
    }

    /**
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 获取当前时间戳(十位)
     * */
    fun getStamp():Int{
        val timeStamp = System.currentTimeMillis()
        return timeStamp.toString().substring(0, 10).toInt()
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 获取当前时间戳(十三位)
     * */
    fun getStampAs13():String{
        val timeStamp = System.currentTimeMillis()
        return timeStamp.toString()
    }
}
