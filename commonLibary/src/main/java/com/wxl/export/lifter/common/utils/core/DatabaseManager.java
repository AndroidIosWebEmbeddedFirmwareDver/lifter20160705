package com.wxl.export.lifter.common.utils.core;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @com.wxl.export.lifter.common.utils.core
 * @HuiyuantongVenusShopCash-V3.x
 * @DatabaseManager.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 数据库管理器
 * @2015-2-10下午4:34:58
 */
public abstract class DatabaseManager
{

	protected SQLiteOpenHelper sqLiteOpenHelper;
	protected ReentrantReadWriteLock reentrantReadWriteLock;// 可重入读写锁

	public SQLiteOpenHelper getSqLiteOpenHelper()
	{
		return sqLiteOpenHelper;
	}

	public ReentrantReadWriteLock getReentrantReadWriteLock()
	{
		return reentrantReadWriteLock;
	}

	public DatabaseManager()
	{
		reentrantReadWriteLock = new ReentrantReadWriteLock();
	}

	public SQLiteDatabase lockWritableDatabase()
	{
		reentrantReadWriteLock.writeLock().lock();
		return sqLiteOpenHelper.getWritableDatabase();
	}

	public void unlockWritableDatabase(SQLiteDatabase db)
	{
		reentrantReadWriteLock.writeLock().unlock();
	}

	public SQLiteDatabase lockReadableDatabase()
	{
		reentrantReadWriteLock.readLock().lock();
		return sqLiteOpenHelper.getReadableDatabase();
	}

	public void unlockReadableDatabase(SQLiteDatabase db)
	{
		reentrantReadWriteLock.readLock().unlock();
	}

}
