package com.wxl.export.lifter.common.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.wxl.export.lifter.common.utils.common.CrashHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 全局APPLICATION类
 * @com.sintn.hera.mobile.cash
 * @HuiyuantongVenusMobileCash-V3.x
 * @BaseApplication.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:47:23
 */
public abstract class BaseApplication extends MultiDexApplication {
    /**
     * 测试么？
     */
    private static boolean isNowTest = false;
    /**
     * application单例对象
     */
    private static BaseApplication instance;
    /**
     * 全局Activity管理
     */
    public static List<Activity> activities = null;
    // private static boolean onlyOneEnterprise;

    public static boolean isNowTest() {
        return isNowTest;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        activities = new ArrayList<Activity>();
        instance = this;
        // 全局异常抓取器
        CrashHandler handler = CrashHandler.getInstance();
        handler.init(getApplicationContext());
        ApplicationScriptInit();
        ApplicationEventManagerEnevtsInit();
        ApplicationDatabaseInit();
//        registerScreenLockedReceiver();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

//    private void registerScreenLockedReceiver() {
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Intent.ACTION_SCREEN_OFF);
//        this.registerReceiver(new ScreenLockedReceiver(), filter);
//    }

    /**
     * 初始化各类管理工具
     */
    public abstract void ApplicationScriptInit();

    /**
     * 初始化数据库
     */
    public abstract void ApplicationDatabaseInit();

//    /**
//     * 初始化xUtils插件
//     */
//    private void xUtilsScriptInit()
//    {
//        x.Ext.init(this);
//        x.Ext.setDebug(true); // 是否输出debug日志
//    }

    /**
     * 初始化事件管理器并注册全局所有事件
     */
    public abstract void ApplicationEventManagerEnevtsInit();//{

    /**
     * 获取全局Application上下文
     *
     * @return
     */
    public static Context getApplication() {
        return instance.getApplicationContext();
    }

    /**
     * 获取全局Application上下文
     *
     * @return
     */
    public static BaseApplication getApplicationInstance() {
        return instance;
    }

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void clearActivitys() {
        // 关闭所有Activity
        if (activities != null) {
            for (Activity activity : activities) {
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            activities.clear();
            activities = new ArrayList<Activity>();
        }
    }


    /**
     * 重启应用程序
     */
    public static void restartApplication(Context mContext) {
        // // 重新启动程序欢迎界面
        // Intent intent = new Intent(mContext, StartActivity.class);
        // // 设置启动模式，重新启动
        // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // mContext.startActivity(intent);
        // // 彻底退出系统
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(10);
    }


    //判断App是否运行在前台
    public boolean isRunningForeground() {
        ActivityManager am = (ActivityManager) instance.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        String currentPackageName = cn.getPackageName();
        if (!TextUtils.isEmpty(currentPackageName) && currentPackageName.equals(getPackageName())) {
            return true;
        }

        return false;
    }


}
