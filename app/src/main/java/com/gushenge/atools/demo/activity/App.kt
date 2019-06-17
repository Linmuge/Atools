package com.gushenge.atools.demo.activity

import android.app.Application
import com.gushenge.atools.ATools

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ATools.init(this).preference("test")
    }
}