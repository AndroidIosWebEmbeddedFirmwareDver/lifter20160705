package com.wxl.export.lifter.activity.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.adapter.BaseFragmentPagerAdapter;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.lifter.R;

public class NoteBookActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private ViewPager notebookViewpager;
    private BaseFragmentPagerAdapter baseFragmentPagerAdapter;

    private Button btn_note_book_detials, btn_note_book_charts, btn_note_book_accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_note_book);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void OnInitUiAndData() {
        iniNaviUserInterface();
        btn_note_book_detials = (Button) findViewById(R.id.btn_note_book_detials);
        btn_note_book_charts = (Button) findViewById(R.id.btn_note_book_charts);
        btn_note_book_accounts = (Button) findViewById(R.id.btn_note_book_accounts);
        notebookViewpager = (ViewPager) findViewById(R.id.vp_note_book_fragments);
        baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void OnBindDataWithUi() {
        text_top_middle.setText(R.string.activity_navi_title_of_note);
        findViewById(R.id.btn_note_book_detials).setSelected(true);
        baseFragmentPagerAdapter.addItem(new NoteDetialsFragment());
        baseFragmentPagerAdapter.addItem(new NoteChartsFragment());
        baseFragmentPagerAdapter.addItem(new NoteAccountsFragment());
        notebookViewpager.setAdapter(baseFragmentPagerAdapter);
        notebookViewpager.setCurrentItem(0);
        notebookViewpager.setOnPageChangeListener(this);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_top_left) {
            onBackPressed();
        } else if (v.getId() == R.id.btn_note_book_detials) {
            notebookViewpager.setCurrentItem(0);
        } else if (v.getId() == R.id.btn_note_book_charts) {
            notebookViewpager.setCurrentItem(1);
        } else if (v.getId() == R.id.btn_note_book_accounts) {
            notebookViewpager.setCurrentItem(2);
        }

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeButtonStstus(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public void changeButtonStstus(int position) {
        switch (position) {
            case 0:
                btn_note_book_detials.setSelected(true);
                btn_note_book_charts.setSelected(false);
                btn_note_book_accounts.setSelected(false);
                break;
            case 1:
                btn_note_book_detials.setSelected(false);
                btn_note_book_charts.setSelected(true);
                btn_note_book_accounts.setSelected(false);
                break;
            case 2:
                btn_note_book_detials.setSelected(false);
                btn_note_book_charts.setSelected(false);
                btn_note_book_accounts.setSelected(true);
                break;
        }
    }

    /**
     * @param activity
     */
    public static void lunch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, NoteBookActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
