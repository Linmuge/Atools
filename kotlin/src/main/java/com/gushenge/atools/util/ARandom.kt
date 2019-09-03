package com.gushenge.atools.util

import android.graphics.Color
import java.util.*

class ARandom {
    companion object{

        /**
         * @author Gushenge
         * @version 0.0.7
         * @return Int 颜色的rgb值
         * @description 获取随机颜色
         * */
        fun color(): Int {
            val random = Random()
            var r = 0
            var g = 0
            var b = 0
            for (i in 0..1) {
                var temp = random.nextInt(16)
                r = r * 16 + temp
                temp = random.nextInt(16)
                g = g * 16 + temp
                temp = random.nextInt(16)
                b = b * 16 + temp
            }
            return Color.rgb(r, g, b)
        }
    }
}