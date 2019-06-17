package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class RandomUtilsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            titlebar("RandomUtils").init(viewManager = this,activity = this@RandomUtilsActivity)
            arcButton {
                text = "color()-点我随机切换按钮颜色"
                var color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                onClick {
                    color = RandomUtils.color()
                    textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                    backgroundColor = color

                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
        }

    }
}
