package com.wxl.export.lifter.common.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * 
 * @com.wxl.export.lifter.common.widget.view
 * @HuiyuantongVenusShopCash-V3.x
 * @ButtonWithFrame.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: TODO
 * @2015-2-9上午10:53:13
 */

public class ButtonWithFrame extends Button
{

	private Paint framePaint;
	private int mBorderColor = 0xFF868F53;

	public ButtonWithFrame(Context context)
	{
		super(context);
		initFramePaint();
	}

	public ButtonWithFrame(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		initFramePaint();
	}

	public ButtonWithFrame(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initFramePaint();
	}

	public void initFramePaint()
	{
		this.framePaint = new Paint(mBorderColor);
		this.framePaint.setStyle(Style.FILL);
	}

	@Override
	protected void dispatchDraw(Canvas canvas)
	{
		super.dispatchDraw(canvas);
		canvas.drawRect(0, 0, 1, getHeight(), framePaint);
		canvas.drawRect(0, 0, getWidth(), 1, framePaint);
		canvas.drawRect(0, getHeight() - 1, getWidth(), getHeight(), framePaint);
		canvas.drawRect(getWidth() - 1, 0, getWidth(), getHeight(), framePaint);
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
	}

}
