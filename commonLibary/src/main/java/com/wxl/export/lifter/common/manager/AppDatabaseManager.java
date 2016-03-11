package com.wxl.export.lifter.common.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.wxl.export.lifter.common.utils.core.DatabaseManager;


/**
 * 
 * @Desc: 应用全局数据库管理者
 * @com.wxl.export.lifter.common.manager
 * @HuiyuantongVenusShopCash-V3.x
 * @AppDatabaseManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-4上午1:16:22
 */

public class AppDatabaseManager extends DatabaseManager
{

	private static AppDatabaseManager instance;

	public synchronized static AppDatabaseManager getInstance()
	{
		if (instance == null)
		{
			instance = new AppDatabaseManager();
		}
		return instance;
	}

	public void onInit(Context context)
	{
		if (sqLiteOpenHelper != null)
		{
			deleteDatabase(context, getDatabaseName());
		}
		sqLiteOpenHelper = new DBHelper(context.getApplicationContext());
	}

	/**
	 * 删除数据库
	 * 
	 * @param context
	 * @return
	 */
	public boolean deleteDatabase(Context context, String name)
	{
		return context.deleteDatabase(name);
	}

	public void onDestory(Context context)
	{
		if (sqLiteOpenHelper != null)
		{
			sqLiteOpenHelper.close();
		}
		if (sqLiteOpenHelper != null)
		{
			deleteDatabase(context, getDatabaseName());
		}
	}

	public String getDatabaseName()
	{
		return DBHelper.DB_NAME;
	}

	private static class DBHelper extends SQLiteOpenHelper
	{

		private static final int DB_VERSION = 1;
		private static final String DB_NAME = "HuiyuantongVenusShopCash-HeraLocalShop";

		/**
		 * 在SQLiteOpenHelper的子类当中，必须有该构造函数
		 * 
		 * @param context
		 *            上下文对象
		 * @param name
		 *            数据库名称
		 * @param factory
		 * @param version
		 *            当前数据库的版本，值必须是整数并且是递增的状态
		 */
		public DBHelper(Context context, String name, CursorFactory factory, int version)
		{
			// 必须通过super调用父类当中的构造函数
			super(context, name, factory, version);
		}

		public DBHelper(Context context)
		{
			this(context, DB_NAME, null, DB_VERSION);
		}

		// 该函数是在第一次创建的时候执行，实际上是第一次得到SQLiteDatabase对象的时候才会调用这个方法
		@Override
		public void onCreate(SQLiteDatabase db)
		{
			// 创建店铺表
			// db.execSQL("CREATE TABLE " +
			// DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" +
			// DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " +
			// DBColumns.MobileCashBaseDBColumns.COLUMN_SHOPJSON +
			// " TEXT);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
		}
	}

}
