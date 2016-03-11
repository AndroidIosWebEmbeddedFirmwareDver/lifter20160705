package com.wxl.export.lifter.common.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wxl.export.lifter.common.utils.core.DatabaseManager;


/**
 * 
 * @Desc: 用户数据库管理者
 * @com.wxl.export.lifter.common.manager
 * @HuiyuantongVenusShopCash-V3.x
 * @UserDatebaseManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-4上午1:16:31
 */

public class UserDatebaseManager extends DatabaseManager
{

	private static UserDatebaseManager instance;
	private static String DB_NAME = "HuiyuantongVenusShopCash-HeraLocalShop";

	public static UserDatebaseManager getInstance()
	{
		if (instance == null)
		{
			instance = new UserDatebaseManager();
		}
		return instance;
	}

	private UserDatebaseManager()
	{
	}

	public void onInit(Context context, String name)
	{
		DB_NAME = "HuiyuantongVenusShopCash-HeraLocalShop" + name;
		if (sqLiteOpenHelper != null)
		{
			deleteDatabase(context, name);
		}
		sqLiteOpenHelper = new DBUserHelper(context, name);
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

	public String getDatabaseName()
	{
		return DB_NAME;
	}

	public void onDestory(Context context)
	{
		if (sqLiteOpenHelper != null)
		{
			sqLiteOpenHelper.close();
		}
		if (sqLiteOpenHelper != null)
		{
			deleteDatabase(context, DB_NAME);
		}
	}

	private static class DBUserHelper extends SQLiteOpenHelper
	{

		private static final int DB_VERSION = 1;

		public DBUserHelper(Context context, String name)
		{
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db)
		{
//			// 创建管理员表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_MANAGERJSON + " TEXT);");
//			// 创建产品分类表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_NAME
//					+ " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PRODUCTCATEGORIEJSON + " TEXT);");
//			// 创建产品类型表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_NAME + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_PY + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PINYIN + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_CODE + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_PRODUCTTYPEJSON + " TEXT);");
//			// 创建员工分类表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_SHOPSTAFFCATEGORYJSON + " TEXT);");
//			// 创建员工表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_NAME + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_CODE + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PY + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PINYIN + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_SHOPSTAFFJSON + " TEXT);");
//
//			// 创建会员卡类型表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_NAME + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_PY + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PINYIN + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_CARDTYPEJSON + " TEXT);");
//			// 创建套餐类型表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_NAME + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_PY + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PINYIN + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_SALEGROUPJSON + " TEXT);");
//			// 创建套餐明细表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_SALEGROUPTYPEID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_SALEGROUPTYPEITEMJSON + " TEXT);");
//			// 创建代金券类型表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_NAME
//					+ " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PY + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PINYIN + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_CASHCOUPONTYPEJSON + " TEXT);");
//			// 创建折扣券类型表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_NAME + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PY + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PINYIN + " TEXT, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_DISCOUNTCOUPONTYPEJSON + " TEXT);");
//			// 创建商品特殊折扣表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_PRODUCTTYPEID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_CARDTYPEID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_PRODUCTCARDTYPEDISCOUNTJSON + " TEXT);");
//			// 创建折扣券折扣表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_DISCOUNTCOUPONTYPEID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_DISCOUNTCOUPONDISCOUNTJSON + " TEXT);");
//			// 创建消费赠送表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_CARDTYPEID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_CARDTYPERECHARGEPRESENTRULEJSON + " TEXT);");
//			// 创建消费赠送表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_CARDTYPEID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_CARDTYPECONSUMEPRESENTRULEJSON + " TEXT);");
//			// 创建预约消息表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_STATUS + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_TIME + " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_PREORDERJSON + " TEXT);");
//			// 创建系统消息表
//			db.execSQL("CREATE TABLE " + DBColumns.MobileCashBaseDBColumns.TABLENAME + " (" + DBColumns.MobileCashBaseDBColumns.COLUMN_ID + " INTEGER, "
//					+ DBColumns.MobileCashBaseDBColumns.COLUMN_TITLE + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_CONTENT + " TEXT, " + DBColumns.MobileCashBaseDBColumns.COLUMN_STATUS
//					+ " INTEGER, " + DBColumns.MobileCashBaseDBColumns.COLUMN_SYSTEMNOTIFICATIONJSON + " TEXT);");
//
//			// 创建行政区划数据表
//			db.execSQL("CREATE TABLE " + MobileCashBaseDBColumns.LocalAreaTable.TABLENAME + " (" + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_ID + " INTEGER, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_Name + " TEXT, "
//					+ MobileCashBaseDBColumns.LocalAreaTable.COLUMN_ParentId + " INTEGER, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_ShortName + " TEXT, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_LevelType + " INTEGER, "
//					+ MobileCashBaseDBColumns.LocalAreaTable.COLUMN_CityCode + " TEXT, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_ZipCode + " TEXT, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_MergerName + " TEXT, "
//					+ MobileCashBaseDBColumns.LocalAreaTable.COLUMN_Lng + " REAL, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_Lat + " REAL, " + MobileCashBaseDBColumns.LocalAreaTable.COLUMN_Pinyin + " TEXT, "
//					+ MobileCashBaseDBColumns.LocalAreaTable.COLUMN_AERAJSON + " TEXT);");
//
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
		}
	}

}
