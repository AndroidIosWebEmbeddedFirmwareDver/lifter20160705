package com.wxl.export.lifter.activity.note;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.interfaces.NoteChoiceCallbackInterface;
import com.wxl.export.lifter.lifter.R;
import com.wxl.export.mcalendarview.CellConfig;
import com.wxl.export.mcalendarview.MarkStyle;
import com.wxl.export.mcalendarview.listeners.OnExpDateClickListener;
import com.wxl.export.mcalendarview.listeners.OnMonthScrollListener;
import com.wxl.export.mcalendarview.views.ExpCalendarView;
import com.wxl.export.mcalendarview.vo.DateData;

import java.util.Calendar;

public class NoteChoiceDateActivity extends BaseActivity implements NoteChoiceCallbackInterface {

    public static String EXTRA_DATES = "datesCallback";

    private TextView tv_activity_note_choice_date_show;
    private ExpCalendarView expclaendar_activity_note_choice_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_note_choice_date);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void iniNaviUserInterface() {
        super.iniNaviUserInterface();
    }

    @Override
    public void OnInitUiAndData() {
        iniNaviUserInterface();
        expclaendar_activity_note_choice_date = ((ExpCalendarView) findViewById(R.id.expclaendar_activity_note_choice_date));
        tv_activity_note_choice_date_show = (TextView) findViewById(R.id.tv_activity_note_choice_date_show);
        expclaendar_activity_note_choice_date.setOnDateClickListener(new OnExpDateClickListener()).setOnMonthScrollListener(new OnMonthScrollListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onMonthChange(int year, int month) {
                tv_activity_note_choice_date_show.setText(String.format("%d年%d月", year, month));
            }

            @Override
            public void onMonthScroll(float positionOffset) {
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void OnBindDataWithUi() {
        btn_top_right.setImageResource(R.drawable.ic_arrow_sure_date);
        text_top_middle.setText(getString(R.string.activity_navi_title_of_choice_date));
        tv_activity_note_choice_date_show.setText(Calendar.getInstance().get(Calendar.YEAR) + "年" + (Calendar.getInstance().get(Calendar.MONTH) + 1) + "月");
        //配置
        CellConfig.Week2MonthPos = CellConfig.middlePosition;
        CellConfig.ifMonth = true;
        expclaendar_activity_note_choice_date.expand();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_top_left) {
            onBackPressed();
        } else if (v.getId() == R.id.btn_top_right) {
            transDateWithIntent();
        }

    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

    }

    /**
     * @param activity
     */
    public static void lunch(Activity activity, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(activity, NoteChoiceDateActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }


    @Override
    public void transDateWithIntent() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATES, expclaendar_activity_note_choice_date.getMarkedDates().getAll());
        setResult(RESULT_OK, intent); //intent为A传来的带有Bundle的intent，当然也可以自己定义新的Bundle
        finish();//此处一定要调用finish()方法
    }
}
