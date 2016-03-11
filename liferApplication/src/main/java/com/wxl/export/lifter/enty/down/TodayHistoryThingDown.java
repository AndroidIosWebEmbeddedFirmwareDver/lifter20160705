package com.wxl.export.lifter.enty.down;

import java.io.Serializable;

/**
 * com.wxl.export.lifter.enty.down
 * Sintn
 * Created by Sintn on 16/3/8 下午5:14.
 */
public class TodayHistoryThingDown implements Serializable {

    //日期
    private String date;
    //月份
    private String month;
    //天
    private String day;
    //标题
    private String title;
    //事件
    private String event;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public TodayHistoryThingDown() {
    }

    public TodayHistoryThingDown(String date, String month, String day, String title, String event) {
        this.date = date;
        this.month = month;
        this.day = day;
        this.title = title;
        this.event = event;
    }
}
