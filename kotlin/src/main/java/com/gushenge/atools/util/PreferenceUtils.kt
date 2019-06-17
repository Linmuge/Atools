package com.gushenge.sgrl.Util

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log.e
import kotlin.reflect.KProperty



class PreferenceUtils<T>(var name: String, var default: T) {
    companion object{
        lateinit var context: Application
        lateinit var spName: String
        fun init(context: Application,spName: String){
            this.context = context
            this.spName = spName
        }
    }
    val prefs: SharedPreferences by lazy { context.getSharedPreferences(spName, Context.MODE_PRIVATE) }
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = getSharedPreferences(name, default)

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putSharedPreferences(name, value)


    private fun putSharedPreferences(name: String, value: T) = with(prefs.edit()) {
        when(value) {
            is Int -> putInt(name, value)
            is Float -> putFloat(name, value)
            is Long -> putLong(name, value)
            is Boolean -> putBoolean(name, value)
            is String -> putString(name, value)
            else -> throw IllegalArgumentException("SharedPreference can't be save this type")
        }.apply()
    }

    private fun getSharedPreferences(name:String, default: T): T = with(prefs) {
        e("text1111",prefs.toString())
        val res: Any = when(default) {
            is Int -> getInt(name, default)
            is Float -> getFloat(name, default)
            is Long -> getLong(name, default)
            is Boolean -> getBoolean(name, default)
            is String -> getString(name, default)!!
            else -> throw IllegalArgumentException("SharedPreference can't be get this type")
        }
        return res as T
    }
}