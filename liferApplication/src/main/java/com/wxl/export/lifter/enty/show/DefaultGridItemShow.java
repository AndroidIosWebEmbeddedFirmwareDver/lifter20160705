package com.wxl.export.lifter.enty.show;

/**
 * Created by Sintn on 16/1/13.
 */
public class DefaultGridItemShow {
    /**
     * 功能文字描述
     */
    private String desc;
    /**
     * 功能图片resID
     */
    private int resId;


    public DefaultGridItemShow(String desc, int resId) {
        this.desc = desc;
        this.resId = resId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
