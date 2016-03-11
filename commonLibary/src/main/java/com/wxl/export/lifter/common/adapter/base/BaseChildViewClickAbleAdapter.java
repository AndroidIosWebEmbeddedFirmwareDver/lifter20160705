package com.wxl.export.lifter.common.adapter.base;

import android.view.View;
import android.view.View.OnClickListener;

import com.wxl.export.lifter.common.listener.OnListViewChildViewClickListener;


/**
 * 
 * @Desc: 基础子ItemView点击事件
 * @com.wxl.export.easyproject.adapter
 * @HuiyuantongVenus-V3.x
 * @SetBaseChildViewClickAbleAdapter.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:19:10
 */

public abstract class BaseChildViewClickAbleAdapter<E extends Object> extends BaseListAdapter<E> implements OnClickListener
{

	private OnListViewChildViewClickListener onListViewChildViewClickListener;

	public void setOnListViewChildViewClickListener(OnListViewChildViewClickListener onListViewChildViewClickListener)
	{
		this.onListViewChildViewClickListener = onListViewChildViewClickListener;
	}

	@Override
	public void onClick(View v)
	{
		onListViewChildViewClickListener.onListChildViewClicked(v, v.getTag());
	}

}
