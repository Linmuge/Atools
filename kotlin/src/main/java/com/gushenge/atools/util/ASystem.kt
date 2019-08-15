package com.gushenge.atools.util

import android.content.Context
import android.content.Context.SENSOR_SERVICE
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Build
import android.util.Log
import com.gushenge.atools.dao.AKeys
import com.gushenge.atools.others.CommandUtil

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

        /**
         * 判断处理器基带等信息,超过两项及以上通过即为真机
         * 如此可以排除大部分模拟器
         * return false 为模拟器  */
        private fun emulatorCheck(context: Context): Boolean {
            var suspectCount = 0
            //判断是否存在光传感器来判断是否为模拟器
            val sensorManager = context.getSystemService(SENSOR_SERVICE) as SensorManager
            val sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
            if (null == sensor) {
                ++suspectCount
                Log.e("emulatorCheck: ", "光传感器不存在")

            }
            //读基带信息
            val basebandVersion = CommandUtil().getProperty("gsm.version.baseband")
            if ((basebandVersion == null) or ("" == basebandVersion)) {
                ++suspectCount
                Log.e("emulatorCheck: ", "基带不存在")

            }
            //读处理器信息，这里经常会被处理
            val productBoard = CommandUtil().getProperty("ro.product.board")
            if ((productBoard == null) or ("" == productBoard)) {
                ++suspectCount
                Log.e("emulatorCheck: ", "处理器不存在")

            }
            //读处理器平台，这里不常会处理
            val boardPlatform = CommandUtil().getProperty("ro.board.platform")
            if ((boardPlatform == null) or ("" == boardPlatform)) {
                ++suspectCount
                Log.e("emulatorCheck: ", "处理器平台不存在")

            }
            if (Build.BRAND != "HUAWEI") {
                //读渠道信息，针对一些基于vbox的模拟器
                val buildFlavor = CommandUtil().getProperty("ro.build.flavor")
                if ((buildFlavor == null) or ("" == buildFlavor) or (buildFlavor != null && buildFlavor!!.contains("vbox"))) {
                    ++suspectCount
                    /*华为手机读不到渠道信息*/
                    Log.e("emulatorCheck: ", "渠道信息不存在")

                }
                //高通的cpu两者信息一般是一致的
                if (productBoard != null && boardPlatform != null && productBoard != boardPlatform) {
                    ++suspectCount
                    Log.e("emulatorCheck: ", "处理器信息不一致")
                }
            }
            //一些模拟器读取不到进程租信息
            val filter = CommandUtil().exec("cat /proc/self/cgroup")
            if (filter == null || filter!!.length == 0) {
                ++suspectCount
                Log.e("emulatorCheck: ", "进程组信息不存在")

            }
            return suspectCount < 2
        }
    }
}