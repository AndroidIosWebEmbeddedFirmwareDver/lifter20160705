package com.wxl.export.lifter.common.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.wxl.export.lifter.common.utils.common.CommonUtils;


/**
 * 
 * @Desc: 软件版本管理
 * @com.wxl.export.lifter.common.manager
 * @HuiyuantongVenusMobileCash-V3.x
 * @VersionManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:46:48
 */
public class VersionManager
{

	private static VersionManager instance;
	private SharedPreferences sp;

	public static VersionManager getsInstance(Context context)
	{
		if (instance == null)
		{
			instance = new VersionManager(context);
		}
		return instance;
	}

	public VersionManager(Context context)
	{
		super();
		sp = CommonUtils.getDefaultSharedPreferences(context);
//		version = new AppVersion(sp);
	}

//	public AppVersion getVersion()
//	{
//		return version;
//	}
//
//	public void setVersion(AppVersion version)
//	{
//		this.version = version;
//		SharedPreferences.Editor et = sp.edit();
//		et.putLong(SharedPreferenceManager.KEY_versionId, version.getId());
//		et.putBoolean(SharedPreferenceManager.KEY_versionDeleted, version.isDeleted());
//		et.putString(SharedPreferenceManager.KEY_versionVersion, version.getVersion());
//		et.putString(SharedPreferenceManager.KEY_versionSupportVersion, version.getSupportVersion());
//		et.putInt(SharedPreferenceManager.KEY_versionAppType, version.getAppType());
//		et.putInt(SharedPreferenceManager.KEY_versionOsType, version.getOsType());
//		et.putInt(SharedPreferenceManager.KEY_versionStatus, version.getStatus());
//		et.putString(SharedPreferenceManager.KEY_versionDescription, version.getDescription());
//		et.putString(SharedPreferenceManager.KEY_versionDownloadUrl, version.getDownloadUrl());
//		et.commit();
//	}

}
