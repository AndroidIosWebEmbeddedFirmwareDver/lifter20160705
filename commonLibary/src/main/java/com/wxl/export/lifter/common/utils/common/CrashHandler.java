package com.wxl.export.lifter.common.utils.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;


/**
 * 
 * @Description: UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 * @ClassName: CrashHandler
 * @author wxl.sinto.cto
 * @date 2014-9-12 下午3:13:04
 * 
 */
@SuppressLint("SdCardPath")
public class CrashHandler implements UncaughtExceptionHandler
{
	public static final String TAG = "CrashHandler";
	// 系统默认的UncaughtException处理类
	private UncaughtExceptionHandler mDefaultHandler;
	// CrashHandler实例
	private static CrashHandler INSTANCE = new CrashHandler();
	// 程序的Context对象
	private static Context mContext;
	// 用来存储设备信息和异常信息
	private Map<String, String> infos = new HashMap<String, String>();
	// 用于格式化日期,作为日志文件名的一部分
	@SuppressLint("SimpleDateFormat")
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	private StringBuffer errorStringBuffer = null;

	/** 保证只有一个CrashHandler实例 */
	public CrashHandler()
	{
	}

	/** 获取CrashHandler实例 ,单例模式 */
	public static CrashHandler getInstance()
	{
		return INSTANCE;
	}

	/**
	 * 初始化
	 * 
	 * @param context
	 */
	public void init(Context context)
	{
		mContext = context;
		// 获取系统默认的UncaughtException处理器
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		// 设置该CrashHandler为程序的默认处理器
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex)
	{
		if (!handleException(ex) && mDefaultHandler != null)
		{
			// 如果用户没有处理则让系统默认的异常处理器来处理
			mDefaultHandler.uncaughtException(thread, ex);
		} else
		{ // 如果自己处理了异常，则不会弹出错误对话框，则需要手动退出app
			// 重启系统
			restartApplication(mContext);
		}
	}

	/**
	 * 自定义错误处理,收集错误信息 发送错误报告等操作均在此完成.
	 * 
	 * @param ex
	 * @return true:如果处理了该异常信息;否则返回false.
	 */
	private boolean handleException(Throwable ex)
	{
		if (ex == null)
		{
			return false;
		}
		// 收集设备参数信息
		collectDeviceInfo(mContext);
		// 保存日志文件
		saveCrashInfoToFile(ex);
		new Thread()
		{
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				super.run();
				Looper.prepare();
				uploadLogMessageToService(mContext, errorStringBuffer.toString());
				Looper.loop();
			}

		}.start();
		return true;
	}

	/**
	 * 收集设备参数信息
	 * 
	 * @param ctx
	 */
	public void collectDeviceInfo(Context ctx)
	{
		try
		{
			PackageManager pm = ctx.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), PackageManager.GET_ACTIVITIES);
			if (pi != null)
			{
				String versionName = pi.versionName == null ? "null" : pi.versionName;
				String versionCode = pi.versionCode + "";
				infos.put("versionName", versionName);
				infos.put("versionCode", versionCode);
			}
		} catch (NameNotFoundException e)
		{
			Log.e(TAG, "an error occured when collect package info", e);
		}
		Field[] fields = Build.class.getDeclaredFields();
		for (Field field : fields)
		{
			try
			{
				field.setAccessible(true);
				infos.put(field.getName(), field.get(null).toString());
				Log.d(TAG, field.getName() + " : " + field.get(null));
			} catch (Exception e)
			{
				Log.e(TAG, "an error occured when collect crash info", e);
			}
		}
	}

	/**
	 * 保存错误信息到文件中
	 * 
	 * @param ex
	 * @return 返回文件名称,便于将文件传送到服务器
	 */
	private String saveCrashInfoToFile(Throwable ex)
	{

		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : infos.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key + "=" + value + "\n");
		}

		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		Throwable cause = ex.getCause();
		while (cause != null)
		{
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		printWriter.close();
		String result = writer.toString();
		sb.append(result);
		try
		{
			long timestamp = System.currentTimeMillis();
			String time = formatter.format(new Date());
			String fileName = "ErrorLog-" + time + "-" + timestamp / 1000 + ".log";
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
			{
				String path = "/sdcard/crash/";
				File dir = new File(path);
				if (!dir.exists())
				{
					dir.mkdirs();
				}
				FileOutputStream fos = new FileOutputStream(path + fileName);
				fos.write(sb.toString().getBytes());
				fos.close();
			}
			errorStringBuffer = sb;
			return fileName;
		} catch (Exception e)
		{
			Log.e(TAG, "an error occured while writing file...", e);
		}
		return null;
	}

	/**
	 * 上传错误日志到服务器 服务器记录日志格式为：企业名称+店铺名称+时间（年月日 时分秒）.android.herashop.log
	 * 
	 * @param context
	 * @param content
	 */
	public void uploadLogMessageToService(Context context, String content)
	{
		// 与网络通信步骤 1.注册监听 2.调用事件
		Intent intent = new Intent();
		intent.setAction("CrashHandler");
//		intent.setClass(mContext, ApplictionErrorService.class);
		intent.putExtra("content", content);
		mContext.startService(intent);
	}

	/**
	 * 重启应用程序
	 */
	public static void restartApplication(Context mContext)
	{
//		if (!BaseApplication.unUseVerison())
//		{
//			// 超级管理员还未登陆过
//			if (!BaseApplication.isLogined())
//			{
//				// 重新启动程序欢迎界面
//				Intent intent = new Intent(mContext, StartActivity.class);
//				// 设置启动模式，重新启动
//				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//				// 彻底退出系统
//				android.os.Process.killProcess(android.os.Process.myPid());
//				System.exit(10);
//			}
//			// 超级管理员已经登陆过
//			else
//			{
//				// 重新启动程序欢迎界面
//				Intent intent = new Intent(mContext, StartActivity.class);
//				// 设置启动模式，重新启动
//				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//				// 彻底退出系统
//				android.os.Process.killProcess(android.os.Process.myPid());
//				System.exit(10);
//			}
//		}

	}
}
