package com.gushenge.atools.demo.ui

import android.app.Activity
import android.content.res.ColorStateList
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.gushenge.atools.demo.App
import com.gushenge.atools.demo.R
import com.gushenge.atools.demo.databinding.TitleviewBinding

fun TitleviewBinding.init(
    text: String,
    @ColorRes color: Int = R.color.black,
    moreText: String? = null
): TitleviewBinding {
    ivBack.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(App.instance, color))
    tvTitle.setTextColor(ContextCompat.getColor(App.instance, color))
    tvTitle.text = text
    if (moreText.isNullOrBlank()) {
        tvMore.visibility = View.GONE
    } else {
        tvMore.visibility = View.VISIBLE
        tvMore.text = moreText
    }
    return this
}

fun TitleviewBinding.finish(activity: Activity): TitleviewBinding {
    ivBack.setOnClickListener {
        activity.finish()
    }
    return this
}

fun TitleviewBinding.click(v: View.() -> Unit): TitleviewBinding {
    tvMore.setOnClickListener(v)
    return this
}