package com.gushenge.atools.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.gushenge.atools.dao.AKeys;

public class ASystem {


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
}
