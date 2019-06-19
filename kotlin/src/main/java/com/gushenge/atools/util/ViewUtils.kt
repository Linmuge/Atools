package com.gushenge.atools.util

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils
import com.gushenge.atools.R

class ViewUtils {
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
         * Android 6.0 以上设置状态栏颜色
         */
        fun setStatusBar(activity: Activity, bgColorLight: Boolean) {
            val window = activity.window
            val decorView = window.decorView
            if (bgColorLight) {
                decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            } else {
                decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                window.statusBarColor = Color.TRANSPARENT
                window.navigationBarColor = Color.WHITE
            }
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)


        }
        fun setStatusBar(activity: Activity){
            setStatusBar(activity,true)
        }

    }
}