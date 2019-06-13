package com.gushenge.atools.util;

import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;

public class ViewUtils {

    /**
     * 颜色是不是亮色
     * @true 亮色
     * @false 不是
     *
     **/
    public static Boolean isLightColor(@ColorInt int color){
        return ColorUtils.calculateLuminance(color) >= 0.5;
    }
}
