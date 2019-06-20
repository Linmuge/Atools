package com.gushenge.atools.util;

import android.util.Log;

public class ALog {
    public static void v(String TAG,Object message){
        Log.v(TAG,message.toString());
    }
    public static void d(String TAG,Object message){
        Log.d(TAG,message.toString());
    }
    public static void w(String TAG,Object message){
        Log.w(TAG,message.toString());
    }
    public static void i(String TAG,Object message){
        Log.i(TAG,message.toString());
    }
    public static void e(String TAG,Object message){
        Log.e(TAG,message.toString());
    }
}
