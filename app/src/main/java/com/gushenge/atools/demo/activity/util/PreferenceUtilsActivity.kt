package com.gushenge.atools.demo.activity.util

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import com.gushenge.atools.util.PreferenceUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class PreferenceUtilsActivity : AppCompatActivity() {

    var value by PreferenceUtils("value","当前为默认值：0")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        verticalLayout {
            val title = titlebar("PreferenceUtils").init(viewManager = this,activity = this@PreferenceUtilsActivity)
            verticalLayout {
                val editText = editText {
                    hint = "请输入要存的值"
                }.lparams(width = matchParent,height = dip(45)){
                    margin = dip(5)
                }

                arcButton {
                    text = "存值"
                    val color = RandomUtils.color()
                    textColor = if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                    backgroundColor = color
                    onClick {
                        value = editText.text.toString()
                        toast("存值成功，值为$value")
                    }
                }.lparams(width = matchParent,height = dip(45)){
                    margin = dip(5)
                }
                arcButton {
                    text = "取值"
                    val color = RandomUtils.color()
                    textColor = if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                    backgroundColor = color
                    onClick {
                        toast(value)
                    }
                }.lparams(width = matchParent,height = dip(45)){
                    margin = dip(5)
                }


                textView("初始化"){
                    textSize = sp(7).toFloat()
                    textColor = RandomUtils.color()
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("Atools.init(context:Application).preference(spName:String)"){
                    textSize = sp(5).toFloat()
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("使用"){
                    textSize = sp(7).toFloat()
                    textColor = RandomUtils.color()
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("var test by PreferenceUtils(\"test\",T)"){
                    textSize = sp(5).toFloat()
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("存值"){
                    textSize = sp(7).toFloat()
                    textColor = RandomUtils.color()
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("test=1 or test=\"1\" or test=true"){
                    textSize = sp(5).toFloat()
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("取值"){
                    textSize = sp(7).toFloat()
                    textColor = RandomUtils.color()
                    gravity = Gravity.CENTER
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }
                textView("exsample: textview.text = test"){
                    textSize = sp(5).toFloat()
                    gravity = Gravity.CENTER
                    textColor = Color.BLACK
                }.lparams(width = matchParent,height = dip(30)){
                    margin = dip(5)
                }


            }
        }
    }

}
