package com.gushenge.atools.demo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gushenge.atools.demo.ui.titlebar
import org.jetbrains.anko.verticalLayout

class UtilsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        verticalLayout {
            titlebar("Utils演示",View.VISIBLE).init(viewManager = this,activity = this@UtilsActivity)

        }
    }
}
