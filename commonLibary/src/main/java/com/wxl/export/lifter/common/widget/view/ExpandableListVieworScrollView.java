package com.wxl.export.lifter.common.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 * 
 * @com.wxl.export.lifter.common.widget.view
 * @HuiyuantongVenusShopCash-V3.x
 * @MyGridView.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: TODO
 * @2015-2-12上午11:40:20
 */

public class ExpandableListVieworScrollView extends ExpandableListView
{

	public ExpandableListVieworScrollView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public ExpandableListVieworScrollView(Context context)
	{
		super(context);
	}

	public ExpandableListVieworScrollView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
