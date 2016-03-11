package com.wxl.export.lifter.common.utils.core;


import android.content.Context;

import com.wxl.export.lifter.common.event.MobileCashBaseEvent;

/**
 * 
 * @Desc: 事件管理器接口类
 * @com.wxl.export.lifter.common.utils.core
 * @HuiyuantongVenusMobileCash-V3.x
 * @EventManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:46:06
 */
public abstract class EventManager
{

	/**
	 * 添加事件
	 * 
	 * @param event
	 */
	public abstract void addEvent(MobileCashBaseEvent event);

	/**
	 * 按照事件编码移除事件
	 * 
	 * @param nEventCode
	 */
	public abstract void removeEvent(int nEventCode);

	/**
	 * 移除所有事件
	 */
	public abstract void removeAllEvent();

	/**
	 * 
	 * @param nEventCode
	 * @param delayMillis
	 * @param params
	 */
	public abstract void postEvent(int nEventCode, long delayMillis, Context context,Object... params);

	/**
	 * 
	 * @param event
	 * @param delayMillis
	 * @param params
	 */
	public abstract void postEvent(final MobileCashBaseEvent event, long delayMillis, Context context,Object... params);

	/**
	 * 
	 * @param nEventCode
	 * @param params
	 * @return
	 */
	public abstract MobileCashBaseEvent runEvent(int nEventCode, Context context,Object... params);

	/**
	 * 
	 * @param event
	 * @param params
	 * @return
	 */
	public abstract MobileCashBaseEvent runEvent(final MobileCashBaseEvent event, Context context, Object... params);

	/**
	 * 
	 * @param nEventCode
	 * @param listener
	 * @param bOnce
	 */
	public abstract void addEventListener(int nEventCode, OnEventListener listener, boolean bOnce);

	/**
	 * 
	 * @param nEventCode
	 * @param listener
	 */
	public abstract void removeEventListener(int nEventCode, OnEventListener listener);

	/**
	 * 
	 * @Description: 事件监听器接口
	 * @ClassName: OnEventListener
	 * @author wxl.sinto.cto
	 * @date 2014-10-15 下午2:50:01
	 * 
	 */
	public static interface OnEventListener
	{
		public void onEventRunEnd(MobileCashBaseEvent event);
	}

}
