package com.wxl.export.lifter.common.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabWidget;

/**
 * 
 * @com.wxl.export.lifter.common.widget.view
 * @HuiyuantongVenusShopCash-V3.x
 * @VerticalTabWidget.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 垂直TabWidget
 * @2015-3-20下午5:00:25
 */

public class VerticalTabWidget extends TabWidget
{

	public VerticalTabWidget(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		setOrientation(LinearLayout.VERTICAL);
	}

	@Override
	public void addView(View child)
	{
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, 88);
		lp.setMargins(0, 24, 0, 0);
		child.setLayoutParams(lp);
		super.addView(child);
	}

}
