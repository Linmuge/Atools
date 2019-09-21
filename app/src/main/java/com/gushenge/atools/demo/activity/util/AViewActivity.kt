package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.widget.EditText
import com.gushenge.atools.demo.R
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.ARandom
import com.gushenge.atools.util.AView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class AViewActivity : BaseActivity() {

    lateinit var left1 :EditText
    lateinit var top1 :EditText
    lateinit var right1 :EditText
    lateinit var bottom1 :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("AView").init(viewManager = this, activity = this@AViewActivity)
            scrollView {
                verticalLayout {

                    arcButton {
                        text = "isLightColor()-判断当前颜色是否是亮色"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            toast(AView.isLightColor(color).toString())
                            color = ARandom.color()
                            textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                            backgroundColor = color
                        }
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }
                    arcButton {
                        text = "getStatusBarHeight()-获取状态栏高度"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            val height = AView.getStatusBarHeight(this@AViewActivity)
                            toast("当前状态栏高度为 $height px ")
                        }
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }

                    textView("------setMargins()------"){
                        gravity = Gravity.CENTER
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }
                    linearLayout {
                        left1 = editText {
                            hint = "left"
                            inputType = InputType.TYPE_CLASS_NUMBER
                        }.lparams(width = wrapContent, height = matchParent) {
                            weight = 1.toFloat()
                        }
                        top1 = editText {
                            hint = "top"
                            inputType = InputType.TYPE_CLASS_NUMBER
                        }.lparams(width = wrapContent, height = matchParent) {
                            weight = 1.toFloat()
                        }
                        right1 = editText {
                            hint = "right"
                            inputType = InputType.TYPE_CLASS_NUMBER
                        }.lparams(width = wrapContent, height = matchParent) {
                            weight = 1.toFloat()
                        }
                        bottom1 = editText {
                            hint = "bottom"
                            inputType = InputType.TYPE_CLASS_NUMBER
                        }.lparams(width = wrapContent, height = matchParent) {
                            weight = 1.toFloat()
                        }
                    }.lparams(width = matchParent, height = dip(45)) {
                        margin = dip(5)
                    }
                    arcButton {
                        text = "setMargins()-动态设置margin 单位px"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            try {
                                AView.setMargins(
                                    this@arcButton,
                                    left1.text.toString().toInt(),
                                    top1.text.toString().toInt(),
                                    right1.text.toString().toInt(),
                                    bottom1.text.toString().toInt()
                                )
                            } catch (e: NumberFormatException) {
                                toast("请检查有没有空值")
                            }
                        }
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }


                    textView("------setStatusBar()------"){
                        gravity = Gravity.CENTER
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }
                    arcButton {
                        text = "setStatusBar(context,true)-沉浸式状态栏"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            AView.setStatusBar(this@AViewActivity,true, R.color.colorPrimary)
                        }
                    }.lparams(width = matchParent, height = dip(45)) {
                        margin=dip(5)
                    }

                    arcButton {
                        text = "setStatusBar(context,false)-沉浸式状态栏"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            AView.setStatusBar(this@AViewActivity,false, R.color.colorPrimary)
                        }
                    }.lparams(width = matchParent, height = dip(45)) {
                       margin = dip(5)
                    }


                    textView("------hideStatusBar()------"){
                        gravity = Gravity.CENTER
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }
                    arcButton {
                        text = "hideStatusBar(context,true)-隐藏状态栏"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            AView.hideStatusBar(this@AViewActivity,true)
                        }
                    }.lparams(width = matchParent, height = dip(45)) {
                        margin=dip(5)
                    }

                    arcButton {
                        text = "hideStatusBar(context,false)-显示状态栏"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            AView.hideStatusBar(this@AViewActivity,false)
                        }
                    }.lparams(width = matchParent, height = dip(45)) {
                        margin=dip(5)
                    }
                    arcButton {
                        text = "fullScreen(context)-全屏显示当前Activity"
                        var color = ARandom.color()
                        textColor = if (AView.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            AView.fullScreen(this@AViewActivity)
                            longToast("标题栏是初始化时获取状态栏高度设置的View高度,所以高度不会发生变化")
                        }
                    }.lparams(width = matchParent, height = dip(45)) {
                        margin=dip(5)
                    }

                }
            }
        }
    }
}
