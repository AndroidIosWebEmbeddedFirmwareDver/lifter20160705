package com.wxl.export.lifter.activity.todaything;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.utils.common.SystemShareUtil;
import com.wxl.export.lifter.enty.down.TodayHistoryThingDown;
import com.wxl.export.lifter.lifter.R;

public class ToDayThingDetialActivity extends BaseActivity {
    public static String DETIALINFO_EXTRA = "detialinfo";
    private TodayHistoryThingDown detialInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_to_day_thing_detial);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void OnInitUiAndData() {
        iniNaviUserInterface();
    }

    @Override
    public void OnBindDataWithUi() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SystemShareUtil.share(ToDayThingDetialActivity.this, detialInfo.getEvent());
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        if (getIntent().hasExtra(DETIALINFO_EXTRA)) {
            detialInfo = (TodayHistoryThingDown) getIntent().getSerializableExtra(DETIALINFO_EXTRA);
            if (detialInfo != null) {
                toolbar.setTitle(detialInfo.getTitle());
                text_top_middle.setText(detialInfo.getTitle());
                btn_top_right.setVisibility(View.INVISIBLE);
                ((TextView) findViewById(R.id.tv_detial_show)).setText(detialInfo.getEvent());
            }
        }
    }

    /**
     * @param activity
     */

    public static void lunch(Activity activity, TodayHistoryThingDown detialInfo) {
        Intent intent = new Intent();
        intent.setClass(activity, ToDayThingDetialActivity.class);
        intent.putExtra(DETIALINFO_EXTRA, detialInfo);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_top_left) {
            onBackPressed();
        }
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

    }
}
