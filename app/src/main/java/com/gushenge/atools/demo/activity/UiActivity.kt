package com.gushenge.atools.demo.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class UiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("UI演示", View.VISIBLE).init(viewManager = this,activity = this@UiActivity)
            button("宽度固定高度自适应的AutoHeightImage"){
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                onClick { startActivity<AutoHeightImageActivity>() }
            }.lparams(
                width = matchParent,
                height = wrapContent
            ){
                weight = 1.toFloat()
            }
        }
    }
}
