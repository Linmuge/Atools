package com.gushenge.atools.util

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import com.gushenge.atools.dao.AKeys

class ASystem {
    companion object{

        fun getAppVersionCode(context: Context) :Long {
            var versionCode: Long = 1
            val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)

            try {
                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.P){
                    versionCode = packageInfo.longVersionCode
                }else {
                    versionCode = packageInfo.versionCode.toLong()
                }
            }catch (e: PackageManager.NameNotFoundException){
                Log.e(AKeys.TAG,"获取VersionCode出错")
            }

            return versionCode
        }
    }
}