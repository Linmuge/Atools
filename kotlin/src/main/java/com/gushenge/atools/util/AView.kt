package com.gushenge.atools.util

import android.app.Activity
import android.graphics.Color
import android.os.Build
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
         * 颜色是不是亮色
         * @true 亮色
         * @false 不是
         *
         **/
        fun isLightColor(@ColorInt color: Int): Boolean {
            return ColorUtils.calculateLuminance(color) >= 0.5
        }

        /*动态获取状态栏高度*/
        fun getStatusBarHeight(context: Activity): Int {
            val res = context.resources
            val resourceId = res.getIdentifier("status_bar_height", "dimen", "android")
            return if (resourceId > 0) res.getDimensionPixelSize(resourceId) else 0
        }
        /*动态设置margin*/
        fun setMargins(v: View, left: Int, top: Int, right: Int, bottom: Int) {
            if (v.layoutParams is ViewGroup.MarginLayoutParams) {
                val p = v.layoutParams as ViewGroup.MarginLayoutParams
                p.setMargins(left, top, right, bottom)
                v.layoutParams = p
            }
        }


        /**
         * Android 5.0 以上设置沉浸式状态栏
         * @param bgColorLight 状态栏背景是否是亮色（6.0以上可用）
         */
        fun setStatusBar(activity: Activity, bgColorLight: Boolean,NavigationBarColor:Int) {
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                val window = activity.window
                val decorView = window.decorView
                if (bgColorLight) {
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
        fun setStatusBar(activity: Activity){
            setStatusBar(activity,true,Color.BLACK)
        }

        /**隐藏显示状态栏
        * @param true 隐藏
         * @param false 显示*/
        fun hideStatusBar(context: Activity,enable: Boolean) {
            val lp = context.window.attributes
            if (enable) {
                lp.flags = lp.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
            } else {
                lp.flags = lp.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
            }
            context.window.attributes = lp
        }
        /*全屏*/
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun fullScreen(context: Activity, enable: Boolean){

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
    }
}