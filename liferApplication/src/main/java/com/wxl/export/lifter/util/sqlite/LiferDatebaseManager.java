package com.wxl.export.lifter.util.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wxl.export.lifter.common.manager.UserDatebaseManager;
import com.wxl.export.lifter.common.utils.common.LogUtil;
import com.wxl.export.lifter.common.utils.core.DatabaseManager;

/**
 * @Desc: 用户数据库管理者
 * @com.wxl.export.easyproject.manager
 * @HuiyuantongVenusShopCash-V3.x
 * @UserDatebaseManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-4上午1:16:31
 */

public class LiferDatebaseManager extends DatabaseManager {

    private static LiferDatebaseManager instance;
    private static String DB_NAME = "lifer_xxx_20160308";
    private static final int DB_VERSION = 109;

    public static LiferDatebaseManager getInstance() {
        if (instance == null) {
            instance = new LiferDatebaseManager();
        }
        return instance;
    }

    private LiferDatebaseManager() {
    }

    public void onInit(Context context) {
        if (sqLiteOpenHelper != null) {
            sqLiteOpenHelper.close();
        }
        sqLiteOpenHelper = new DBUserHelper(context, DB_NAME, DB_VERSION);
    }

    /**
     * 删除数据库
     *
     * @param context
     * @return
     */
    public boolean deleteDatabase(Context context, String name) {
        return context.deleteDatabase(name);
    }


    public void onDestory(Context context) {
        if (sqLiteOpenHelper != null) {
            sqLiteOpenHelper.close();
        }
        if (sqLiteOpenHelper != null) {
            deleteDatabase(context, DB_NAME);
        }
    }

    private static class DBUserHelper extends SQLiteOpenHelper {
        private String dbName;
        private int dbVersion;

        public DBUserHelper(Context context, String dbName, int dbVersion) {
            super(context, dbName, null, dbVersion);
            this.dbName = dbName;
            this.dbVersion = dbVersion;
            LogUtil.e("DBUserHelper");
            getReadableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            LogUtil.e("onCreate");
            //本地订单表
            db.execSQL("CREATE TABLE " +
                    LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME
                    + " ("
                    + LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_JSON + " TEXT"
                    + " );"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            LogUtil.e("onUpgrade");
        }

        @Override
        public synchronized void close() {
            super.close();
            LogUtil.e("close");
        }

        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
            LogUtil.e("onOpen");
        }

        @Override
        public String getDatabaseName() {
            LogUtil.e("getDatabaseName");
            return super.getDatabaseName();
        }

        @Override
        public void onConfigure(SQLiteDatabase db) {
            super.onConfigure(db);
            LogUtil.e("onConfigure");
        }

        @Override
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            super.onDowngrade(db, oldVersion, newVersion);
            LogUtil.e("onDowngrade");
        }

        @Override
        public SQLiteDatabase getReadableDatabase() {
            LogUtil.e("getReadableDatabase");
            return super.getReadableDatabase();
        }

        @Override
        public SQLiteDatabase getWritableDatabase() {
            LogUtil.e("getWritableDatabase");
            return super.getWritableDatabase();
        }

        @Override
        public void setWriteAheadLoggingEnabled(boolean enabled) {
            super.setWriteAheadLoggingEnabled(enabled);
        }

        public DBUserHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        public DBUserHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
    }

}
