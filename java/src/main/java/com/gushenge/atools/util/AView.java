package com.gushenge.atools.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.ColorUtils;
import com.gushenge.atools.dao.AKeys;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class AView {

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
     * Android 5.0 以上设置沉浸式状态栏
     * @param bgColorLight 状态栏背景是否是亮色
     */
    public static void setStatusBar( Activity activity, Boolean bgColorLight,int NavigationBarColor)  {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window = activity.getWindow();
            View decorView = window.getDecorView();
            if (bgColorLight) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                decorView.setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            }

            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(NavigationBarColor);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }else {
            Log.e(AKeys.TAG,"您可能在低于Android5.0的设备中使用此方法，请注意");
        }


    }
    public static void setStatusBar(Activity activity){
        setStatusBar(activity,true,Color.BLACK);
    }
    public static void setStatusBar(Activity activity,Boolean bgColorLight){
        setStatusBar(activity,bgColorLight,Color.BLACK);
    }

    /**隐藏显示状态栏
     * @param enable 是否隐藏*/
    public static void hideStatusBar( Activity context, Boolean enable) {
        if (enable) {
            WindowManager.LayoutParams lp = context.getWindow().getAttributes();
            lp.flags = lp.flags | FLAG_FULLSCREEN;
            context.getWindow().setAttributes(lp);
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else {
            WindowManager.LayoutParams attr = context.getWindow().getAttributes();
            attr.flags = attr.flags & FLAG_FULLSCREEN;
            context.getWindow().setAttributes(attr);
            context.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }
    /*全屏*/
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    public static void fullScreen(Activity context){

        Window windowManager = context.getWindow();
        WindowManager.LayoutParams lp = windowManager.getAttributes();
        lp.flags = lp.flags | WindowManager.LayoutParams.FLAG_FULLSCREEN;
        windowManager.setAttributes(lp);

        View decorView = windowManager.getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        windowManager.setStatusBarColor(Color.TRANSPARENT);
    }
}
