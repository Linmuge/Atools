package com.gushenge.atools.demo.activity

import android.os.Bundle
import com.gushenge.appshare.utils.anko.startActivity
import com.gushenge.atools.demo.activity.util.*
import com.gushenge.atools.demo.databinding.ActivityUtilsBinding
import com.gushenge.atools.demo.ui.finish
import com.gushenge.atools.demo.ui.init
import initColor

class UtilsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityUtilsBinding.inflate(layoutInflater).let {
            setContentView(it.root)
            it.titleView.init("Utils演示").finish(this)
            it.btADate.initColor().setOnClickListener {
                startActivity<ADateActivity>()
            }
            it.btARandom.initColor().setOnClickListener {
                startActivity<ARandomActivity>()
            }
            it.btAView.initColor().setOnClickListener {
                startActivity<AViewActivity>()
            }
            it.btASystem.initColor().setOnClickListener {
                startActivity<ASystemActivity>()
            }
            it.btKeyboard.initColor().setOnClickListener {
                startActivity<KeyboardActivity>()
            }
            it.btAPreference.initColor().setOnClickListener {
                startActivity<APreferenceActivity>()
            }
        }
    }

}
