package com.wxl.export.lifter.common.manager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager
{
	/**
	 * 基础数据
	 */
	public static final String SP_NAME = "com.sintn.hera.mobile.sp";// SharedPreference文件名称
	public static final String KEY_jsessionId = "com.sintn.hera.mobile.sp.jsessionId";// 网络会话ID
	public static final String KEY_isSuperManagerHadLogin = "com.sintn.hera.mobile.sp.isSuperManagerHadLogin";// 超级管理员是否登录
	public static final String KEY_pushId = "com.sintn.hera.mobile.sp.pushId";// 个推推送ID
	public static final String KEY_MODIFYDATE = "com.sintn.hera.mobile.sp.modifyDate";// 时间戳
	public static final String KEY_macAddress = "com.sintn.hera.mobile.sp.macAddress";// 本机网卡MAC地址
	public static final String KEY_username = "com.sintn.hera.mobile.sp.username";// 本机网卡MAC地址
	public static final String KEY_md5psd = "com.sintn.hera.mobile.sp.md5psd";// 本机网卡MAC地址
	public static final String KEY_ROLE_TYPE = "com.sintn.hera.mobile.sp.roletype";// 登录角色
	public static final String RETURN_FLAG = "com.sintn.hera.mobile.sp.returnFlag";// 返润标志
	public static final String KEY_PHOTOURL = "com.sintn.hera.mobile.sp.photoUrl";// 登录用户头像地址
	public static final String KEY_SHOP_ADRESS = "com.sintn.hera.mobile.sp.shopAdress";// 登录店铺的地址
	public static final String KEY_IS_VERIFY = "com.sintn.hera.mobile.sp.isVerify";// 是否已验证安全码
	public static final String KEY_IS_SCREEN_LOCKED = "com.sintn.hera.mobile.sp.isScreenLocked";// 是否已验证安全码
	/**
	 * Version
	 */
	public static String KEY_versionId = "com.sintn.hera.mobile.sp.versionId";// id
	public static String KEY_versionDeleted = "com.sintn.hera.mobile.sp.versionDeleted";// 是否删除了
	public static String KEY_versionVersion = "com.sintn.hera.mobile.sp.versionVersion";// 版本
	public static String KEY_versionSupportVersion = "com.sintn.hera.mobile.sp.versionSupportVersion";// 最低支持版本
	public static String KEY_versionAppType = "com.sintn.hera.mobile.sp.versionAppType";// 软件类型
	public static String KEY_versionOsType = "com.sintn.hera.mobile.sp.versionOsType";// 运行的系统类型
	public static String KEY_versionStatus = "com.sintn.hera.mobile.sp.versionStatus";// 软件状态
	public static String KEY_versionDescription = "com.sintn.hera.mobile.sp.versionDescription";
	public static String KEY_versionDownloadUrl = "com.sintn.hera.mobile.sp.versionDownloadUrl";
	public static String KEY_shopDataVersion = "com.sintn.hera.mobile.sp.shopDataVersion";
	public static String KEY_shopMessageVersion = "com.sintn.hera.mobile.sp.shopMessageVersion";

	public static SharedPreferences getSharedPreferences(Context context)
	{
		return context.getSharedPreferences(SP_NAME, 0);
	}
}
