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
import java.lang.NumberFormatException
import java.text.ParseException

class DateUtilsActivity : AppCompatActivity() {


    lateinit var time:EditText
    lateinit var stamp:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        verticalLayout {
            titlebar("DateUtils演示").init(viewManager = this,activity = this@DateUtilsActivity)
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
                stamp = editText {
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
                        if(stamp.text.isNotEmpty()&&time.text.isNotEmpty()){
                            time.setText(DateUtils.getDate())
                            stamp.setText(DateUtils.getStamp())
                        }else{
                            if (stamp.text.isNotEmpty()){
                                time.setText(DateUtils.stampToDate(stamp.text.trim().toString().toInt()))
                            }else if (time.text.isNotEmpty()){
                                try {
                                    stamp.setText(DateUtils.dateToStamp(time.text.trim().toString()))
                                }catch (e:ParseException){
                                    toast("时间格式不对")
                                }
                            }else{
                                time.setText(DateUtils.getDate())
                                stamp.setText(DateUtils.getStamp())
                            }
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
            arcButton {
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                text = "stampToDate()-时间戳转换为日期"
                onClick {
                    if(stamp.text.isNotEmpty()){
                        time.setText(DateUtils.stampToDate(stamp.text.toString().toInt()))
                    }else{
                        toast("时间戳为空")
                    }
                }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                text = "dateToStamp()-日期转换为时间戳"
                onClick {
                    if(time.text.isNotEmpty()){
                        stamp.setText(
                            DateUtils.dateToStamp(time.text.toString()))
                    }else{
                        toast("日期为空")
                    }
                }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                text = "getDate()-获取当前日期"
                onClick {
                   time.setText(DateUtils.getDate())

                }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }
            arcButton {
                val color = RandomUtils.color()
                textColor = if (ViewUtils.isLightColor(color)) Color.BLACK else Color.WHITE
                backgroundColor = color
                allCaps = false
                textSize = sp(6).toFloat()
                text = "getStamp()-获取当前时间戳"
                onClick {
                    stamp.setText(DateUtils.getStamp())
                }
            }.lparams{
                width = matchParent
                height = dip(45)
                margin = dip(5)
            }

        }
    }
}
