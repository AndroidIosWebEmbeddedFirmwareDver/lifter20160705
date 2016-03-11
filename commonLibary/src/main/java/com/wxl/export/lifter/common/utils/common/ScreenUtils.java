package com.wxl.export.lifter.common.utils.common;

import android.app.KeyguardManager;
import android.content.Context;

/**
 * Created by Administrator on 2016/1/15 0015.
 */
public class ScreenUtils {
    public static ScreenUtils screenUtils = null;
//    private KeyguardManager km = null;
    private KeyguardManager.KeyguardLock kl = null;
    private Context context;

    public static ScreenUtils getInstense(Context context) {
        if(screenUtils == null) {
            screenUtils = new ScreenUtils(context);
        }
        return screenUtils;
    }

    private ScreenUtils(Context context) {
        this.context = context;
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        kl = km.newKeyguardLock("unLock");
    }

    public void lockedScreen() {
        //锁定
        kl.reenableKeyguard();
    }

    public void unlockedScreen() {
        //解锁
        kl.disableKeyguard();
    }
}
