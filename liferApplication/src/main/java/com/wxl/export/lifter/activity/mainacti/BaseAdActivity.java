//package com.wxl.export.lifter.activity.mainacti;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//import android.view.View;
//
//import com.kyview.AdViewTargeting;
//import com.kyview.interfaces.AdInstlInterface;
//import com.kyview.screen.interstitial.AdInstlManager;
//import com.wxl.export.lifter.thread.TimerRunnable;
//
//
///**
// * com.wxl.export.lifter.lifter
// * Sintn
// * Created by Sintn on 16/3/4 下午4:52.
// */
//public abstract class BaseAdActivity extends BaseActivity implements AdInstlInterface {
//
////    public final static String APPID = "SDK20161304010357akwqc98x4dqpopb";
//    public final static String APPID = "SDK20141529031208v5avw087171hioq";
//    private AdInstlManager adInstlManager;
//    private static int requestAdMessageTag = 1002;
//    private static long requestAdMessageInn = 3 * 1000;
//    private Thread timerThread;
//    private TimerRunnable timerRunnable;
//    @SuppressLint("HandlerLeak")
//    private Handler mHander = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            System.out.println("------------------");
//            if (msg.what == requestAdMessageTag) {
//                requestAd();
//            }
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initInstlAd();
//        timerRunnable = new TimerRunnable(mHander, requestAdMessageInn, requestAdMessageTag);
//        timerThread = new Thread(timerRunnable);
//        timerThread.start();
//    }
//
//    private void initInstlAd() {
//        if (this.isFinishing()) return;
//        // 设置插屏可关闭
//        AdViewTargeting.setInstlSwitcherMode(AdViewTargeting.InstlSwitcher.CANCLOSED);
//        AdViewTargeting
//                .setInstlDisplayMode(AdViewTargeting.InstlDisplayMode.DIALOG_MODE);
//        // 设置大小只支持多盟
//        // AdViewTargeting.setAdWidthHeight(300, 250);
//        // 设置易传媒是可用，0代表全屏，1代表插屏,默认为0。
//        AdViewTargeting.setAdChinaView(0);
//        adInstlManager = new AdInstlManager(this, APPID);
//        adInstlManager.setAdInstlInterface(this);
//    }
//
//    private void requestAd() {
//        if (this.isFinishing()) return;
//        if (adInstlManager == null) initInstlAd();
//        // 请求与展示广告,单独使用
//        adInstlManager.requestAndshow();
//    }
//
//    @Override
//    public void onAdDismiss() {
//        Log.i("AdInstlActivity", "onAdDismiss");
//        timerRunnable = new TimerRunnable(mHander, requestAdMessageInn, requestAdMessageTag);
//        timerThread = new Thread(timerRunnable);
//        timerThread.start();
//    }
//
//    @Override
//    public void onClickAd() {
//        Log.i("AdInstlActivity", "onClickAd");
//    }
//
//    @Override
//    public void onDisplayAd() {
//        Log.i("AdInstlActivity", "onDisplayAd");
//    }
//
//    @Override
//    public void onReceivedAd(int arg0, View arg1) {
//        Log.i("AdInstlActivity", "onReceivedAd");
//    }
//
//    @Override
//    public void onReceivedAdFailed(String error) {
//        Log.i("AdInstlActivity", "onReceivedAdFailed");
//        timerRunnable = new TimerRunnable(mHander, requestAdMessageInn, requestAdMessageTag);
//        timerThread = new Thread(timerRunnable);
//        timerThread.start();
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (timerThread.isAlive()) {
//            // 1.先结束Runnable
//            timerRunnable.setInterrupted(true);
//        }
//        timerThread.interrupt();
//    }
//}
