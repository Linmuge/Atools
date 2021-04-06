package com.gushenge.atools.demo.activity.ui

import android.os.Bundle
import android.text.Html
import android.widget.SeekBar
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.databinding.ActivityArcbuttonBinding
import com.gushenge.atools.demo.ui.finish
import com.gushenge.atools.demo.ui.init
import initColor
import org.jetbrains.anko.toast

class ArcButtonActivity : BaseActivity() {

    var radius:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityArcbuttonBinding.inflate(layoutInflater).let {
            setContentView(it.root)
            it.titleView.init("ArcButton").finish(this)
            it.arcButton.initColor().setRadius(0f)
            it.arcButton.setOnClickListener {
                toast(radius.toString())
            }
            it.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    it.arcButton.setRadius(p1.toFloat())
                    radius = p1
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }
            })
            it.tvInfo.text =
                Html.fromHtml(
                    "<b><tt >属性说明:</tt></b><br/><br/>" +
                            "setRadius(radius:Int)控制的是Button圆角<br/>" +
                            "setBackgroundColor(normalColor: Int, pressedColor: Int)<br/>" +
                            "&nbsp&nbsp  <span style = 'color : #ff0000'>@normalColor</span>是按下前的背景颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>是按下后的背景颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>可为空,为空则点击不变色<br/>" +
                            "setTextColor(normalColor: Int, pressedColor: Int)<br/>" +
                            "&nbsp&nbsp  <span style = 'color : #ff0000'>@normalColor</span>是按下前的字体颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>是按下后的字体颜色<br/>" +
                            "&nbsp&nbsp <span style = 'color : #ff0000'>@pressedColor</span>可为空，为空则点击不变色"
                )
        }
    }
}
