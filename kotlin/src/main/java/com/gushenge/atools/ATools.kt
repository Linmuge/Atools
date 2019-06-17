package com.gushenge.atools

import android.app.Application
import android.content.Context
import com.gushenge.sgrl.Util.PreferenceUtils

object ATools {

    lateinit var context:Application
    fun init(context: Application):ATools{
        this.context = context
        return this
    }
    fun preference(spName:String){
        PreferenceUtils.init(context,spName)
    }
}