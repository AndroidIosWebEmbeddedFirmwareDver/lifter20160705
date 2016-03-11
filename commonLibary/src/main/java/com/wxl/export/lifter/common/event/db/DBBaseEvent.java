package com.wxl.export.lifter.common.event.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.wxl.export.lifter.common.event.MobileCashBaseDBTableCreateableInterface;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.manager.UserDatebaseManager;
import com.wxl.export.lifter.common.utils.core.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @com.sintn.hera.shop.event.dbevent
 * @HuiyuantongVenusShopCash-V3.x
 * @DBEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 数据库事件基类
 * @2015-2-10下午4:42:53
 */

public abstract class DBBaseEvent extends MobileCashBaseEvent implements MobileCashBaseDBTableCreateableInterface
{
	protected List<Cursor> cursors;// 游标集合
	protected boolean isRead = true;// 是否读取

	public DBBaseEvent(int nEventCode)
	{
		super(nEventCode);
	}

	protected void managerCursor(Cursor cursor)
	{
		if (cursor == null)
		{
			return;
		}

		if (cursors == null)
		{
			cursors = new ArrayList<Cursor>();
		}
		cursors.add(cursor);
	}

	protected void requestExecute(boolean bRead)
	{
		isRead = bRead;
		DatabaseManager dm = UserDatebaseManager.getInstance();
		if (bRead)
		{
			if (dm.getReentrantReadWriteLock() != null && dm.getSqLiteOpenHelper() != null)
			{
				SQLiteDatabase db = dm.lockReadableDatabase();
				try
				{
					onExecute(db);
				} finally
				{
					dm.unlockReadableDatabase(db);
					closeCursor();
				}
			}
		} else
		{
			if (dm.getReentrantReadWriteLock() != null && dm.getSqLiteOpenHelper() != null)
			{
				SQLiteDatabase db = dm.lockWritableDatabase();
				try
				{
					onExecute(db);
				} finally
				{
					dm.unlockWritableDatabase(db);
					closeCursor();
				}
			}
		}
	}

	protected void safeInsert(SQLiteDatabase db, String strTableName, ContentValues cv)
	{
		long lRet = db.insert(strTableName, null, cv);
		if (lRet == -1)
		{
			if (!tabbleIsExist(strTableName, db))
			{
				db.execSQL(createTableSql());
				db.insert(strTableName, null, cv);
			}
		}
	}

	protected boolean tabbleIsExist(String tableName, SQLiteDatabase db)
	{
		boolean result = false;
		Cursor cursor = null;
		try
		{
			String sql = "select count(*) as c from Sqlite_master  where type ='table' and name ='" + tableName.trim() + "' ";
			cursor = db.rawQuery(sql, null);
			if (cursor.moveToNext())
			{
				int count = cursor.getInt(0);
				if (count > 0)
				{
					result = true;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (cursor != null)
			{
				cursor.close();
			}
		}
		return result;
	}

	protected void closeCursor()
	{
		if (cursors != null)
		{
			for (Cursor cursor : cursors)
			{
				cursor.close();
			}
			cursors.clear();
		}
	}

	protected abstract void onExecute(SQLiteDatabase db);

}
