package com.gushenge.atools.util

import android.os.Build


fun isMiui(): Boolean {
    return Build.MANUFACTURER.equals("Xiaomi", true)
}