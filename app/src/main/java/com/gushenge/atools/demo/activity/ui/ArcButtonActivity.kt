package com.gushenge.atools.demo.activity.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.SeekBar
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ArcButtonActivity : AppCompatActivity() {

    var radius:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            titlebar("ArcButton").init(viewManager = this ,activity = this@ArcButtonActivity)
            val button = arcButton {
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                setRadius(0)
                text = "点我查看圆角半径"
                onClick { toast(radius.toString()) }
            }.lparams(width = matchParent,height = dip(45)){
                margin = dip(5)
            }

            seekBar {
                max = dip(45)/2
                setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                        button.setRadius(p1)
                        radius = p1
                    }

                    override fun onStartTrackingTouch(p0: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(p0: SeekBar?) {

                    }
                })
            }.lparams(width = matchParent , height = dip(45)){
                margin = dip(5)
            }
            textView{
                text =
                    Html.fromHtml("<b><tt >属性说明:</tt></b><br/><br/>" +
                            "setRadius(radius:Int)控制的是Button圆角<br/>" +
                            "setBackgroundColor(normalColor: Int, pressedColor: Int)<br/>" +
                            "&nbsp&nbsp  <span style = 'color : #ff0000'>@normalColor</span>是按下前的背景颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>是按下后的背景颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>可为空,为空则点击不变色<br/>"+
                            "setTextColor(normalColor: Int, pressedColor: Int)<br/>" +
                            "&nbsp&nbsp  <span style = 'color : #ff0000'>@normalColor</span>是按下前的字体颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>是按下后的字体颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>可为空，为空则点击不变色")
                padding = dip(10)
            }
        }
    }
}
