package com.gushenge.atools.demo.activity.ui

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.gushenge.atools.demo.R
import com.gushenge.atools.demo.ui.titlebar
import com.gushenge.atools.ui.AutoHeightImage
import com.gushenge.atools.ui.arcButton
import com.gushenge.atools.ui.autoHeightImage
import com.gushenge.atools.util.RandomUtils
import com.gushenge.atools.util.ViewUtils
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class AutoHeightImageActivity : AppCompatActivity() {

    lateinit var image:AutoHeightImage
    lateinit var edit:EditText;
    val context = this@AutoHeightImageActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            titlebar("AutoHeightImageView", View.VISIBLE).init(viewManager = this,activity = this@AutoHeightImageActivity)
            scrollView {
                verticalLayout(){
                    edit = editText(){
                        hint = "请输入可用的图片链接地址"
                    }
                    arcButton{
                        text = "从网络加载图片"
                        val color = RandomUtils.color()
                        textColor=if (ViewUtils.isLightColor(color))Color.BLACK else Color.WHITE
                        backgroundColor = color
                        onClick {
                            Glide.with(context)
                                .load(edit.text.toString().trim())
                                .error(R.drawable.autoimage)
                                .listener(object :RequestListener<Drawable>{
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
                                        image.setImageDrawable(resource)
                                        return true
                                    }
                                })
                                .into(image)
                        }
                    }.lparams(width = matchParent , height = dip(40)){
                        margin=dip(5)
                    }
                    image = autoHeightImage {
                        setImageResource(R.drawable.autoimage)
                    }
                }
            }
        }
    }
}
