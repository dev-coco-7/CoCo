package com.bat.studio.base;

import android.app.Application;

import java.lang.reflect.InvocationTargetException;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 反射获取当前application单例
     */
    private static BaseApplication baseApplication = null;

    public static BaseApplication getApplication() {
        if (baseApplication == null) {
            try {
                baseApplication = (BaseApplication) Class.forName("android.app.ActivityThread")
                        .getMethod("currentApplication")
                        .invoke(null, (Object[]) null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return baseApplication;
    }
}
