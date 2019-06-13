package com.gushenge.atools.util

import androidx.annotation.ColorInt
import androidx.core.graphics.ColorUtils

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
    }
}