package com.wxl.export.lifter.common.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;

import com.wxl.export.lifter.common.utils.core.EventManager;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;


/**
 * 
 * @Desc: 全局事件管理器
 * @com.wxl.export.lifter.common.manager
 * @HuiyuantongVenusMobileCash-V3.x
 * @AndroidEventManager.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午2:53:24
 */
public class AndroidEventManager extends EventManager
{

	public  static  String EVENT_LOG_TAG="EventManager日志：";
	private static AndroidEventManager sInstance;


	private static final int WHAT_EVENT_NOTIFY = 1;
	private static final int WHAT_EVENT_RUN = 2;

	private SparseArray<MobileCashBaseEvent> codeToEventMap = new SparseArray<MobileCashBaseEvent>();

	private List<EventWrapper> eventWrappers = new LinkedList<EventWrapper>();

	private Map<MobileCashBaseEvent, MobileCashBaseEvent> eventRunningMap = new ConcurrentHashMap<MobileCashBaseEvent, MobileCashBaseEvent>();

	private List<MobileCashBaseEvent> eventNotifyEvents = new LinkedList<MobileCashBaseEvent>();
	private boolean isEventNotifying;

	private SparseArray<List<OnEventListener>> codeToEventListenerMap = new SparseArray<List<OnEventListener>>();
	private SparseArray<List<OnEventListener>> codeToEventListenerAddCacheMap = new SparseArray<List<OnEventListener>>();
	private SparseArray<List<OnEventListener>> codeToEventListenerRemoveCacheMap = new SparseArray<List<OnEventListener>>();
	private boolean isMapListenerLock = false;
	private SparseArray<OnEventListener> listenerUserOnceMap = new SparseArray<OnEventListener>();

	private Map<MobileCashBaseEvent, List<ParamWrapper>> eventToWaitRunParamMap = new ConcurrentHashMap<MobileCashBaseEvent, List<ParamWrapper>>();

	private static Handler handler = new Handler(Looper.getMainLooper())
	{
		@Override
		public void handleMessage(Message msg)
		{
			final int nWhat = msg.what;
			if (nWhat == WHAT_EVENT_RUN)
			{
				EventWrapper ew = (EventWrapper) msg.obj;
				sInstance.runEvent(ew.mEvent,ew.mContext,ew.mParams);
				sInstance.recycleEventWrapper(ew);
			} else if (nWhat == WHAT_EVENT_NOTIFY)
			{
				sInstance.doNotify((MobileCashBaseEvent) msg.obj);
			}
		}
	};

	public static Handler getMainThreadHandler()
	{
		return sInstance.handler;
	}

	/**
	 *
	 * @return
     */
	public static AndroidEventManager getInstance()
	{
		if (sInstance == null)
		{
			sInstance = new AndroidEventManager();
		}
		return sInstance;
	}

	@Override
	public void addEvent(MobileCashBaseEvent event)
	{
		codeToEventMap.put(event.getEventCode(), event);
	}

	@Override
	public void removeEvent(int nEventCode)
	{
		codeToEventMap.remove(nEventCode);
	}

	@Override
	public void removeAllEvent()
	{
		codeToEventMap.clear();
	}

	@Override
	public void postEvent(int nEventCode, long delayMillis, Context context,Object... params)
	{
		MobileCashBaseEvent event = getEvent(nEventCode);
		postEvent(event, delayMillis,context, params);
	}

	public void postEvent(int nEventCode, long delayMillis, View view,  Context context,Object... params)
	{
		MobileCashBaseEvent event = getEvent(nEventCode);
		event.relationView = view;
		postEvent(event, delayMillis, context,params);
	}

	@Override
	public void postEvent(MobileCashBaseEvent event, long delayMillis, Context context,Object... params)
	{
		if (event != null)
		{
			EventWrapper ew = obtainEventWrapper();
			ew.set(event, context,params);
			handler.sendMessageDelayed(handler.obtainMessage(WHAT_EVENT_RUN, ew), delayMillis);
		}
	}

	private synchronized EventWrapper obtainEventWrapper()
	{
		if (eventWrappers.size() > 0)
		{
			EventWrapper ev = eventWrappers.get(0);
			eventWrappers.remove(0);
			return ev;
		}
		return new EventWrapper();
	}

