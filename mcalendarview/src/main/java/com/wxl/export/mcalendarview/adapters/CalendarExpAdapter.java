package com.wxl.export.mcalendarview.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import com.wxl.export.mcalendarview.MarkStyle;
import com.wxl.export.mcalendarview.listeners.OnDateClickListener;
import com.wxl.export.mcalendarview.utils.CurrentCalendar;
import com.wxl.export.mcalendarview.views.BaseCellView;
import com.wxl.export.mcalendarview.views.BaseMarkView;
import com.wxl.export.mcalendarview.views.DefaultMarkView;
import com.wxl.export.mcalendarview.views.ExpandCellView;
import com.wxl.export.mcalendarview.vo.DayData;
import com.wxl.export.mcalendarview.vo.MarkedDates;

/**
 * Created by Bigflower on 2015/12/8.
 */
public class CalendarExpAdapter extends ArrayAdapter {
    private ArrayList data;
    private int cellView = -1;
    private int markView = -1;

    public CalendarExpAdapter(Context context, int resource, ArrayList data) {
        super(context, resource);
        this.data = data;
    }

    public CalendarExpAdapter setCellViews(int cellView, int markView) {
        this.cellView = cellView;
        this.markView = markView;
        return this;
    }


    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View ret = null;
        DayData dayData = (DayData) data.get(position);
        MarkStyle style = MarkedDates.getInstance().check(dayData.getDate());
        boolean marked = style != null;
        if (marked) {
            dayData.getDate().setMarkStyle(style);
            if (markView > 0) {
                BaseMarkView baseMarkView = (BaseMarkView) View.inflate(getContext(), markView, null);
                baseMarkView.setDisplayText(dayData);
                ret = baseMarkView;
            } else {
                ret = new DefaultMarkView(getContext());
                ((DefaultMarkView) ret).setDisplayText(dayData);
            }
        } else {
            if (cellView > 0) {
                BaseCellView baseCellView = (BaseCellView) View.inflate(getContext(), cellView, null);
                baseCellView.setDisplayText(dayData);
                ret = baseCellView;
            } else {
                ret = new ExpandCellView(getContext());
                ((ExpandCellView) ret).setText_Color(dayData.getText(), dayData.getTextColor());
            }
        }
        ((BaseCellView) ret).setDate(dayData.getDate());
        if (OnDateClickListener.instance != null) {
            ((BaseCellView) ret).setOnDateClickListener(OnDateClickListener.instance);
        }
        if (dayData.getDate().equals(CurrentCalendar.getCurrentDateData())) {
            ((ExpandCellView) ret).setDateToday();
        }
        return ret;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}