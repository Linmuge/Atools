package com.gushenge.atools.util

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.core.graphics.ColorUtils
import com.gushenge.atools.dao.AKeys

/**
 * @param heightAsPx 需要设置的高度,单位为px
 * @author Gushenge
 * @version 0.2.0
 * */
fun View.setHeight(heightAsPx: Int) {
    val pp = this.layoutParams
    pp.height = heightAsPx
    this.layoutParams = pp
}

/**
 * @param widthAsPx 需要设置的宽度,单位为px
 * @author Gushenge
 * @version 0.2.0
 * */
fun View.setWidth(widthAsPx: Int) {
    val pp = this.layoutParams
    pp.width = widthAsPx
    this.layoutParams = pp
}


/**
 * @author Gushenge
 * @version 0.2.0
 * @return Boolean
 * @description 判断当前颜色值是不是亮色 true为亮色 false为暗色
 * */
fun Int.isLightColor(): Boolean {
    return ColorUtils.calculateLuminance(this) >= 0.5
}


/**
 * @author Gushenge
 * @version 0.2.0
 * @return Int
 * @description 获取当前状态栏高度,返回值为px
 * */
fun Activity.getStatusBarHeight(): Int {
    val res = resources
    val resourceId = res.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) res.getDimensionPixelSize(resourceId) else 0
}

/**
 * @param view 需要设置margin的view
 * @param start 距左边的距离,单位为px
 * @param top 距上边的距离,单位为px
 * @param end 距右边的距离,单位为px
 * @param bottom 距下边的距离,单位为px
 * @author Gushenge
 * @version 0.2.0
 * @return @null
 * @description 动态设置view的margin,值为int,单位为px
 * */
fun View.setMargins(start: Int, top: Int, end: Int, bottom: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(start, top, end, bottom)
        this.layoutParams = p
    }
}


/**
 * @param context 当前Activity
 * @param isTextColorBlack 状态栏字体颜色是否为黑色 true为黑色 false为白色
 * @param NavigationBarColor 虚拟键的背景颜色
 * @author Gushenge
 * @version 0.2.0
 * @description 动态设置透明状态栏以及状态栏字体颜色
 */
fun Activity.setStatusBar(isTextColorBlack: Boolean = true, NavigationBarColor: Int = Color.BLACK) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        val window = window
        val decorView = window.decorView
        if (isTextColorBlack) {
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        } else {
            decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = NavigationBarColor
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    } else {
        Log.e(AKeys.TAG, "您可能在低于Android5.0的设备中使用此方法，请注意")
    }
}

/**
 * @param context 当前Activity
 * @param enable 是否隐藏
 * @author Gushenge
 * @version 0.2.0
 * @description 动态隐藏显示状态栏
 * */
fun Activity.hideStatusBar(enable: Boolean) {
    val lp = window.attributes
    if (enable) {
        lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
    } else {
        lp.flags = lp.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
    }
    window.attributes = lp
}

/**
 * @param context 当前Activity
 * @author Gushenge
 * @version 0.2.0
 * @description 是否全屏显示当前Activity
 * */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.fullScreen() {

    val windowManager = window
    val lp = windowManager.attributes
    lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
    windowManager.attributes = lp

    val decorView = windowManager.decorView
    val option = View.SYSTEM_UI_FLAG_IMMERSIVE or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    decorView.systemUiVisibility = option
    windowManager.statusBarColor = Color.TRANSPARENT
}

/**
 * 获取的屏幕真实高度(含虚拟键所占空间)
 * @param context
 * @version 0.2.0
 * @return
 */
fun Context.getScreenHeight(): Int {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    val realMetric = DisplayMetrics()
    try {
        val c = Class.forName("android.view.Display")
        val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
        method.invoke(display, realMetric)
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return realMetric.heightPixels
}

/**
 * 获取的当前显示屏幕的高度(不包含虚拟键所占空间)
 * @param context
 * @return
 */
fun Context.getDisplayScreenHeight(): Int {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    //获取的像素宽高不包含虚拟键所占空间
    val metric = DisplayMetrics()
    display.getMetrics(metric)
    return metric.heightPixels
}

/**
 * 获取屏幕的密度
 * @param context
 * @return
 */
fun Context.getDisplayScreenDensity(): Float {
    val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    //获取的像素宽高不包含虚拟键所占空间
    val metric = DisplayMetrics()
    display.getMetrics(metric)
    return metric.density
}

/**
 * 获取虚拟功能键高度
 * @param context
 * @return
 */
fun Context.getVirtualBarHeight(): Int {
    return getScreenHeight() - getDisplayScreenHeight()
}