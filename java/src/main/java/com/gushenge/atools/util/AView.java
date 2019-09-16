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
     * @param color 当前颜色值,类型为Int
     * @author Gushenge
     * @version 0.0.8
     * @return Boolean
     * @description 判断当前颜色值是不是亮色 true为亮色 false为暗色
     * */
    public static Boolean isLightColor(@ColorInt int color){
        return ColorUtils.calculateLuminance(color) >= 0.5;
    }

    /**
     * @param context 当前Activity
     * @author Gushenge
     * @version 0.0.8
     * @return Int
     * @description 获取当前状态栏高度,返回值为px
     * */
    public static int getStatusBarHeight(Activity context) {
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            return res.getDimensionPixelSize(resourceId);
        else
            return 0;

    }
    /**
     * @param view 需要设置margin的view
     * @param start 距左边的距离,单位为px
     * @param top 距上边的距离,单位为px
     * @param end 距右边的距离,单位为px
     * @param bottom 距下边的距离,单位为px
     * @author Gushenge
     * @version 0.0.8
     * @return @null
     * @description 动态设置view的margin,值为int,单位为px
     * */
    public static void setMargins(View view,int start,int top,int end,int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p =(ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(start, top, end, bottom);
            view.setLayoutParams(p);
        }
    }



    /**
     * @param context 当前Activity
     * @param isTextColorBlack 状态栏字体颜色是否为黑色 true为黑色 false为白色
     * @param NavigationBarColor 虚拟键的背景颜色
     * @author Gushenge
     * @version 0.0.9
     * @description 动态设置透明状态栏以及状态栏字体颜色
     */
    public static void setStatusBar( Activity context, Boolean isTextColorBlack,int NavigationBarColor)  {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window = context.getWindow();
            View decorView = window.getDecorView();
            if (isTextColorBlack) {
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
    /**
     * @param context 当前Activity
     * @author Gushenge
     * @version 0.0.9
     * @description 动态设置透明状态栏以及状态栏字体颜色
     */
    public static void setStatusBar(Activity context){
        setStatusBar(context,true,Color.BLACK);
    }
    /**
     * @param context 当前Activity
     * @param isTextColorBlack 状态栏字体颜色是否为黑色 true为黑色 false为白色
     * @author Gushenge
     * @version 0.0.9
     * @description 动态设置透明状态栏以及状态栏字体颜色
     */
    public static void setStatusBar(Activity context,Boolean isTextColorBlack){
        setStatusBar(context,isTextColorBlack,Color.BLACK);
    }

    /**
     * @param context 当前Activity
     * @param enable 是否隐藏
     * @author Gushenge
     * @version 0.0.9
     * @description 动态隐藏显示状态栏
     * */
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
    /**
     * @param context 当前Activity
     * @author Gushenge
     * @version 0.1.0
     * @description 是否全屏显示当前Activity
     * */
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
