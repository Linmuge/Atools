package com.gushenge.atools.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

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

    /*动态获取状态栏高度*/
    public static int getStatusBarHeight(Activity context) {
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            return res.getDimensionPixelSize(resourceId);
        else
            return 0;
    }
    /*动态设置margin*/
    public static void setMargins(View v,int left,int top,int right,int bottom) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p =(ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            v.setLayoutParams(p);
        }
    }


    /**
     * Android 6.0 以上设置状态栏颜色
     */
    public static void setStatusBar( Activity activity, Boolean bgColorLight)  {
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        if (bgColorLight) {
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.WHITE);
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


    }
    public static void setStatusBar(Activity activity){
        setStatusBar(activity,true);
    }
}
