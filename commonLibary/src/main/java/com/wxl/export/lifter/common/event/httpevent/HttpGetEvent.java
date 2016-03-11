package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;

import com.wxl.export.lifter.common.utils.core.HttpUtils;

/**
 * 
 * @com.wxl.export.lifter.common.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpGetEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 网络获取事件
 * @2015-2-4下午4:01:09
 */

public class HttpGetEvent extends HttpEvent {

	public HttpGetEvent(int nEventCode) {
		super(nEventCode);
	}

	@Override
	public void run(Context context, Object... params) throws Exception {
		super.run(context,params);
		httpResponse = HttpUtils.doGet(strUrl,context);
		verifyResponse();
	}
}
