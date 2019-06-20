package com.gushenge.atools.demo.activity

import android.graphics.Color
import android.os.Bundle
import com.gushenge.atools.demo.activity.ui.ArcButtonActivity
import com.gushenge.atools.demo.activity.ui.AutoHeightImageActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class UiActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("UI演示").init(viewManager = this,activity = this@UiActivity)
            arcButton {
                text = "宽度固定高度自适应的ImageView - AutoHeightImage"
                val color = ARandom.color()
                textColor = if (AView.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                onClick { startActivity<AutoHeightImageActivity>() }
            }.lparams(
                width = matchParent,
                height = dip(40)
            ){
                margin = dip(5)
            }
            arcButton {
                text = "自定义圆角的Button - ArcButton"
                val color = ARandom.color()
                textColor = if (AView.isLightColor(color))Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                onClick { startActivity<ArcButtonActivity>() }
            }.lparams(
                width = matchParent,
                height = dip(40)
            ){
                margin = dip(5)
            }
        }
    }
}
