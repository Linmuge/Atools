package com.gushenge.atools.util

import android.util.Log

@Deprecated("",level = DeprecationLevel.WARNING)
object ALog {
    fun v(TAG:String,message:Any){
        Log.v(TAG,message.toString())
    }
    fun d(TAG:String,message:Any){
        Log.d(TAG,message.toString())
    }
    fun i(TAG:String,message:Any){
        Log.i(TAG,message.toString())
    }
    fun w(TAG:String,message:Any){
        Log.w(TAG,message.toString())
    }
    fun e(TAG:String,message:Any){
        Log.e(TAG,message.toString())
    }
}