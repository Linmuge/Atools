package com.gushenge.atools.util;

import android.graphics.Color;

import java.util.Random;

public class ARandom {

    /**
     * @author Gushenge
     * @version 0.0.7
     * @return Int 颜色的rgb值
     * @description 获取随机颜色
     * */
    public static int getColor(){
        Random random=new Random();
        int r=0;
        int g=0;
        int b=0;
        for(int i=0;i<2;i++){
            //       result=result*10+random.nextInt(10);
            int temp=random.nextInt(16);
            r=r*16+temp;
            temp=random.nextInt(16);
            g=g*16+temp;
            temp=random.nextInt(16);
            b=b*16+temp;
        }
        return Color.rgb(r,g,b);
    }
}
