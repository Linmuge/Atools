package com.gushenge.atools.demo.activity

import android.os.Bundle
import browse
import com.gushenge.atools.demo.databinding.ActivityAboutBinding
import com.gushenge.atools.demo.ui.finish
import com.gushenge.atools.demo.ui.init
import initColor

class AboutActivity : BaseActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityAboutBinding.inflate(layoutInflater).let {
            setContentView(it.root)
            it.titleView.init("关于").finish(this)
            it.btGithub.initColor().setOnClickListener {
                browse("https://github.com/Gushenge")
            }
            it.btGitee.initColor().setOnClickListener {
                browse("https://gitee.com/Gushenge")
            }
            it.btBlog.initColor().setOnClickListener {
                browse("https://www.gushenge.com")
            }
        }
    }
}