	/**
	 * 
	 * @param ew
	 */
	private synchronized void recycleEventWrapper(EventWrapper ew)
	{
		ew.clear();
		eventWrappers.add(ew);
	}

	/**
	 * 添加监听者
	 * 
	 * @param nEventCode
	 *            事件code编号
	 * @param listener
	 *            监听者对象
	 * @param bOnce
	 *            是否只是监听这一次
	 */
	public void addEventListener(int nEventCode, OnEventListener listener, boolean bOnce)
	{
		if (isMapListenerLock)
		{
			addToListenerMap(codeToEventListenerAddCacheMap, nEventCode, listener);
		} else
		{
			addToListenerMap(codeToEventListenerMap, nEventCode, listener);
		}
		if (bOnce)
		{
			listenerUserOnceMap.put(calculateHashCode(nEventCode, listener), listener);
		}
	}

	/**
	 * 移除监听者
	 * 
	 * @param nEventCode
	 *            事件code编号
	 * @param listener
	 *            监听者对象
	 */
	public void removeEventListener(int nEventCode, OnEventListener listener)
	{
		if (isMapListenerLock)
		{
			addToListenerMap(codeToEventListenerRemoveCacheMap, nEventCode, listener);
		} else
		{
			List<OnEventListener> listeners = codeToEventListenerMap.get(nEventCode);
			if (listeners != null)
			{
				listeners.remove(listener);
			}
		}
	}

	/**
	 * 计算HashCode
	 * 
	 * @param nEventCode
	 * @param listener
	 * @return
	 */
	private int calculateHashCode(int nEventCode, OnEventListener listener)
	{
		int nResult = nEventCode;
		nResult = nResult * 29 + listener.hashCode();
		return nResult;
	}

	/**
	 * 发送通知
	 * 
	 * @param event
	 */
	private synchronized void doNotify(MobileCashBaseEvent event)
	{
		isEventNotifying = true;
		isMapListenerLock = true;
		List<OnEventListener> list = codeToEventListenerMap.get(event.getEventCode());
		if (list != null)
		{
			List<OnEventListener> listNeedRemove = null;
			try
			{
				for (OnEventListener listener : list)
				{
					try
					{
						listener.onEventRunEnd(event);
					} catch (Exception e)
					{
						// TODO: handle exception
						Log.e(EVENT_LOG_TAG,"listener->onEventRunEnd 未成功！" + listener);
					}

					int nHashCode = calculateHashCode(event.getEventCode(), listener);
					if (listenerUserOnceMap.get(nHashCode) != null)
					{
						listenerUserOnceMap.remove(nHashCode);
						if (listNeedRemove == null)
						{
							listNeedRemove = new ArrayList<EventManager.OnEventListener>();
						}
						listNeedRemove.add(listener);
						Log.e(EVENT_LOG_TAG,"removeOnce Code:" + event.getEventCode() + " listener:" + listener);
					}
				}
			} catch (Exception e)
			{
				// TODO: handle exception
				Log.e(EVENT_LOG_TAG,"listener->onEventRunEnd 未成功！");
			}
			if (listNeedRemove != null)
			{
				list.removeAll(listNeedRemove);
			}
		}
		isMapListenerLock = false;

		isEventNotifying = false;

		if (codeToEventListenerAddCacheMap.size() > 0)
		{
			int nSize = codeToEventListenerAddCacheMap.size();
			for (int nIndex = 0; nIndex < nSize; ++nIndex)
			{
				int nCode = codeToEventListenerAddCacheMap.keyAt(nIndex);
				List<OnEventListener> listCache = codeToEventListenerAddCacheMap.get(nCode);
				if (listCache.size() > 0)
				{
					List<OnEventListener> listeners = codeToEventListenerMap.get(nCode);
					if (listeners == null)
					{
						listeners = new LinkedList<AndroidEventManager.OnEventListener>();
						codeToEventListenerMap.put(nCode, listeners);
					}
					listeners.addAll(listCache);
				}
			}
			codeToEventListenerAddCacheMap.clear();
		}
		if (codeToEventListenerRemoveCacheMap.size() > 0)
		{
			int nSize = codeToEventListenerRemoveCacheMap.size();
			for (int nIndex = 0; nIndex < nSize; ++nIndex)
			{
				int nCode = codeToEventListenerRemoveCacheMap.keyAt(nIndex);
				List<OnEventListener> listCache = codeToEventListenerRemoveCacheMap.get(nCode);
				if (listCache.size() > 0)
				{
					List<OnEventListener> listeners = codeToEventListenerMap.get(nCode);
					if (listeners != null)
					{
						listeners.removeAll(listCache);
					}
				}
			}
			codeToEventListenerRemoveCacheMap.clear();
		}

		if (eventNotifyEvents.size() > 0)
		{
			MobileCashBaseEvent eventNotify = eventNotifyEvents.get(0);
			eventNotifyEvents.remove(0);
			handler.sendMessage(handler.obtainMessage(WHAT_EVENT_NOTIFY, eventNotify));
		}

	}

