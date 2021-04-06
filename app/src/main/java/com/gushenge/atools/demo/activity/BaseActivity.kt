package com.gushenge.atools.demo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gushenge.atools.demo.dao.GlobalKeys
import com.gushenge.atools.util.APreference
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView

open class BaseActivity :AppCompatActivity(){
    var color by APreference(GlobalKeys.StatusBarColor,1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        color = ARandom.color()
        AView.setStatusBar(this@BaseActivity, AView.isLightColor(color))
    }
}
