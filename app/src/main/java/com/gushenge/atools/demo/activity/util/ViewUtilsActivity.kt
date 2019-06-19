package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.lang.NumberFormatException

class ViewUtilsActivity : AppCompatActivity() {

    lateinit var left1 :EditText
    lateinit var top1 :EditText
    lateinit var right1 :EditText
    lateinit var bottom1 :EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("ViewUtils").init(viewManager = this, activity = this@ViewUtilsActivity)
            scrollView {
                verticalLayout {

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
                    }.lparams(width = matchParent, height = dip(40)) {
                        margin = dip(5)
                    }
                    arcButton {
                        text = "getStatusBarHeight()-获取状态栏高度"
                        var color = RandomUtils.color()
                        textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            val height = ViewUtils.getStatusBarHeight(this@ViewUtilsActivity)
                            toast("当前状态栏高度为 $height px ")
                        }
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
                        var color = RandomUtils.color()
                        textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                        allCaps = false
                        backgroundColor = color
                        textSize = sp(6).toFloat()
                        onClick {
                            try {
                                ViewUtils.setMargins(
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
                }
            }
        }
    }
}
