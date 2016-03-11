package com.wxl.export.lifter.interfaces;

import com.wxl.export.lifter.enty.show.DefaultGridItemShow;

import java.util.List;

/**
 * com.wxl.export.lifter.interfaces
 * Sintn
 * Created by Sintn on 16/3/10 上午10:40.
 */
public interface ChangInconmeBetwoonOutdoneInterface {
    public void changeToIncome();

    public void changeToOutdone();

    public void initIndicator();

    public void setIndicatorPosition(int position);
}
