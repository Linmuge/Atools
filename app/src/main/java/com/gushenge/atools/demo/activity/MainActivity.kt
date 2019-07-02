package com.gushenge.atools.demo.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView
import com.gushenge.atools.util.APreference
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : BaseActivity() {

    var test by APreference("test",1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    fun initView() {
        verticalLayout(){
            titlebar("Atools Demo演示 Kotlin版", View.GONE).init(viewManager = this,activity = this@MainActivity)
            button("UI演示"){
                val color = ARandom.color()
                textColor = if (AView.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = 18f
                onClick { startActivity<UiActivity>() }
            }.lparams(
                width = matchParent,
                height = wrapContent){
                weight = 1.toFloat()
                margin = dip(1)
            }
            button("Utils演示"){
                val color = ARandom.color()
                textColor = if (AView.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = 18f
                onClick { startActivity<UtilsActivity>() }
            }.lparams(
                width = matchParent,
                height = wrapContent){
                weight = 1.toFloat()
                margin = dip(1)
            }
            button("关于"){
                val color = ARandom.color()
                textColor = if (AView.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = 18f
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
