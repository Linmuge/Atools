package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import android.os.Bundle
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ARandomActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            titlebar("ARandom").init(viewManager = this,activity = this@ARandomActivity)
            arcButton {
                text = "color()-点我随机切换按钮颜色"
                var color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                onClick {
                    color = ARandom.color()
                    textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                    backgroundColor = color

                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
        }

    }
}
