package com.wxl.export.lifter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxl.export.lifter.enty.show.DefaultGridItemShow;
import com.wxl.export.lifter.common.adapter.base.BaseListAdapter;
import com.wxl.export.lifter.common.utils.common.DensityManagerUtils;
import com.wxl.export.lifter.lifter.R;

/**
 * @Desc: TODO
 * @com.sintn.hera.shop.adapter
 * @HuiyuantongVenusShopCash-V3.x
 * @PaymetSucessActivityFunctionGridAdapter.java
 * @Author:Wxl@Sintn.Inc
 * @2015-5-11下午12:07:32
 */

@SuppressLint("InflateParams")
public class MainActivityGridAdapter<M> extends BaseListAdapter<DefaultGridItemShow> {
    private Context context;
    private ViewHolder viewHolder;
    private static int convertViewWidth; // 宽度
    private static int convertViewHight; // 高度

    public MainActivityGridAdapter(Context context) {
        this.context = context;
        convertViewWidth = DensityManagerUtils.getScreenWithPx(context) / 4;
//        convertViewWidth = ViewGroup.LayoutParams.WRAP_CONTENT;
        convertViewHight = DensityManagerUtils.getScreenWithPx(context) / 4; // 高度
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.acticity_main_adapter_grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_function = (ImageView) convertView.findViewById(R.id.iv_function);
            viewHolder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
            onCreateView(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final DefaultGridItemShow object = (DefaultGridItemShow) getItem(position);
        viewHolder.tv_desc.setText(object.getDesc()==null?"":object.getDesc());
        if (object.getResId() >= 0) viewHolder.iv_function.setImageResource(object.getResId());
        return convertView;
    }

    private void onCreateView(View view) {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
        view.setLayoutParams(lp);
    }

    private static class ViewHolder {
        TextView tv_desc;
        ImageView iv_function;
    }

}
