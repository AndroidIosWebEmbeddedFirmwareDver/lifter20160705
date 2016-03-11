package com.wxl.export.lifter.thread;

/**
 * com.wxl.export.lifter.thread
 * Sintn
 * Created by Sintn on 16/3/4 下午5:26.
 */

import android.os.Handler;
import android.os.Message;

/**
 * 定时线程
 */
public  class TimerRunnable implements Runnable {
    private long sleepSc;
    private Handler mHander;
    private boolean interrupted;
    private int msgtag;

    public boolean isInterrupted() {
        return interrupted;
    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    public TimerRunnable(Handler mHander,long sleepSc, int msgtag) {
        this.sleepSc = sleepSc;
        this.mHander = mHander;
        this.msgtag=msgtag;
    }

    @Override
    public void run() {
//        while (!interrupted) {
            try {
                Thread.sleep(sleepSc*0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (!interrupted) {
                    Message message = new Message();
                    message.what = msgtag;
                    mHander.sendMessage(message);
                }
            }
//        }
    }
}
