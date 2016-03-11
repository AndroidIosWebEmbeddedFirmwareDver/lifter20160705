package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;

import com.wxl.export.lifter.common.utils.core.HttpUtils;

/**
 * 
 * @com.wxl.export.lifter.common.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @DownloadEvetn.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: TODO
 * @2015-2-4下午4:00:53
 */
public class DownloadEvent extends HttpEvent
{
	public final static int NO_NET = 0;
	public final static int FAILD = 1;
	public final static int SUCCESS = 2;

	public DownloadEvent(int nEventCode)
	{
		super(nEventCode);
	}

	@Override
	public void run(Context context, Object... params) throws Exception
	{
		super.run(context,params);
		switch (HttpUtils.downFile(strUrl,context))
		{
		case FAILD:
			isNetSuccess = true;
			isMethodNotAllowed = true;
			break;

		case SUCCESS:
			isNetSuccess = true;
			isOk = true;
			break;
		}
	}
}
