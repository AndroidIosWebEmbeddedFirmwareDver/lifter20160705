package com.wxl.export.lifter.common.manager;

import android.app.NotificationManager;

import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.utils.core.EventManager;


/**
 * 
 * @Desc: 状态栏通知管理器
 * @com.wxl.export.lifter.common.manager
 * @HuiyuantongVenusMobileCash-V3.x
 * @StatusBarManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:55:03
 */
public class StatusBarManager implements EventManager.OnEventListener
{

	private static int NOTIFY_ID_SYSTEM_NOTIFICATION = 1;
	private static StatusBarManager instance;
	private NotificationManager notificationManager;

	public static StatusBarManager getInstance()
	{
		if (instance == null)
		{
			instance = new StatusBarManager();
		}
		return instance;
	}

	public void onStart()
	{
//		notificationManager = (NotificationManager) BaseApplication.getApplication().getSystemService(Context.NOTIFICATION_SERVICE);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_NEWNOTIFICATIONCOUNTDS_SYNCHRO_SCUCESS,
		// this, false);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_UNDEALSUBSCRIBECOUNTDS_SYNCHRO_SCUCESS,
		// this, false);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_SHOP_RELATE_INFO_DOWN_SYNCHRO_SCUCESS,
		// this, false);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_SHOP_PRODUCT_RALATE_INFO_DOWN_SYNCHRO_SCUCESS,
		// this, false);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_SHOP_SALE_PROMOTION_INFO_DOWN_SYNCHRO_SCUCESS,
		// this, false);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_SHOP_OTHER_INFO_DOWN_SYNCHRO_SCUCESS,
		// this, false);
		// AndroidEventManager.getInstance().addEventListener(EventCode.CALLBACK_SHOP_OTHER_INFO_DOWN_SYNCHRO_SCUCESS_BUTNEEDTOUPDATESOFT,
		// this, false);
	}

	@SuppressWarnings("unused")
	@Override
	public void onEventRunEnd(MobileCashBaseEvent event)
	{
//		if (!isRunningForeground())
//		{
//			final int eventCode = event.getEventCode();
//			// if (eventCode ==
//			// EventCode.CALLBACK_NEWNOTIFICATIONCOUNTDS_SYNCHRO_SCUCESS)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc1);
//			// } else if (eventCode ==
//			// EventCode.CALLBACK_UNDEALSUBSCRIBECOUNTDS_SYNCHRO_SCUCESS)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc2);
//			// } else if (eventCode ==
//			// EventCode.CALLBACK_SHOP_RELATE_INFO_DOWN_SYNCHRO_SCUCESS)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc3);
//			// } else if (eventCode ==
//			// EventCode.CALLBACK_SHOP_PRODUCT_RALATE_INFO_DOWN_SYNCHRO_SCUCESS)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc4);
//			// } else if (eventCode ==
//			// EventCode.CALLBACK_SHOP_SALE_PROMOTION_INFO_DOWN_SYNCHRO_SCUCESS)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc5);
//			// } else if (eventCode ==
//			// EventCode.CALLBACK_SHOP_OTHER_INFO_DOWN_SYNCHRO_SCUCESS)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc6);
//			// } else if (eventCode ==
//			// EventCode.CALLBACK_SHOP_OTHER_INFO_DOWN_SYNCHRO_SCUCESS_BUTNEEDTOUPDATESOFT)
//			// {
//			// setNotification(R.string.hyt_system_message, R.string.synoc7);
//			// }
//		}
	}

//	@SuppressWarnings("deprecation")
//	public void setNotification(int strOne, int strTwo,Class clazz)
//	{
////		final Context app = BaseApplication.getApplication();
////		Notification notification = new Notification(R.drawable.ic_launcher, app.getString(strOne), System.currentTimeMillis());
////		Intent intent = new Intent().setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).setClass(app, clazz);
////		notification.flags = Notification.FLAG_AUTO_CANCEL;
////		notification.defaults |= Notification.DEFAULT_SOUND;
////		notification.defaults |= Notification.DEFAULT_VIBRATE;
////		// notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻通知栏Flag
////		PendingIntent contextIntent = PendingIntent.getActivity(app, 0, intent, 0);
//////		notification.setLatestEventInfo(app, app.getString(R.string.app_name), app.getString(strTwo), contextIntent);
////		notificationManager.notify(NOTIFY_ID_SYSTEM_NOTIFICATION, notification);
//	}
//
//	@SuppressWarnings("deprecation")
//	public void setNotification(String strOne, int strTwo,Class clazz)
//	{
//		final Context app = BaseApplication.getApplication();
//		Notification notification = new Notification(R.drawable.ic_launcher, strOne, System.currentTimeMillis());
//		Intent intent = new Intent().setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).setClass(app, clazz);
//		notification.flags = Notification.FLAG_AUTO_CANCEL;
//		notification.defaults |= Notification.DEFAULT_SOUND;
//		notification.defaults |= Notification.DEFAULT_VIBRATE;
//		// notification.flags = Notification.FLAG_ONGOING_EVENT; // 设置常驻通知栏Flag
//		PendingIntent contextIntent = PendingIntent.getActivity(app, 0, intent, 0);
////		notification.setLatestEventInfo(app, app.getString(R.string.app_name), app.getString(strTwo), contextIntent);
//		notificationManager.notify(NOTIFY_ID_SYSTEM_NOTIFICATION, notification);
//	}
//
//	public boolean isRunningForeground()
//	{
//		String packageName = BaseApplication.getApplication().getPackageName();
//		String topActivityClassName = getTopActivityName();
//		if (packageName != null && topActivityClassName != null && topActivityClassName.startsWith(packageName))
//		{
//			return true;
//		} else
//		{
//			return false;
//		}
//	}
//
//	public String getTopActivityName()
//	{
//		String topActivityClassName = null;
//		ActivityManager activityManager = (ActivityManager) (BaseApplication.getApplication().getSystemService(Context.ACTIVITY_SERVICE));
//		List<RunningTaskInfo> runningTaskInfos = activityManager.getRunningTasks(1);
//		if (runningTaskInfos != null)
//		{
//			ComponentName f = runningTaskInfos.get(0).topActivity;
//			topActivityClassName = f.getClassName();
//		}
//		return topActivityClassName;
//	}
}
