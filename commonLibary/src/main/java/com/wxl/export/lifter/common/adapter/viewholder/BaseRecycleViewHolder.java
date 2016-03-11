package com.wxl.export.lifter.common.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.wxl.export.lifter.common.adapter.base.BaseRecyclerAdapter;


/**
 * Created by Sintn on 15/11/10.
 */
public class BaseRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    BaseRecyclerAdapter baseRecyclerAdapter;
    View itemView;

    public BaseRecycleViewHolder(View itemView, BaseRecyclerAdapter baseRecyclerAdapter) {
        super(itemView);
        this.itemView = itemView;
        this.baseRecyclerAdapter = baseRecyclerAdapter;
        this.itemView.setOnClickListener(this);
    }

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }

    public BaseRecyclerAdapter getBaseRecyclerAdapter() {
        return baseRecyclerAdapter;
    }

    public void setBaseRecyclerAdapter(BaseRecyclerAdapter baseRecyclerAdapter) {
        this.baseRecyclerAdapter = baseRecyclerAdapter;
    }

    @Override
    public void onClick(View v) {
        Log.e("BaseRecycleViewHolder->", "当前点击的位置：" + getLayoutPosition());
        if (this.baseRecyclerAdapter != null && this.baseRecyclerAdapter.onRecyclerViewItemClickListener != null) {
            this.baseRecyclerAdapter.onRecyclerViewItemClickListener.OnRecyclerViewItemClicked(getLayoutPosition());
        }
    }
}
