package com.wxl.export.lifter.app;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.wxl.export.lifter.common.event.EventCode;
import com.wxl.export.lifter.common.manager.AndroidEventManager;
import com.wxl.export.lifter.common.utils.common.LogUtil;
import com.wxl.export.lifter.enty.ConstEnty;
import com.wxl.export.lifter.common.app.BaseApplication;
import com.wxl.export.lifter.event.LiftEventCode;
import com.wxl.export.lifter.event.http.GetTodayHistoryEvent;
import com.wxl.export.lifter.util.sqlite.LiferDatebaseManager;

import cn.smssdk.SMSSDK;

/**
 * ${PACKAGE_NAME}
 * Sintn
 * Created by Sintn on 16/3/4 下午1:51.
 */
public class LiferApplication extends BaseApplication {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void ApplicationScriptInit() {
        MultiDex.install(this);
        SMSSDK.initSDK(this, ConstEnty.SMSAPP_KEY, ConstEnty.SMSAPP_SERCRET);
    }

    @Override
    public void ApplicationDatabaseInit() {
        try {
            LiferDatebaseManager.getInstance().onInit(getApplication());
        } catch (Exception e) {
            // TODO: handle exception
            LogUtil.e("InitDataBaseException:" + e.getMessage());
        }
    }

    @Override
    public void ApplicationEventManagerEnevtsInit() {
        AndroidEventManager eventManager = AndroidEventManager.getInstance();
        // 初始化检测服务器连通性事件
        eventManager.addEvent(new GetTodayHistoryEvent(LiftEventCode.HTTP_GET_TODAY_HOSTORY_QUERY_CODE));
    }

}
