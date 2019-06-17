package com.gushenge.atools.demo.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import com.gushenge.sgrl.Util.PreferenceUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : BaseActivity() {

    var test by PreferenceUtils("test",1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    fun initView() {
        verticalLayout(){
            titlebar("Atools Demo演示 Kotlin版", View.GONE).init(viewManager = this,activity = this@MainActivity)
            button("UI演示"){
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = sp(9).toFloat()
                onClick { startActivity<UiActivity>() }
            }.lparams(
                width = matchParent,
                height = wrapContent){
                weight = 1.toFloat()
                margin = dip(1)
            }
            button("Utils演示"){
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = sp(9).toFloat()
                onClick { startActivity<UtilsActivity>() }
            }.lparams(
                width = matchParent,
                height = wrapContent){
                weight = 1.toFloat()
                margin = dip(1)
            }
            button("关于"){
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = sp(9).toFloat()
                onClick { startActivity<AboutActivity>()}
            }.lparams(
                width = matchParent,
                height = wrapContent){
                weight = 1.toFloat()
                margin = dip(1)
            }

        }
    }

}
