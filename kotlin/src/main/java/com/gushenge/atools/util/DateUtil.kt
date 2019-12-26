@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.gushenge.atools.util

import java.text.SimpleDateFormat
import java.util.*

val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
val simpleDateFormat13 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")

fun Long.stampToDate(): String {
    return ADate.simpleDateFormat13.format(Date(this))
}

fun Int.stampToDate(): String {
    return ADate.simpleDateFormat.format(Date(this.toLong()))
}

fun String.dateToStamp(): Long {
    return if (length < 20) {
        ADate.simpleDateFormat.parse(this).time / 1000
    } else {
        ADate.simpleDateFormat13.parse(this).time
    }
}