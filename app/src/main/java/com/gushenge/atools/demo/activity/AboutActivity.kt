package com.gushenge.atools.demo.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class AboutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        verticalLayout {
            titlebar("关于", View.VISIBLE).init(viewManager = this, activity = this@AboutActivity)
            arcButton {
                val color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                text = "Github"
                allCaps = false
                onClick { browse("https://github.com/Gushenge") }
            }.lparams {
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = ARandom.color()
                textColor = if(AView.isLightColor(color))Color.BLACK else Color.WHITE
                backgroundColor = color
                text = "码云"
                allCaps = false
                onClick { browse("https://gitee.com/Gushenge") }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = ARandom.color()
                textColor = if(AView.isLightColor(color))Color.BLACK else Color.WHITE
                backgroundColor = color
                text = "Coding"
                allCaps = false
                onClick { browse("https://dev.tencent.com/u/Gushenge") }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = ARandom.color()
                textColor = if(AView.isLightColor(color))Color.BLACK else Color.WHITE
                backgroundColor = color
                text = "GitLab"
                allCaps = false
                onClick { browse("https://gitlab.com/Gushenge") }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = ARandom.color()
                textColor = if(AView.isLightColor(color))Color.BLACK else Color.WHITE
                backgroundColor = color
                text = "个人博客"
                allCaps = false
                onClick { browse("https://www.gushenge.com") }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
        }
    }
}
