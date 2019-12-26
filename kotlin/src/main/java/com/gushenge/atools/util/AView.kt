package com.gushenge.atools.util

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log.e
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi
import androidx.core.graphics.ColorUtils
import com.gushenge.atools.dao.AKeys

class AView {
    companion object{

        /**
         * @param view 需要设置高度的view
         * @param heightAsPx 需要设置的高度,单位为px
         * @author Gushenge
         * @version 0.2.0-pre_alpha
         * */
        fun setHeight(view: View, heightAsPx: Int) {
            val pp = view.layoutParams
            pp.height = heightAsPx
            view.layoutParams = pp
        }

        /**
         * @param view 需要设置宽度的view
         * @param widthAsPx 需要设置的宽度,单位为px
         * @author Gushenge
         * @version 0.2.0-pre_alpha
         * */
        fun setWidth(view: View, widthAsPx: Int) {
            val pp = view.layoutParams
            pp.width = widthAsPx
            view.layoutParams = pp
        }

        /**
         * @param color 当前颜色值,类型为Int
         * @author Gushenge
         * @version 0.0.8
         * @return Boolean
         * @description 判断当前颜色值是不是亮色 true为亮色 false为暗色
         * */
        fun isLightColor(@ColorInt color: Int): Boolean {
            return ColorUtils.calculateLuminance(color) >= 0.5
        }

        /**
         * @param context 当前Activity
         * @author Gushenge
         * @version 0.0.8
         * @return Int
         * @description 获取当前状态栏高度,返回值为px
         * */
        fun getStatusBarHeight(context: Activity): Int {
            val res = context.resources
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
         * @version 0.0.8
         * @return @null
         * @description 动态设置view的margin,值为int,单位为px
         * */
        fun setMargins(view: View, start: Int, top: Int, end: Int, bottom: Int) {
            if (view.layoutParams is ViewGroup.MarginLayoutParams) {
                val p = view.layoutParams as ViewGroup.MarginLayoutParams
                p.setMargins(start, top, end, bottom)
                view.layoutParams = p
            }
        }


        /**
         * @param context 当前Activity
         * @param isTextColorBlack 状态栏字体颜色是否为黑色 true为黑色 false为白色
         * @param NavigationBarColor 虚拟键的背景颜色
         * @author Gushenge
         * @version 0.0.9
         * @description 动态设置透明状态栏以及状态栏字体颜色
         */
        fun setStatusBar(
            context: Activity,
            isTextColorBlack: Boolean = true,
            NavigationBarColor: Int = Color.BLACK
        ) {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                val window = context.window
                val decorView = window.decorView
                if (isTextColorBlack) {
                    decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
                } else {
                    decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                }
                window.statusBarColor = Color.TRANSPARENT
                window.navigationBarColor = NavigationBarColor
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }else{
                e(AKeys.TAG,"您可能在低于Android5.0的设备中使用此方法，请注意")
            }


        }

        /**
         * @param context 当前Activity
         * @param enable 是否隐藏
         * @author Gushenge
         * @version 0.0.9
         * @description 动态隐藏显示状态栏
         * */
        fun hideStatusBar(context: Activity,enable: Boolean) {
            val lp = context.window.attributes
            if (enable) {
                lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
            } else {
                lp.flags = lp.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
            }
            context.window.attributes = lp
        }
        /**
         * @param context 当前Activity
         * @author Gushenge
         * @version 0.1.0
         * @description 是否全屏显示当前Activity
         * */
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun fullScreen(context: Activity){

            val windowManager = context.window
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
        fun getScreenHeight(context: Context): Int {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
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
        fun getDisplayScreenHeight(context: Context): Int {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
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
        fun getDisplayScreenDensity(context: Context): Float {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
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
        fun getVirtualBarHeight(context: Context): Int {
            return getScreenHeight(context) - getDisplayScreenHeight(context)
        }
    }

}