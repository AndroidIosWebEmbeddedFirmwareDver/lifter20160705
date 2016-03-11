package com.wxl.export.lifter.enty.show;

import java.io.Serializable;

/**
 * Created by Sintn on 16/1/13.
 */
public class NoteOrderSubTypeGridItemShow implements Serializable {
    //类型ID，唯一识别标志
    private int typeId;
    //文字描述
    private int descResId;
    //normal 图标
    private int normalResId;
    //pressed 图标
    private int pressedResId;
    //selected 图标
    private int selectedResId;
    //是否选中
    private boolean isSelected;

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getDescResId() {
        return descResId;
    }

    public void setDescResId(int descResId) {
        this.descResId = descResId;
    }

    public int getNormalResId() {
        return normalResId;
    }

    public void setNormalResId(int normalResId) {
        this.normalResId = normalResId;
    }

    public int getSelectedResId() {
        return selectedResId;
    }

    public void setSelectedResId(int selectedResId) {
        this.selectedResId = selectedResId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getPressedResId() {
        return pressedResId;
    }

    public void setPressedResId(int pressedResId) {
        this.pressedResId = pressedResId;
    }

    public NoteOrderSubTypeGridItemShow(int typeId, int descResId, int normalResId, int pressedResId, int selectedResId, boolean isSelected) {
        this.typeId = typeId;
        this.descResId = descResId;
        this.normalResId = normalResId;
        this.pressedResId = pressedResId;
        this.selectedResId = selectedResId;
        this.isSelected = isSelected;
    }

    public NoteOrderSubTypeGridItemShow(int typeId, int descResId, int normalResId, int pressedResId, int selectedResId) {
        this.typeId = typeId;
        this.descResId = descResId;
        this.normalResId = normalResId;
        this.pressedResId = pressedResId;
        this.selectedResId = selectedResId;
    }
}
