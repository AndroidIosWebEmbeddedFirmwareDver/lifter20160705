package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;

import com.wxl.export.lifter.common.utils.core.HttpUtils;

/**
 * 
 * @com.wxl.export.lifter.common.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpDeleteEvent.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: http->delete
 * @2015-2-4下午4:00:12
 */

public class HttpDeleteEvent extends HttpEvent {

	public HttpDeleteEvent(int nEventCode) {
		super(nEventCode);
	}

	@Override
	public void run(Context context,Object... params) throws Exception {
		super.run(context,params);
		httpResponse = HttpUtils.doDelete(strUrl,context);
		verifyResponse();
	}

}
