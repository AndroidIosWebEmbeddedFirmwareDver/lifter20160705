package com.wxl.export.lifter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wxl.export.lifter.common.adapter.base.BaseListAdapter;
import com.wxl.export.lifter.common.utils.common.DensityManagerUtils;
import com.wxl.export.lifter.enty.down.TodayHistoryThingDown;
import com.wxl.export.lifter.lifter.R;

/**
 * @com.sintn.hera.shop.adapter
 * @HuiyuantongVenusShopCash-V3.x
 * @OrderAdapter.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 收银界面订单适配器
 * @2015-2-10上午11:58:22
 */

@SuppressLint("InflateParams")
public class TodayThingActivityListAdapter extends BaseListAdapter<TodayHistoryThingDown> {

    private Context context;
    private ViewHolder viewHolder;
    private int selectedPosition;
    private static int convertViewWidth; // 宽度
    private static int convertViewHight; // 高度

    @SuppressWarnings("deprecation")
    public TodayThingActivityListAdapter(Context context) {
        this.context = context;
//        convertViewWidth = RelativeLayout.LayoutParams.FILL_PARENT; // 宽度
//        convertViewHight = DensityManagerUtils.getScreenWithPx(context) / 18 * 1; // 高度
    }

    public void setSelectedPosition(int selectedOrderPosition) {
        this.selectedPosition = selectedOrderPosition;
        notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.acticity_to_day_thing_adapter_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            convertView.setTag(viewHolder);
//            onCreateView(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final TodayHistoryThingDown todayHistoryThingDown = (TodayHistoryThingDown) getItem(position);
        viewHolder.tv_title.setText(todayHistoryThingDown.getTitle());
        viewHolder.tv_content.setText(todayHistoryThingDown.getEvent());
        Log.e("asdasd", todayHistoryThingDown.getDate());
        viewHolder.tv_date.setText(todayHistoryThingDown.getDate().substring(0, 4) + "-" + todayHistoryThingDown.getDate().substring(4, 6) + "-" + todayHistoryThingDown.getDate().substring(6, 8));
        viewHolder.tv_content.setTag(todayHistoryThingDown);
        return convertView;
    }

    private void onCreateView(View view) {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
        view.setLayoutParams(lp);
    }

    private static class ViewHolder {
        TextView tv_title;
        TextView tv_content;
        TextView tv_date;
    }
}
