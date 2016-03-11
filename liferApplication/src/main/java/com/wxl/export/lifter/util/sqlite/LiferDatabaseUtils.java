package com.wxl.export.lifter.util.sqlite;


import android.content.Context;

import com.wxl.export.lifter.common.entity.dbparam.DBHandleType;
import com.wxl.export.lifter.common.manager.AndroidEventManager;
import com.wxl.export.lifter.enty.db.note.NoteDatabaseParam;
import com.wxl.export.lifter.enty.db.note.NoteTabelCellOrder;
import com.wxl.export.lifter.event.LiftEventCode;
import com.wxl.export.lifter.event.db.NoteDatabaseEvent;

import java.util.List;

/**
 * @Desc: 数据库工具类
 * @com.wxl.export.easyproject.utils.core
 * @HuiyuantongVenus-V3.x
 * @DatabaseUtils.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:44:43
 */

public class LiferDatabaseUtils {

    //本地订单表==============================================================================================================================
    public static void updateNoteTabelCellOrderToDataBase(List<NoteTabelCellOrder> lists, Context context) {
        NoteDatabaseParam dbAreaParam = new NoteDatabaseParam(DBHandleType.WRITE);
        dbAreaParam.objects = lists;
        AndroidEventManager.getInstance().runEvent(new
                NoteDatabaseEvent(LiftEventCode.DB_NOTEBOOKDATABASEHANDLE), context, dbAreaParam);
    }

    public static void deleteNoteTabelCellOrderInDataBase(List<NoteTabelCellOrder> lists, Context context) {
        NoteDatabaseParam dbAreaParam = new NoteDatabaseParam(DBHandleType.DELETE);
        dbAreaParam.objects = lists;
        AndroidEventManager.getInstance().runEvent(new
                NoteDatabaseEvent(LiftEventCode.DB_NOTEBOOKDATABASEHANDLE), context, dbAreaParam);
    }

    public static void writeNoteTabelCellOrdersToDataBase(List<NoteTabelCellOrder> lists, Context context) {
        NoteDatabaseParam dbAreaParam = new NoteDatabaseParam(DBHandleType.WRITE);
        dbAreaParam.objects = lists;
        AndroidEventManager.getInstance().runEvent(new
                NoteDatabaseEvent(LiftEventCode.DB_NOTEBOOKDATABASEHANDLE), context, dbAreaParam);
    }

    public static void writeNoteTabelCellOrderToDataBase(NoteTabelCellOrder object, Context context) {
        NoteDatabaseParam dbAreaParam = new NoteDatabaseParam(DBHandleType.WRITE);
        dbAreaParam.object = object;
        AndroidEventManager.getInstance().runEvent(new
                NoteDatabaseEvent(LiftEventCode.DB_NOTEBOOKDATABASEHANDLE), context, dbAreaParam);
    }

    public static List<NoteTabelCellOrder> readNoteTabelCellOrderFramDataBase(Context context) {
        NoteDatabaseParam dbAreaParam = new NoteDatabaseParam(DBHandleType.READ);
        AndroidEventManager.getInstance().runEvent(new
                NoteDatabaseEvent(LiftEventCode.DB_NOTEBOOKDATABASEHANDLE), context, dbAreaParam);
        return dbAreaParam.objects;
    }

    public static long readNoteTabelCellOrderCountFramDataBase(Context context) {
        NoteDatabaseParam dbAreaParam = new NoteDatabaseParam(DBHandleType.READ_TABLE_COUNT);
        AndroidEventManager.getInstance().runEvent(new
                NoteDatabaseEvent(LiftEventCode.DB_NOTEBOOKDATABASEHANDLE), context, dbAreaParam);
        return dbAreaParam.datasRows;
    }

}
