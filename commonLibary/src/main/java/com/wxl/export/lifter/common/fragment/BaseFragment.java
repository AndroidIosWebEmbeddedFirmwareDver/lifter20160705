package com.wxl.export.lifter.common.fragment;

import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.event.httpevent.HttpEvent;
import com.wxl.export.lifter.common.listener.OnFragementActivityResult;
import com.wxl.export.lifter.common.manager.AndroidEventManager;
import com.wxl.export.lifter.common.utils.common.CommonUtils;
import com.wxl.export.lifter.common.utils.core.EventManager;


/**
 * @Desc: 碎片基类
 * @com.sintn.hera.mobile.cash.activity.fragment
 * @HuiyuantongVenusMobileCash-V3.x
 * @BaseFragment.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:53:21
 */
@SuppressLint("ClickableViewAccessibility")
public abstract class BaseFragment extends Fragment implements OnFragementActivityResult, OnCheckedChangeListener, EventManager.OnEventListener, OnClickListener, OnItemClickListener {
    /**
     * 每个碎片上所有事件编码集合
     */
    private SparseArray<EventManager.OnEventListener> codeToListenerMap;
    /**
     * 全局事件编码
     */
    protected int eventCode = -1;
    /**
     *
     */
    private boolean loadFinish = false;
    /**
     *
     */
    protected View rootView;
    /**
     *
     */
    protected int clickViewId = -1;
    /**
     *
     */
    protected Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return onRealCreateView(inflater, container, savedInstanceState);
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {
            if (!loadFinish) {
                loadFinish = true;
                new AsyncTask<Void, Integer, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        // TODO Auto-generated method stub
                        OnInitUiAndData();
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        // TODO Auto-generated method stub
                        super.onPostExecute(result);
                        OnBindDataWithUi();
                    }
                }.execute();
            }
        }
    }

    protected abstract View onRealCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * 加载UI元素和数据
     */
    protected abstract void OnInitUiAndData();

    /**
     * 绑定数据到UI元素上
     */
    protected abstract void OnBindDataWithUi();

    @Override
    public abstract void onEventRunEnd(MobileCashBaseEvent event, int eventCode);

    @Override
    public abstract void onItemClick(AdapterView<?> parent, View view, int position, long id);

    @Override
    public abstract void onClick(View view, int clickedViewId);


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO Auto-generated method stub

    }


    @Override
    public void onListChildViewClicked(View view, Object object) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub

    }


    /**
     * 添加回调事件
     *
     * @param nEventCode
     */
    protected void addCallbackEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            codeToListenerMap = new SparseArray<EventManager.OnEventListener>();
        }
        codeToListenerMap.put(nEventCode, this);
        AndroidEventManager.getInstance().addEventListener(nEventCode, this, false);
    }

    /**
     * 移除事件
     *
     * @param nEventCode
     */
    protected void removeCallbackEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            return;
        }
        codeToListenerMap.remove(nEventCode);
        AndroidEventManager.getInstance().removeEventListener(nEventCode, this);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        // TODO Auto-generated method stub
        eventCode = event.getEventCode();
        onEventRunEnd(event, eventCode);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (CommonUtils.isButtonFastClickAtALittleTime()) {
            return;
        } else {
            clickViewId = v.getId();
            onClick(v, clickViewId);
        }
    }

    protected void showMessageAndJumpToLogin() {
        // TODO Auto-generated method stub
//        AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(EventCode.CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR), 0);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (codeToListenerMap != null) {
            final int nCount = codeToListenerMap.size();
            for (int nIndex = 0; nIndex < nCount; ++nIndex) {
                removeCallbackEventListener(codeToListenerMap.keyAt(nIndex));
            }
            codeToListenerMap.clear();
        }
        // 强制清理此对象资源
        System.gc();
    }

    //返回当前日期
    public Date getDate() {
        return new Date(System.currentTimeMillis());
    }

}
