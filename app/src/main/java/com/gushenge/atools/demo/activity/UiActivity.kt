package com.gushenge.atools.demo.activity

import android.os.Bundle
import com.gushenge.appshare.utils.anko.startActivity
import com.gushenge.atools.demo.activity.ui.ArcButtonActivity
import com.gushenge.atools.demo.activity.ui.AutoHeightImageActivity
import com.gushenge.atools.demo.activity.ui.RollingTextViewActivity
import com.gushenge.atools.demo.databinding.ActivityUiBinding
import com.gushenge.atools.demo.ui.finish
import com.gushenge.atools.demo.ui.init
import initColor

class UiActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityUiBinding.inflate(layoutInflater).let {
            setContentView(it.root)
            it.titleView.init("UI演示").finish(this)
            it.btArcButton.initColor().setOnClickListener {
                startActivity<ArcButtonActivity>()
            }
            it.btAutoHeightImageView.initColor().setOnClickListener {
                startActivity<AutoHeightImageActivity>()
            }
            it.btRollTextView.initColor().setOnClickListener {
                startActivity<RollingTextViewActivity>()
            }

        }
    }
}
