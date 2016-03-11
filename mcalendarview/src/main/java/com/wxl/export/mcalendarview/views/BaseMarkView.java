package com.wxl.export.mcalendarview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.wxl.export.mcalendarview.listeners.OnDateClickListener;
import com.wxl.export.mcalendarview.vo.DateData;

/**
 * Created by bob.sun on 15/8/28.
 */
public abstract class BaseMarkView extends BaseCellView{
    private OnDateClickListener clickListener;
    private DateData date;

    public BaseMarkView(Context context) {
        super(context);
    }

    public BaseMarkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}
