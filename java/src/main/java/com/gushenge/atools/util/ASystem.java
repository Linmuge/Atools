package com.gushenge.atools.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;
import com.gushenge.atools.dao.AKeys;
import com.gushenge.atools.others.CommandUtil;

import static android.content.Context.SENSOR_SERVICE;

public class ASystem {


    /**
     * @param context 当前界面上下文
     * @author Gushenge
     * @version 0.0.9
     * @return Long
     * @description 获取当前APP的versionCode
     * */
    public static long getAppVersionCode( Context context)  {
        long versionCode = 1;

        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.P){
                versionCode = packageInfo.getLongVersionCode();
            }else {
                versionCode = packageInfo.versionCode;
            }
        }catch ( PackageManager.NameNotFoundException e){
            Log.e(AKeys.TAG,"获取VersionCode出错");
        }

        return versionCode;
    }


    /**
     * @param context 当前界面上下文
     * @author Gushenge
     * @version 0.1.1
     * @return Long true为真机 false为模拟器
     * @description 判断处理器基带等信息,超过两项及以上通过即为真机,如此可以排除大部分模拟器
     * @log 新增华为手机判断
     * */
    public Boolean emulatorCheck(Context context) {
        int suspectCount = 0;
        //判断是否存在光传感器来判断是否为模拟器
        SensorManager sensorManager = (SensorManager)context.getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (null == sensor) {
            ++suspectCount;
            Log.e( "emulatorCheck: ","光传感器不存在" );

        }
        //读基带信息
        String basebandVersion = CommandUtil.getSingleInstance().getProperty("gsm.version.baseband");
        if (basebandVersion == null | "".equals(basebandVersion)){
            ++suspectCount;
            Log.e( "emulatorCheck: ","基带不存在" );

        }
        //读处理器信息，这里经常会被处理
        String productBoard = CommandUtil.getSingleInstance().getProperty("ro.product.board");
        if (productBoard == null | "".equals(productBoard)){
            ++suspectCount;
            Log.e( "emulatorCheck: ","处理器不存在" );

        }
        //读处理器平台，这里不常会处理
        String boardPlatform = CommandUtil.getSingleInstance().getProperty("ro.board.platform");
        if (boardPlatform == null | "".equals(boardPlatform)){
            ++suspectCount;
            Log.e( "emulatorCheck: ","处理器平台不存在" );

        }
        if (!Build.BRAND.equals("HUAWEI")){
            //读渠道信息，针对一些基于vbox的模拟器
            String buildFlavor = CommandUtil.getSingleInstance().getProperty("ro.build.flavor");
            if (buildFlavor == null | "".equals(buildFlavor) | (buildFlavor != null && buildFlavor.contains("vbox"))){
                ++suspectCount;
                /*华为手机读不到渠道信息*/
                Log.e( "emulatorCheck: ","渠道信息不存在" );

            }
            //高通的cpu两者信息一般是一致的
            if (productBoard != null && boardPlatform != null && !productBoard.equals(boardPlatform)){
                ++suspectCount;
                Log.e( "emulatorCheck: ","处理器信息不一致" );
            }
        }
        //一些模拟器读取不到进程租信息
        String filter = CommandUtil.getSingleInstance().exec("cat /proc/self/cgroup");
        if (filter == null || filter.length() == 0){
            ++suspectCount;
            Log.e( "emulatorCheck: ","进程组信息不存在" );

        }
        return suspectCount < 2;
    }

}
