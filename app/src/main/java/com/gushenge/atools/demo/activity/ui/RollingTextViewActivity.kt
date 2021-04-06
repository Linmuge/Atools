package com.gushenge.atools.demo.activity.ui

import android.os.Bundle
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.databinding.ActivityRollingtextviewBinding
import com.gushenge.atools.demo.ui.finish
import com.gushenge.atools.demo.ui.init

class RollingTextViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityRollingtextviewBinding.inflate(layoutInflater).let {
            setContentView(it.root)
            it.titleView.init("RollingTextView").finish(this)
            it.rollingTextView.setContent("60")
        }
    }
}
