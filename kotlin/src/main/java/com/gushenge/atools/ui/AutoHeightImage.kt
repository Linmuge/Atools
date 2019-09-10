package com.gushenge.atools.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.ceil

class AutoHeightImage : AppCompatImageView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val d = drawable
        d?.let {
            // ceil not round - avoid thin vertical gaps along the left/right edges
            val width = MeasureSpec.getSize(widthMeasureSpec)
            //高度根据使得图片的宽度充满屏幕计算而得
            val height = ceil((width.toFloat() * it.intrinsicHeight.toFloat() / it.intrinsicWidth.toFloat()).toDouble()).toInt()
            setMeasuredDimension(width, height)
        }
        d?:super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }
}
