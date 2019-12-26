package com.gushenge.atools.demo.activity.util

import android.os.Bundle
import android.widget.Toast
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.util.keyboard.KeyboardWatcher
import org.jetbrains.anko.editText
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.verticalLayout
import org.jetbrains.anko.wrapContent

class KeyboardActivity : BaseActivity() {

    private lateinit var keyboardWatcher: KeyboardWatcher
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("键盘监听").init(this, this@KeyboardActivity)
            editText {

            }.lparams(matchParent, wrapContent)
        }
    }

    override fun onStart() {
        super.onStart()
        keyboardWatcher = KeyboardWatcher.get().init(this, window.decorView) { isShow, height ->
            if (isShow) {
                Toast.makeText(application, "键盘显示了！高度为：$height", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(application, "键盘隐藏了！高度为：$height", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        keyboardWatcher.remove()
    }
}
