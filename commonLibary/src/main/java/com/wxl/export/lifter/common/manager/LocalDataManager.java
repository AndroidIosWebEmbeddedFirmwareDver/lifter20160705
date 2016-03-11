package com.wxl.export.lifter.common.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.wxl.export.lifter.common.utils.common.CommonUtils;


/**
 * @Desc: 本地数据管理器
 * @com.wxl.export.lifter.common.manager
 * @HuiyuantongVenusMobileCash-V3.x
 * @LocalDataManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:11:39
 */
public class LocalDataManager {
    //本地数据管理器单例对象
    private static LocalDataManager instance;
    //是否登录标志
    private boolean isSuperManagerHadLogin;
    //时间戳
    private long modifyDate;
    // 网络回话标志
    private String jsessionId;

    private  SharedPreferences sp;

    public static LocalDataManager getsInstance(Context context) {
        if (instance == null) {
            instance = new LocalDataManager(context);
        }
        return instance;
    }

    public LocalDataManager(Context context) {
        sp = CommonUtils.getDefaultSharedPreferences(context);
        // enterpriseSettingDown = new EnterpriseSettingDown(sp);
        // enterprise = new Enterprise(sp);
        isSuperManagerHadLogin = sp.getBoolean(SharedPreferenceManager.KEY_isSuperManagerHadLogin, false);
        jsessionId = sp.getString(SharedPreferenceManager.KEY_jsessionId, null);
    }

    /**
     * 返回时间戳
     *
     * @return
     */
    public long getModifyDate() {
        return modifyDate;
    }

    /**
     * 保存时间戳
     *
     * @param modifyDate
     */
    public void saveModifyDate(long modifyDate) {
        SharedPreferences.Editor et = sp.edit();
        et.putLong(SharedPreferenceManager.KEY_MODIFYDATE, modifyDate);
        et.commit();
        this.modifyDate = modifyDate;
    }

    /**
     * 返回网络回话标志
     *
     * @return
     */
    public String getJsessionId() {
        return jsessionId;
    }

    /**
     * 保存网络回话标志
     *
     * @param jsessionId
     */
    public void setJsessionId(String jsessionId) {
        this.jsessionId = jsessionId;
        SharedPreferences.Editor et = sp.edit();
        et.putString(SharedPreferenceManager.KEY_jsessionId, jsessionId);
        et.commit();
    }



    /**
     * 返回是否登录标志
     *
     * @return
     */
    public boolean isSuperManagerHadLogin() {
        return isSuperManagerHadLogin;
    }

    /**
     * 保存是否登录标志
     *
     * @param isSuperManagerHadLogin
     */
    public void setSuperManagerHadLogin(boolean isSuperManagerHadLogin) {
        this.isSuperManagerHadLogin = isSuperManagerHadLogin;
        SharedPreferences.Editor et = sp.edit();
        et.putBoolean(SharedPreferenceManager.KEY_isSuperManagerHadLogin, isSuperManagerHadLogin);
        et.commit();
    }
    /**
     * 清除数据
     */
    public void clearLocalEnterprise() {
        SharedPreferences.Editor et = sp.edit();
        et.clear();
        et.commit();
        this.modifyDate = 0;
        this.jsessionId = null;
    }
}
