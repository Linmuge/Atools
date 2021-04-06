package com.gushenge.atools.demo

import android.app.Application
import com.gushenge.atools.ATools

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        ATools.init(this).preference("test")
    }

    companion object {

        lateinit var instance: Application
            private set
    }
}