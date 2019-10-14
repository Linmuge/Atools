package com.gushenge.atools.demo.activity.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.RollingTextView
import com.gushenge.atools.ui.rollingTextView
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.sp
import org.jetbrains.anko.textColor
import org.jetbrains.anko.verticalLayout

class RollingTextViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("RollingTextView").init(viewManager = this,activity = this@RollingTextViewActivity)
            rollingTextView{
                setContent("60")
                textSize = sp(13).toFloat()
                gravity = Gravity.CENTER
                setFrameNum(120)
                textColor = Color.RED
                setTextType(RollingTextView.NUM)
            }.lparams(matchParent, matchParent)
        }
    }
}
