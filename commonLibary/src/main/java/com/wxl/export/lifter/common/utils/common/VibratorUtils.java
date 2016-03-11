package com.wxl.export.lifter.common.utils.common;

import android.content.Context;
import android.os.Vibrator;

/**
 * 震动工具
 * Created by Administrator on 2016/1/5 0005.
 */
public class VibratorUtils {
    private static VibratorUtils vibratorUtils = null;
    /**
     * 手机振动器
     */
    private Vibrator vibrator = null;

    private VibratorUtils(Context context) {
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public static VibratorUtils getInstanse(Context context) {
        if(vibratorUtils == null) {
            vibratorUtils = new VibratorUtils(context);
        }
        return vibratorUtils;
    }

    public void play() {
//        long [] pattern = {100,400,100,400};   // 停止 开启 停止 开启
        long [] pattern = {100,400};   // 停止 开启 停止 开启
        vibrator.vibrate(pattern,-1);           //重复两次上面的pattern 如果只想震动一次，index设为-1
    }
}
