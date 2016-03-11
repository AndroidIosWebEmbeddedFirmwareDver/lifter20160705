package com.wxl.export.lifter.common.event;

import android.content.Context;

/**
 * 
 * @Desc: 回调执行事件类
 * @com.wxl.export.lifter.common.event
 * @HuiyuantongVenusMobileCash-V3.x
 * @MobileCashBaseCallbackEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:41:25
 */

public class MobileCashBaseCallbackEvent extends MobileCashBaseEvent
{

	private Object returnParam;// 回调参数
	private boolean initParam = false;// 是否是初始化参数

	public MobileCashBaseCallbackEvent(int nEventCode)
	{
		super(nEventCode);
		isAsyncRun = false;
		isNotifyAfterRun = true;
	}

	public MobileCashBaseCallbackEvent(int nEventCode, Object returnParam)
	{
		this(nEventCode);
		this.returnParam = returnParam;
		initParam = true;
	}

	public Object getReturnParam()
	{
		return returnParam;
	}

	@Override
	public void run(Context context, Object... params) throws Exception
	{
		if (params != null && params.length > 0)
		{
			if (initParam)
			{
				if (params[0] != null)
				{
					returnParam = params[0];
				}
			} else
			{
				returnParam = params[0];
			}
		} else
		{
			if (!initParam)
			{
				returnParam = null;
			}
		}
	}

}
