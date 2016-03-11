package com.wxl.export.lifter.enty.db.note;

import com.wxl.export.lifter.common.entity.dbparam.DBBaseParam;

/**
 * com.wxl.export.lifter.enty.db.note
 * Sintn
 * Created by Sintn on 16/3/9 下午2:19.
 */
public class NoteDatabaseParam extends DBBaseParam<NoteTabelCellOrder>{
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NoteDatabaseParam(int handleType) {
        this.handleType = handleType;
    }
}
