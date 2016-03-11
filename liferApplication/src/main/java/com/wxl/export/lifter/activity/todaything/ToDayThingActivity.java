package com.wxl.export.lifter.activity.todaything;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.adapter.TodayThingActivityListAdapter;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.manager.AndroidEventManager;
import com.wxl.export.lifter.common.utils.common.DateUtil;
import com.wxl.export.lifter.common.widget.view.xlistview.XListView;
import com.wxl.export.lifter.enty.ConstEnty;
import com.wxl.export.lifter.event.LiftEventCode;
import com.wxl.export.lifter.event.http.GetTodayHistoryEvent;
import com.wxl.export.lifter.lifter.R;


public class ToDayThingActivity extends BaseActivity implements XListView.IXListViewListener, AdapterView.OnItemClickListener {
    private String realQueryUrl;
    private XListView lsts_today_thing_activity_lists;
    private TodayThingActivityListAdapter todayThingActivityListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_to_day_thing);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void OnInitUiAndData() {
        iniNaviUserInterface();
        lsts_today_thing_activity_lists = (XListView) findViewById(R.id.lsts_today_thing_activity_lists);
        todayThingActivityListAdapter = new TodayThingActivityListAdapter(mContext);
    }

    @Override
    public void OnBindDataWithUi() {
        text_top_middle.setText(R.string.activity_navi_title_of_history_today);
        btn_top_right.setVisibility(View.INVISIBLE);
        queryTodayThing();
        lsts_today_thing_activity_lists.setAdapter(todayThingActivityListAdapter);
        lsts_today_thing_activity_lists.setXListViewListener(this);
        lsts_today_thing_activity_lists.setOnItemClickListener(this);
        lsts_today_thing_activity_lists.setPullRefreshEnable(true);// 开启刷新
        lsts_today_thing_activity_lists.setPullLoadEnable(false);// 禁止加载
    }

    public void queryTodayThing() {
        //?key=123456&day=1231
        realQueryUrl = ConstEnty.HTTP_GET_TODAY_HOSTORY_QUERY + "?key=" + ConstEnty.HISTORYAPP_KEY + "&day=" + DateUtil.getDateShort().substring(4);
        AndroidEventManager.getInstance().addEventListener(LiftEventCode.HTTP_GET_TODAY_HOSTORY_QUERY_CODE, this, true);
        AndroidEventManager.getInstance().postEvent(LiftEventCode.HTTP_GET_TODAY_HOSTORY_QUERY_CODE, 0, mContext, realQueryUrl, null);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_top_left) {
            onBackPressed();
        }
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        if (event.getEventCode() == LiftEventCode.HTTP_GET_TODAY_HOSTORY_QUERY_CODE) {
            final GetTodayHistoryEvent getTodayHistoryEvent = (GetTodayHistoryEvent) event;
            if (getTodayHistoryEvent.isNetSuccess()) {
                if (getTodayHistoryEvent.isOk()) {
                    if (getTodayHistoryEvent.getResult() != null) {
                        if (getTodayHistoryEvent.getResult().getMsg().equals("success")) {
                            todayThingActivityListAdapter.getlistObject().clear();
                            todayThingActivityListAdapter.addAllItem(getTodayHistoryEvent.getResult().getResult());
                            lsts_today_thing_activity_lists.setPullLoadEnable(false);// 开启刷新
                            lsts_today_thing_activity_lists.setPullRefreshEnable(true);// 开启加载
                            todayThingActivityListAdapter.notifyDataSetChanged();
                        } else if (getTodayHistoryEvent.getResult().getReCode() != null) {
                            //成功
                            if (getTodayHistoryEvent.getResult().getReCode().equals("200")) {
                                todayThingActivityListAdapter.getlistObject().clear();
                                todayThingActivityListAdapter.addAllItem(getTodayHistoryEvent.getResult().getResult());
                                lsts_today_thing_activity_lists.setPullLoadEnable(false);// 开启刷新
                                lsts_today_thing_activity_lists.setPullRefreshEnable(true);// 开启加载
                                todayThingActivityListAdapter.notifyDataSetChanged();
                            }
                            //	10001	appkey不合法
//                        10020	接口维护
//                        10021	接口停用
//                        200	成功
//                        21801	查询不到相关数据
//                        21802	day为空或不合法
                            else if (getTodayHistoryEvent.getResult().getReCode().equals("10001")) {


                            } else if (getTodayHistoryEvent.getResult().getReCode().equals("10020")) {


                            } else if (getTodayHistoryEvent.getResult().getReCode().equals("10021")) {


                            } else if (getTodayHistoryEvent.getResult().getReCode().equals("21801")) {


                            } else if (getTodayHistoryEvent.getResult().getReCode().equals("21802")) {


                            }
                        } else {

                        }
                    }
                } else {
                }
                lsts_today_thing_activity_lists.stopRefresh();
                lsts_today_thing_activity_lists.stopLoadMore();
                lsts_today_thing_activity_lists.setRefreshTime(DateUtil.getStringDate());
            }
        }
    }

    /**
     * @param activity
     */

    public static void lunch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, ToDayThingActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realQueryUrl = null;
        lsts_today_thing_activity_lists = null;
        todayThingActivityListAdapter.getlistObject().clear();
        todayThingActivityListAdapter = null;
    }

    @Override
    public void onRefresh() {
        queryTodayThing();
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToDayThingDetialActivity.lunch(this, todayThingActivityListAdapter.getlistObject().get(position - 1));
    }
}
