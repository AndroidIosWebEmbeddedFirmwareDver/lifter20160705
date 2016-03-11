package com.wxl.export.lifter.common.utils.common;

import android.util.Log;

/**
 * Created by Sintn on 16/1/11.
 */
public class LogUtil {
    public static String TAG = "我是打印小助手";

    public static void e(String info) {
        Log.e(TAG, info);
    }

    public static void d(String info) {
        Log.d(TAG, info);
    }

    public static void v(String info) {
        Log.v(TAG, info);
    }

    public static void w(String info) {
        Log.w(TAG, info);
    }
}
