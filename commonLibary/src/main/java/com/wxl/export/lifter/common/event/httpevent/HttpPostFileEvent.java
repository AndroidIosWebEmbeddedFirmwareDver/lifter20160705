package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;

import com.wxl.export.lifter.common.utils.core.HttpUtils;

import java.io.File;

/**
 * 
 * @com.sintn.hera.woker.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpPostEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 网络POST事件
 * @2015-2-4下午4:01:29
 */
public class HttpPostFileEvent extends HttpEvent
{
	public HttpPostFileEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Context context, Object... params) throws Exception
	{
		super.run(context,params);
		httpResponse = HttpUtils.postFile(strUrl, (File)params[1],context);
		verifyResponse();

	}

}
