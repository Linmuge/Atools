package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.EditText
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.DateUtils
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class DateUtilsActivity : AppCompatActivity() {


    lateinit var time:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        verticalLayout {
            titlebar("DateUtils演示", View.VISIBLE).init(viewManager = this,activity = this@DateUtilsActivity)
            linearLayout {

                textView("时间戳"){
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1.toFloat()
                }
                textView("转换"){
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1.toFloat()
                }
                textView("时间"){
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1.toFloat()
                }
            }.lparams{
                width = matchParent
                height = dip(45)
            }

            linearLayout {
                val stamp = editText {
                    hint = "时间戳"
                    gravity = Gravity.CENTER
                    inputType = InputType.TYPE_CLASS_NUMBER
                    maxEms = 10
                }.lparams{
                    width = 0
                    height = matchParent
                    weight =2.toFloat()
                }
                arcButton {
                    text = "转换"
                    onClick {
                        if (stamp.text.isNotEmpty()){
                            time.setText(DateUtils.stampToDate(stamp.text.trim().toString().toInt()))
                        }else{
                            stamp.setText(DateUtils.dateToStamp(time.text.trim().toString()))
                        }
                    }
                }.lparams{
                    width = 0
                    height = dip(45)
                    weight =1.toFloat()
                }
                time = editText {
                    hint ="2019-06-14 18:00:00"
                    gravity = Gravity.CENTER
                }.lparams{
                    width = 0
                    height = matchParent
                    weight =2.toFloat()
                }
            }.lparams{

                width = matchParent
                height = dip(100)
            }

        }
    }
}
