package com.wxl.export.lifter.enty.db.note;

import com.wxl.export.lifter.common.utils.common.CommonUtils;
import com.wxl.export.lifter.common.utils.common.DateUtil;
import com.wxl.export.lifter.enty.show.NoteOrderSubTypeGridItemShow;

import java.io.Serializable;
import java.util.Date;

/**
 * com.wxl.export.lifter.enty.db.note
 * Sintn
 * Created by Sintn on 16/3/9 下午2:02.
 */
public class NoteTabelCellOrder implements Serializable {
    //创建日期
    private Date createDate;
    //主键
    private long id;
    //类型
    private long noteTypeId;
    //类型描述
    private String noteTypeDesc;
    //收入还是支出,参考NoteTypeConst类
    private int noteType;
    //金额
    private double money;
    //备注
    private String desc;
    //是否删除
    private boolean deleted;
    //订单唯一识别码
    private String orderUuid;
    //子类
    private NoteOrderSubTypeGridItemShow subType;


    public void defaultInit() {
        createDate = DateUtil.getNow();
        orderUuid = CommonUtils.getUuidAsAToken();
    }

    public NoteTabelCellOrder() {
    }

    public NoteTabelCellOrder(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNoteTypeId() {
        return noteTypeId;
    }

    public void setNoteTypeId(long noteTypeId) {
        this.noteTypeId = noteTypeId;
    }

    public String getNoteTypeDesc() {
        return noteTypeDesc;
    }

    public void setNoteTypeDesc(String noteTypeDesc) {
        this.noteTypeDesc = noteTypeDesc;
    }

    public int getNoteType() {
        return noteType;
    }

    public void setNoteType(int noteType) {
        this.noteType = noteType;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public NoteOrderSubTypeGridItemShow getSubType() {
        return subType;
    }

    public void setSubType(NoteOrderSubTypeGridItemShow subType) {
        this.subType = subType;
    }
}
