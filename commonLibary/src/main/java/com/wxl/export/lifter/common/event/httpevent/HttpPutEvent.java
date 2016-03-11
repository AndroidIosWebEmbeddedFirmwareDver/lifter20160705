package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;

import com.wxl.export.lifter.common.utils.core.HttpUtils;

/**
 * 
 * @com.wxl.export.lifter.common.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpPutEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: http->put事件
 * @2015-2-4下午4:02:20
 */
public class HttpPutEvent extends HttpEvent
{

	public HttpPutEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Context context,Object... params) throws Exception
	{
		super.run(context,params);
		httpResponse = HttpUtils.doPut(strUrl, params[1],context);
		verifyResponse();
	}

}
