package com.wxl.export.lifter.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxl.export.lifter.common.adapter.base.BaseListAdapter;
import com.wxl.export.lifter.common.utils.common.DensityManagerUtils;
import com.wxl.export.lifter.enty.show.NoteOrderSubTypeGridItemShow;
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
public class NoteEditTempleFragmentGridAdapter<M> extends BaseListAdapter<NoteOrderSubTypeGridItemShow> {
    public static int TYPE_OF_OUTEDONE = 1002;
    public static int TYPE_OF_INCOMEER = 1003;
    private Context context;
    private ViewHolder viewHolder;
    private int type;
    private static int convertViewWidth; // 宽度
    private static int convertViewHight; // 高度

    public NoteEditTempleFragmentGridAdapter(Context context, int vertiCalNums, int horizontalNums, boolean isWithEquqlHeight, boolean biaozhun, int type) {
        this.context = context;
        convertViewWidth = DensityManagerUtils.getScreenWithPx(context) / vertiCalNums;
        convertViewHight = DensityManagerUtils.getScreenHightPx(context) / horizontalNums; // 高度
        if (isWithEquqlHeight && biaozhun) convertViewHight = convertViewWidth;
        else if (isWithEquqlHeight && (!biaozhun)) convertViewWidth = convertViewHight;
        this.type = type;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.acticity_note_add_order_type_adapter_grid_item, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_bg_function = (ImageView) convertView.findViewById(R.id.iv_bg_function);
            viewHolder.iv_function = (ImageView) convertView.findViewById(R.id.iv_function);
            viewHolder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(viewHolder);
            onCreateView(convertView);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final NoteOrderSubTypeGridItemShow object = (NoteOrderSubTypeGridItemShow) getItem(position);
        viewHolder.tv_desc.setText(context.getString(object.getDescResId()));
        if (object.isSelected()) {
            if (type == TYPE_OF_INCOMEER)
                viewHolder.iv_bg_function.setImageResource(R.drawable.icon_indator_bg_income);
            else if (type == TYPE_OF_OUTEDONE)
                viewHolder.iv_bg_function.setImageResource(R.drawable.icon_indator_bg_outcone);
            else
                viewHolder.iv_bg_function.setImageResource(R.drawable.icon_indator_bg_normal);
            viewHolder.iv_function.setImageResource(object.getPressedResId());
        } else {
            viewHolder.iv_bg_function.setImageResource(R.drawable.icon_indator_bg_normal);
            viewHolder.iv_function.setImageResource(object.getNormalResId());
        }
        return convertView;
    }

    private void onCreateView(View view) {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(convertViewWidth, convertViewHight);
        view.setLayoutParams(lp);
    }

    private static class ViewHolder {
        TextView tv_desc;
        ImageView iv_bg_function;
        ImageView iv_function;
    }

}
