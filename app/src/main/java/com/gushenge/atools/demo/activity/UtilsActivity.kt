package com.gushenge.atools.demo.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import com.gushenge.atools.demo.activity.util.DateUtilsActivity
import com.gushenge.atools.demo.activity.util.PreferenceUtilsActivity
import com.gushenge.atools.demo.activity.util.RandomUtilsActivity
import com.gushenge.atools.demo.activity.util.ViewUtilsActivity
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

            titlebar("Utils演示").init(viewManager = this,activity = this@UtilsActivity)
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
                    arcButton {
                        text = "随机工具类 - RandomUtils"
                        val color = RandomUtils.color()
                        textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick { startActivity<RandomUtilsActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    arcButton {
                        text = "视图工具类 - ViewUtils"
                        val color = RandomUtils.color()
                        textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick { startActivity<ViewUtilsActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                    textView("以下仅适用于kotlin"){
                        gravity = Gravity.CENTER
                    }.lparams(width = matchParent,height = dip(45)){

                    }
                    arcButton {
                        text = "SharedPreferences工具类 - PreferenceUtils"
                        val color = RandomUtils.color()
                        textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick { startActivity<PreferenceUtilsActivity>() }
                    }.lparams(width = matchParent,height = dip(40)){
                        margin = dip(5)
                    }
                }
            }
        }
    }
}
