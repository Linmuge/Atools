package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ViewUtilsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("ViewUtils").init(viewManager = this,activity = this@ViewUtilsActivity)
            arcButton {
                text = "isLightColor()-判断当前颜色是否是亮色"
                var color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                allCaps = false
                backgroundColor = color
                textSize = sp(6).toFloat()
                onClick {
                    toast(ViewUtils.isLightColor(color).toString())
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
