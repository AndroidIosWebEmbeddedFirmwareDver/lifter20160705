package com.wxl.export.lifter.common.widget.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("ClickableViewAccessibility")
public class BallView extends View
{

	public BallView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		this.setFocusable(true);// 允许获取上层焦点
	}

	public boolean onTouchEvent(MotionEvent event)
	{
		return true;
	}

}
