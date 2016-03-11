package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;

import com.wxl.export.lifter.common.utils.core.HttpDefaultUtils;

/**
 * 
 * @Desc: 网络获取事件
 * @com.wxl.export.lifter.common.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpDefaultGetEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-5-19下午3:10:18
 */

public class HttpDefaultGetEvent extends HttpEvent
{

	public HttpDefaultGetEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Context context, Object... params) throws Exception
	{
		super.run(context,params);
		httpResponse = HttpDefaultUtils.doGet(strUrl);
		verifyResponse();
	}
}
