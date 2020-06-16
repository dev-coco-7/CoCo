package com.bat.studio.utils;

import android.util.DisplayMetrics;

import com.bat.studio.base.BaseApplication;

public class DeviceUtils {

    public static int dp2px(int dp) {
        DisplayMetrics metrics = BaseApplication.getApplication().getResources().getDisplayMetrics();
        return (int) (metrics.density * dp + 0.5f);
    }

    public static int getScreenWidth() {
        DisplayMetrics metrics = BaseApplication.getApplication().getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics metrics = BaseApplication.getApplication().getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }
}
