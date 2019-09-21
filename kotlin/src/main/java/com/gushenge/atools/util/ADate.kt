@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.gushenge.atools.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

object ADate {

    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val simpleDateFormat13 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
    /**
     * @param stamp 时间戳
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.4
     * @return String
     * @description 时间戳转换成时间
     * */
    fun stampToDate(stamp: Long): String {
        return if (stamp.toString().length==10){
            simpleDateFormat.format(Date(stamp* 1000))
        }else{
            simpleDateFormat13.format(Date(stamp))
        }
    }

    /**
     * @param date 当前时间,格式为yyyy-MM-dd HH:mm:ss
     * @author Gushenge
     * @version 0.0.7
     * @update 0.1.4
     * @return int
     * @description 时间转换成时间戳
     * */
    @Throws(ParseException::class)
    fun dateToStamp(date: String): Long {
        return if (date.length<20){
            (simpleDateFormat.parse(date).time/1000)
        }else{
            simpleDateFormat13.parse(date).time
        }
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @return String
     * @description 获取当前时间(精确到秒)
     * */
    fun getDateToSecond() : String{
        //获取当前时间
        return simpleDateFormat.format(Date(System.currentTimeMillis()))
    }

    /**
     * @author Gushenge
     * @version 0.1.5
     * @return String
     * @description 获取当前时间(精确到毫秒)
     * */
    fun getDate() : String{
        //获取当前时间
        return simpleDateFormat13.format(Date(System.currentTimeMillis()))
    }

    /**
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 获取当前时间戳(十位)
     * */
    fun getStamp():Int{
        return (System.currentTimeMillis()/1000).toInt()
    }
    /**
     * @author Gushenge
     * @version 0.0.7
     * @return int
     * @description 获取当前时间戳(十三位)
     * */
    fun getStampAs13():Long{
        return System.currentTimeMillis()
    }
}