	@Override
	public MobileCashBaseEvent runEvent(int nEventCode,Context context, Object... params)
	{
		MobileCashBaseEvent event = getEvent(nEventCode);
		return runEvent(event,context, params);
	}

	@Override
	public MobileCashBaseEvent runEvent(MobileCashBaseEvent event,final Context context,final Object... params)
	{
		if (event == null)
		{
			return null;
		}
		if (eventRunningMap.containsKey(event))
		{
			if (event.isWaitRunWhenRunning())
			{
				List<ParamWrapper> listParamWrapper = eventToWaitRunParamMap.get(event);
				if (listParamWrapper == null)
				{
					listParamWrapper = Collections.synchronizedList(new LinkedList<ParamWrapper>());
					eventToWaitRunParamMap.put(event, listParamWrapper);
				}
				listParamWrapper.add(new ParamWrapper(context,params));
			}
			return null;
		}

		eventRunningMap.put(event, event);

		if (event.isAsyncRun())
		{
			final MobileCashBaseEvent localEvent = event;

			localEvent.onPreRun();
			new Thread()
			{
				@Override
				public void run()
				{
					try
					{
						synchronized (AndroidEventManager.class)
						{
							localEvent.run(context,params);
						}
					} catch (Exception e)
					{
						e.printStackTrace();
					} finally
					{
						AndroidEventManager.getMainThreadHandler().post(new Runnable()
						{
							@Override
							public void run()
							{
								onEventRunEnd(localEvent);
							}
						});
					}
				}
			}.start();
		} else
		{
			try
			{
				event.run(context,params);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			onEventRunEnd(event);
		}
		return event;

	}

	private void addToListenerMap(SparseArray<List<OnEventListener>> map, int nEventCode, OnEventListener listener)
	{
		List<OnEventListener> listeners = map.get(nEventCode);
		if (listeners == null)
		{
			listeners = new LinkedList<AndroidEventManager.OnEventListener>();
			map.put(nEventCode, listeners);
		}
		listeners.add(listener);
	}

	protected void onEventRunEnd(MobileCashBaseEvent event)
	{
		eventRunningMap.remove(event);

		event.onRunEnd();

		if (event.isNotifyAfterRun())
		{
			notifyEventRunEnd(event);
		}

		List<ParamWrapper> listParamWrapper = eventToWaitRunParamMap.get(event);
		if (listParamWrapper != null)
		{
			if (listParamWrapper.size() > 0)
			{
				ParamWrapper param = listParamWrapper.get(0);
				listParamWrapper.remove(param);
				postEvent(event, 0,param.mContext,param.mParams);
				if (listParamWrapper.size() == 0)
				{
					eventToWaitRunParamMap.remove(event);
				}
			}
		}
	}

	/**
	 * 事件结束时发送通知
	 * 
	 * @param event
	 */
	private void notifyEventRunEnd(MobileCashBaseEvent event)
	{
		if (isEventNotifying)
		{
			eventNotifyEvents.add(event);
		} else
		{
			doNotify(event);
		}
	}

	public MobileCashBaseEvent getEvent(int nEventCode)
	{
		return codeToEventMap.get(nEventCode);
	}

	private static class EventWrapper
	{
		public MobileCashBaseEvent mEvent;
		public  Context mContext;
		public Object[] mParams;

		public void set(MobileCashBaseEvent event, Context context, Object... params)
		{
			mEvent = event;
			mContext=context;
			mParams = params;
		}

		public void clear()
		{
			mEvent = null;
			mContext=null;
			mParams = null;
		}
	}

	private static class ParamWrapper
	{
		public  Context mContext;
		public Object[] mParams;

		public ParamWrapper(Context context,Object[] params)
		{
			mContext=context;
			mParams = params;
		}
	}

}
