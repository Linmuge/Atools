package com.gushenge.atools.demo.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gushenge.atools.demo.activity.util.DateUtilsActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class UtilsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        verticalLayout {

            titlebar("Utils演示",View.VISIBLE).init(viewManager = this,activity = this@UtilsActivity)
            scrollView {
                verticalLayout {
                    arcButton {
                        text = "时间日期工具类 - DateUtils"
                        val color = RandomUtils.color()
                        textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick { startActivity<DateUtilsActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                }
            }
        }
    }
}
