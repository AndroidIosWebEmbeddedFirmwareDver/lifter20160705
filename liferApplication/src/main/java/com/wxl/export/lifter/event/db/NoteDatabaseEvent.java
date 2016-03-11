package com.wxl.export.lifter.event.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;


import com.wxl.export.lifter.common.entity.dbparam.DBHandleType;
import com.wxl.export.lifter.common.utils.common.LogUtil;
import com.wxl.export.lifter.common.utils.core.JsonCommonUtils;
import com.wxl.export.lifter.enty.db.note.NoteDatabaseParam;
import com.wxl.export.lifter.enty.db.note.NoteTabelCellOrder;
import com.wxl.export.lifter.util.sqlite.LiferDatabaseColumns;

import java.util.List;

/**
 * @com.sintn.hera.shop.event.dbevent
 * @HuiyuantongVenusShopCash-V3.x
 * @CardTypeEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 卡片类型数据库操作事件
 * @2015-2-10下午5:31:25
 */

public class NoteDatabaseEvent extends LifeDatabaseBaseEvent {

    private NoteDatabaseParam noteDatabaseParam;

    public NoteDatabaseEvent(int nEventCode) {
        super(nEventCode);
    }

    @Override
    public String createTableSql() {
        return "CREATE TABLE " +
                LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME
                + " ("
                + LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_JSON + " TEXT"
                + " );";
    }


    @Override
    protected void onExecute(SQLiteDatabase db) {
        if (isRead) {
            if (noteDatabaseParam.handleType == DBHandleType.READ_TABLE_COUNT) {
                noteDatabaseParam.datasRows = queryRows(db);
            } else {
                Cursor cursor = db.query(LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME, null, null, null, null, null, null, null);
                managerCursor(cursor);
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        noteDatabaseParam.objects.add(readOneEnty(cursor));
                    } while (cursor.moveToNext());
                }
            }
        } else {
            int affectedNum = 0;
            if (noteDatabaseParam.id >= 0 && noteDatabaseParam.handleType == DBHandleType.DELETE) {
                //根据主键id删除集合数据
                if (noteDatabaseParam.objects != null && noteDatabaseParam.objects.size() > 0) {
                    final List<NoteTabelCellOrder> areas = noteDatabaseParam.objects;
                    db.beginTransaction(); // 手动设置开始事务
                    for (NoteTabelCellOrder noteTabelCellOrder : areas) {
                        if (noteDatabaseParam.handleType == DBHandleType.DELETE) {
                            deleteOneEnty(db, noteTabelCellOrder.getId());
                            affectedNum++;
                        }
                    }
                    // 数据插入操作循环
                    db.setTransactionSuccessful(); // 设置事务处理成功，不设置会自动回滚不提交
                    db.endTransaction(); // 处理完成
                }
                //根据主键id删除一个数据
                else {
                    affectedNum = deleteOneEnty(db, noteDatabaseParam.id);
                }
            } else if (noteDatabaseParam.object != null) {
                final NoteTabelCellOrder noteTabelCellOrder = noteDatabaseParam.object;
                if (noteDatabaseParam.handleType == DBHandleType.WRITE) {
                    if (noteTabelCellOrder.isDeleted()) {
                        deleteOneEnty(db, noteTabelCellOrder.getId());
                    } else {
                        writeOneEnty(db, noteTabelCellOrder);
                    }
                }
            } else {
                final List<NoteTabelCellOrder> areas = noteDatabaseParam.objects;
                db.beginTransaction(); // 手动设置开始事务
                for (NoteTabelCellOrder noteTabelCellOrder : areas) {
                    if (noteDatabaseParam.handleType == DBHandleType.WRITE) {
                        if (noteTabelCellOrder.isDeleted()) {
                            deleteOneEnty(db, noteTabelCellOrder.getId());
                        } else {
                            writeOneEnty(db, noteTabelCellOrder);
                        }
                        affectedNum++;
                    }
                }
                // 数据插入操作循环
                db.setTransactionSuccessful(); // 设置事务处理成功，不设置会自动回滚不提交
                db.endTransaction(); // 处理完成
            }
            noteDatabaseParam.affectedNum = affectedNum;
        }

    }

    private NoteTabelCellOrder readOneEnty(Cursor cursor) {
        final String jsonStr = cursor.getString(cursor.getColumnIndex(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_JSON));
        final String idStr = cursor.getString(cursor.getColumnIndex(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID));
        final NoteTabelCellOrder NoteTabelCellOrder = (NoteTabelCellOrder) JsonCommonUtils.jsonToObject(jsonStr, NoteTabelCellOrder.class);
        if (NoteTabelCellOrder != null)
            NoteTabelCellOrder.setId(Long.valueOf(idStr) == null ? 0 : Long.valueOf(idStr));
        return NoteTabelCellOrder;
    }

    private void writeOneEnty(SQLiteDatabase db, NoteTabelCellOrder NoteTabelCellOrder) {
        final ContentValues cv = new ContentValues();
        final Long aeraId = NoteTabelCellOrder.getId();
        try {
            cv.put(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_JSON, JsonCommonUtils.objectToJson(NoteTabelCellOrder));
            final int ret = db.update(LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME, cv, LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID + "='" + aeraId + "'", null);
            if (ret <= 0) {
//				cv.put(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID, aeraId);
//				cv.put(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID,null);//键值为自增长时，也可不用
                safeInsert(db, LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME, cv);
            }
        } catch (Exception e) {
            if (!tabbleIsExist(LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME, db)) {
                db.execSQL(createTableSql());
//				cv.put(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID, aeraId);
//				cv.put(LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID,null);//键值为自增长时，也可不用
                db.insert(LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME, null, cv);
            }
        }
    }

    private int deleteOneEnty(SQLiteDatabase db, Long aeraId) {
        int deleteNum = 0;
        try {
            deleteNum = db.delete(LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME, LiferDatabaseColumns.LocalNoteTabelCellOrder.COLUMN_ID + "='" + aeraId + "'", null);
        } catch (Exception e) {
            return deleteNum;
        }
        return deleteNum;
    }

    private long queryRows(SQLiteDatabase db) {
        long rowsNum = 0;
        try {
            String sql = "SELECT COUNT(*) FROM " + LiferDatabaseColumns.LocalNoteTabelCellOrder.TABLENAME;
            SQLiteStatement statement = db.compileStatement(sql);
            rowsNum = statement.simpleQueryForLong();
            LogUtil.e("rowsNum:" + rowsNum);
        } catch (Exception e) {
            return rowsNum;
        }
        return rowsNum;
    }

    @Override
    public void run(Context context, Object... params) throws Exception {
        noteDatabaseParam = (NoteDatabaseParam) params[0];
        final int type = noteDatabaseParam.handleType;
        if (type == DBHandleType.WRITE) {
            requestExecute(false);
        } else if (type == DBHandleType.DELETE) {
            requestExecute(false);
        } else {
            requestExecute(true);
        }
    }

}
