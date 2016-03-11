package com.wxl.export.lifter.common.widget.dialog;

import android.app.Dialog;
import android.content.Context;

/**
 * 
 * @com.wxl.export.lifter.common.widget.dialog
 * @HuiyuantongVenusShopCash-V3.x
 * @BaseTouchHiddenSoftInputDialog.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 触摸输入框意外的区域隐藏键盘对话框基类
 * @2015-3-24下午7:44:11
 */
public class BaseTouchHiddenSoftInputDialog extends Dialog
{
	protected Context context = null;

	public BaseTouchHiddenSoftInputDialog(Context context, int style)
	{
		super(context, style);
		this.context = context;
	}

	// // ////////////////点击EditText文本框之外任何地方隐藏键盘/////////////////////////
	// @Override
	// public boolean dispatchTouchEvent(MotionEvent ev)
	// {
	// try
	// {
	// if (ev.getAction() == MotionEvent.ACTION_DOWN)
	// {
	// View v = getCurrentFocus();
	// if (isShouldHideInput(v, ev))
	// {
	//
	// InputMethodManager imm = (InputMethodManager)
	// context.getSystemService(Context.INPUT_METHOD_SERVICE);
	// if (imm != null)
	// {
	// imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
	// }
	// }
	// return super.dispatchTouchEvent(ev);
	// }
	// } catch (Exception e)
	// {
	// // TODO: handle exception
	// }
	// // 必不可少，否则所有的组件都不会有TouchEvent了
	// if (getWindow().superDispatchTouchEvent(ev))
	// {
	// return true;
	// }
	// return onTouchEvent(ev);
	// }
	//
	// public boolean isShouldHideInput(View v, MotionEvent event)
	// {
	// if (v != null && (v instanceof EditText))
	// {
	// int[] leftTop =
	// { 0, 0 };
	// // 获取输入框当前的location位置
	// v.getLocationInWindow(leftTop);
	// int left = leftTop[0];
	// int top = leftTop[1];
	// int bottom = top + v.getHeight();
	// int right = left + v.getWidth();
	// if (event.getX() > left && event.getX() < right && event.getY() > top &&
	// event.getY() < bottom)
	// {
	// // 点击的是输入框区域，保留点击EditText的事件
	// return false;
	// } else
	// {
	// return true;
	// }
	// }
	// return false;
	// }
	//
	// //
	// ///////////////////////////////////////////////////////////////////////////////////////////

}
