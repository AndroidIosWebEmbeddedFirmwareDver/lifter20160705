package com.wxl.export.lifter.common.utils.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wxl.export.lifter.common.R;


/**
 * 
 * @com.wxl.export.lifter.common.utils.common
 * @HuiyuantongVenusShopCash-V3.x
 * @ToastManager.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 提示管理器
 * @2015-2-11下午2:30:09
 */

@SuppressLint("InflateParams")
public class ToastManager
{

	private static ToastManager instance;
	private Toast toastLast;
	private int resIdLast;
	private long showTimeLast;
	private Context context;
	private final Handler handler;

	public static ToastManager getInstance(Context context)
	{
		if (instance == null)
		{
			instance = new ToastManager();
		}
		instance.context = context;
		return instance;
	}

	private ToastManager()
	{
		handler = new Handler();
	}

	private Runnable mRunnable = new Runnable()
	{
		public void run()
		{
			View layout = LayoutInflater.from(context).inflate(R.layout.zone_toast_layout, null);
			TextView text = (TextView) layout.findViewById(R.id.tvForToast);
			text.setText(context.getString(resIdLast));
			toastLast = new Toast(context);
			toastLast.setGravity(Gravity.CENTER, 0, 0);
			toastLast.setDuration(Toast.LENGTH_LONG);
			toastLast.setView(layout);
			toastLast.show();
			showTimeLast = System.currentTimeMillis();
		}
	};

	public void show(int nResId)
	{
		if (nResId == resIdLast)
		{
			if (System.currentTimeMillis() - showTimeLast < 2000)
			{
				return;
			}
		}
		if (toastLast != null)
		{
			toastLast.cancel();
		}

		resIdLast = nResId;
		handler.removeCallbacks(mRunnable);
		handler.post(mRunnable);
	}

	public void show(final String strText)
	{
		if (TextUtils.isEmpty(strText))
		{
			return;
		}
		handler.post(new Runnable()
		{
			public void run()
			{
				View layout = LayoutInflater.from(context).inflate(R.layout.zone_toast_layout, null);
				TextView text = (TextView) layout.findViewById(R.id.tvForToast);
				text.setText(strText);
				toastLast = new Toast(context);
				toastLast.setGravity(Gravity.CENTER, 0, 0);
				toastLast.setDuration(Toast.LENGTH_LONG);
				toastLast.setView(layout);
				toastLast.show();
				showTimeLast = System.currentTimeMillis();
			}
		});
	}

	public void showLong(final String strText)
	{
		if (TextUtils.isEmpty(strText))
		{
			return;
		}
		handler.post(new Runnable()
		{
			public void run()
			{
				View layout = LayoutInflater.from(context).inflate(R.layout.zone_toast_layout, null);
				TextView text = (TextView) layout.findViewById(R.id.tvForToast);
				text.setText(strText);
				toastLast = new Toast(context);
				toastLast.setGravity(Gravity.CENTER, 0, 0);
				toastLast.setDuration(Toast.LENGTH_LONG);
				toastLast.setView(layout);
				toastLast.show();
				showTimeLast = System.currentTimeMillis();
			}
		});
	}

}
