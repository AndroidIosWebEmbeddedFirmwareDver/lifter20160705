package com.wxl.export.lifter.common.utils.common;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

/**
 * com.wxl.export.lifter.common.utils.common
 * Sintn
 * Created by Sintn on 16/3/9 下午1:29.
 */
public class SystemShareUtil {
    /**
     * 分享纯文本
     *
     * @param activity
     * @param shareContent
     */
    public static void share(Activity activity, String shareContent) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareContent);
        sendIntent.setType("text/plain");
        activity.startActivity(sendIntent);
    }

    /**
     * 分享纯文本,并自定义弹窗口标题
     *
     * @param activity
     * @param shareContent
     * @param dialogTitle
     */
    public static void share(Activity activity, String shareContent, String dialogTitle) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareContent);
        sendIntent.setType("text/plain");
        activity.startActivity(Intent.createChooser(sendIntent, dialogTitle));
    }

    /**
     * 分享纯图片,并自定义弹窗口标题
     *
     * @param activity
     * @param shareImageUrl
     * @param dialogTitle
     */
    public static void share(Activity activity, Bitmap shareImageUrl, String dialogTitle) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, shareImageUrl);
        shareIntent.setType("image/jpeg");
        activity.startActivity(Intent.createChooser(shareIntent, dialogTitle));
    }
}
