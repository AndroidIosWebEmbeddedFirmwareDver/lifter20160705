package com.wxl.export.lifter.common.utils.core;

import java.io.File;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;

/**
 * 
 * @com.wxl.export.lifter.common.utils.core
 * @HuiyuantongVenusShopCash-V3.x
 * @DataClearManager.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 本地数据清除管理器
 * @2015-2-10下午4:35:34
 */
public class DataClearManager
{
	public DataClearManager()
	{

	}

	/** * 清除本应用内部缓存(/data/data/com.xxx.xxx/cache) * * @param context */
	public static void cleanInternalCache(Context context)
	{
		deleteFilesByDirectory(context.getCacheDir());
	}

	/** * 清除本应用所有数据库(/data/data/com.xxx.xxx/databases) * * @param context */
	@SuppressLint("SdCardPath")
	public static void cleanDatabases(Context context)
	{
		// deleteFilesByDirectory(new File("/data/data/"
		// + context.getPackageName() + "/databases"));
		File deleteMatchingFile = new File("/data/data/" + context.getPackageName() + "/databases");
		File[] filenames = deleteMatchingFile.listFiles();
		if (filenames != null && filenames.length > 0)
		{
			for (int i = 0; i < filenames.length; i++)
			{
				String fileName = filenames[i].getName().toString();

				if (isNumeric(fileName) || isNumeric(fileName.replaceAll("-journal", "")))
				{
					try
					{
						filenames[i].delete();

					} catch (Exception e)
					{
						// TODO: handle exception
					}

				}

			}

		}

	}

	/**
	 * * 清除本应用SharedPreference(/data/data/com.xxx.xxx/shared_prefs) * * @param
	 * context
	 */
	@SuppressLint("SdCardPath")
	public static void cleanSharedPreference(Context context)
	{
		deleteFilesByDirectory(new File("/data/data/" + context.getPackageName() + "/shared_prefs"));
	}

	/** * 按名字清除本应用数据库 * * @param context * @param dbName */
	public static void cleanDatabaseByName(Context context, String dbName)
	{
		context.deleteDatabase(dbName);
	}

	/** * 清除/data/data/com.xxx.xxx/files下的内容 * * @param context */
	public static void cleanFiles(Context context)
	{
		deleteFilesByDirectory(context.getFilesDir());
	}

	/**
	 * * 清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache) * * @param
	 * context
	 */
	public static void cleanExternalCache(Context context)
	{
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
		{
			deleteFilesByDirectory(context.getExternalCacheDir());
		}
	}

	/** * 清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除 * * @param filePath */
	public static void cleanCustomCache(String filePath)
	{
		deleteFilesByDirectory(new File(filePath));
	}

	/** * 清除本应用所有的数据 * * @param context * @param filepath */
	public static void cleanApplicationData(Context context, String... filepath)
	{
		cleanInternalCache(context);
		cleanExternalCache(context);
		cleanDatabases(context);
		cleanSharedPreference(context);
		cleanFiles(context);
		for (String filePath : filepath)
		{
			cleanCustomCache(filePath);
		}
	}

	/** * 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理 * * @param directory */
	private static void deleteFilesByDirectory(File directory)
	{
		if (directory != null && directory.exists() && directory.isDirectory())
		{
			for (File item : directory.listFiles())
			{
				item.delete();
			}
		}
	}

	public void deleteDataWenExit(Context context)
	{
		cleanSharedPreference(context);
		cleanExternalCache(context);
		cleanDatabases(context);
		cleanInternalCache(context);
		// 2015年04月18日11:50:01
		cleanFiles(context);

	}

	public static boolean isNumeric(String str)
	{
		for (int i = str.length(); --i >= 0;)
		{
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				return false;
		}
		return true;
	}
}
