package com.gushenge.atools.demo.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import com.gushenge.atools.demo.activity.util.*
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class UtilsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        verticalLayout {

            titlebar("Utils演示").init(viewManager = this,activity = this@UtilsActivity)
            scrollView {
                verticalLayout {
                    arcButton {
                        text = "时间日期工具类 - ADate"
                        val color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        onClick { startActivity<ADateActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    arcButton {
                        text = "随机工具类 - ARandom"
                        val color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        onClick { startActivity<ARandomActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    arcButton {
                        text = "视图工具类 - AView"
                        val color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        onClick { startActivity<AViewActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    arcButton {
                        text = "系统工具类 - ASystem"
                        val color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        onClick { startActivity<ASystemActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    arcButton {
                        text = "Log工具类 - ALog"
                        val color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        onClick { startActivity<ALogActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    textView("以下仅适用于kotlin"){
                        gravity = Gravity.CENTER
                    }.lparams(width = matchParent,height = dip(45)){

                    }
                    arcButton {
                        text = "SharedPreferences工具类 - APreference"
                        val color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        onClick { startActivity<APreferenceActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                }
            }
        }
    }
}
