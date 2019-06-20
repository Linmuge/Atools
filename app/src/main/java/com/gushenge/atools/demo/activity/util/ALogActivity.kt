package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.EditText
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.ALog
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.ASystem
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ALogActivity : BaseActivity() {

    lateinit var tag1:EditText
    lateinit var message:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("ALog").init(this,this@ALogActivity)
            linearLayout {
                tag1 = editText {
                    hint = "TAG"
                    gravity = Gravity.CENTER
                }.lparams(0, matchParent){
                    weight =1.toFloat()
                }
                message = editText {
                    hint = "Message"
                    gravity = Gravity.CENTER
                }.lparams(0, matchParent){
                    weight =1.toFloat()
                }
            }.lparams(matchParent,dip(45)){
                margin = dip(5)
            }
            arcButton("ALog.d(TAG,Message)") {
                var color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                onClick {
                    toast("请去logcat面板查看")
                    ALog.d(tag1.text.toString(),message.text.toString())
                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
            arcButton("ALog.e(TAG,Message)") {
                var color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                onClick {
                    toast("请去logcat面板查看")
                    ALog.e(tag1.text.toString(),message.text.toString())
                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
            arcButton("ALog.w(TAG,Message)") {
                var color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                onClick {
                    toast("请去logcat面板查看")
                    ALog.w(tag1.text.toString(),message.text.toString())
                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
            arcButton("ALog.i(TAG,Message)") {
                var color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                onClick {
                    toast("请去logcat面板查看")
                    ALog.i(tag1.text.toString(),message.text.toString())
                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
            arcButton("ALog.v(TAG,Message)") {
                var color = ARandom.color()
                textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                onClick {
                    toast("请去logcat面板查看")
                    ALog.v(tag1.text.toString(),message.text.toString())
                }
            }.lparams(width = matchParent,height = dip(40)){
                margin = dip(5)
            }
        }
    }
}
