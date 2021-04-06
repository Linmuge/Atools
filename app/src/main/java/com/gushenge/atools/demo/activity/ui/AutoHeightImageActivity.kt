package com.gushenge.atools.demo.activity.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.gushenge.atools.demo.R
import com.gushenge.atools.demo.activity.BaseActivity
import com.gushenge.atools.demo.databinding.ActivityAutoheightimageviewBinding
import com.gushenge.atools.demo.ui.finish
import com.gushenge.atools.demo.ui.init
import initColor
import org.jetbrains.anko.toast

class AutoHeightImageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityAutoheightimageviewBinding.inflate(layoutInflater).let {
            setContentView(it.root)
            it.titleView.init("AutoHeightImageView").finish(this)
            it.btLoadNetworkImage.initColor().setOnClickListener { v ->
                Glide.with(this)
                    .load(it.etLink.text.toString().trim())
                    .error(R.drawable.autoimage)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>?,
                            isFirstResource: Boolean
                        ): Boolean {
                            toast("加载失败")
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable?,
                            model: Any?,
                            target: Target<Drawable>?,
                            dataSource: DataSource?,
                            isFirstResource: Boolean
                        ): Boolean {
                            toast("加载成功")
                            it.ivImage.setImageDrawable(resource)
                            return true
                        }
                    })
                    .into(it.ivImage)
            }
        }
    }
}
