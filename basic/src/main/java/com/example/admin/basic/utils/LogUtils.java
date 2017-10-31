package com.example.admin.basic.utils;

import android.util.Log;

/**
 * Created by admin on 2017/10/31.
 */

public class LogUtils {
    private static boolean isEnable=true;
    private static String TAG = "APP_LOG_SHOW";

    public static void setEnable(boolean enable) {
        if (isEnable) {
            isEnable = enable;
        }
    }

    public static void e(String message) {
        if (isEnable) {
            Log.e(TAG, message);
        }
    }

    public static void d(String message) {
        if (isEnable) {
            Log.d(TAG, message);
        }
    }

    public static void i(String message) {
        if (isEnable) {
            Log.i(TAG, message);
        }
    }

    public static void v(String message) {
        if (isEnable) {
            Log.v(TAG, message);
        }
    }

    public static void w(String message) {
        if (isEnable) {
            Log.v(TAG, message);
        }
    }
}
