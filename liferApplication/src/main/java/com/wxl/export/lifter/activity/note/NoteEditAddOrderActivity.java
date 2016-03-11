package com.wxl.export.lifter.activity.note;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.adapter.BaseFragmentPagerAdapter;
import com.wxl.export.lifter.adapter.NoteEditTempleFragmentGridAdapter;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.utils.common.LogUtil;
import com.wxl.export.lifter.enty.constenty.NoteOrderOutdoneSubTypeConst;
import com.wxl.export.lifter.enty.constenty.NoteOrderIncomeSubTypeConst;
import com.wxl.export.lifter.enty.db.note.NoteTabelCellOrder;
import com.wxl.export.lifter.enty.show.NoteOrderSubTypeGridItemShow;
import com.wxl.export.lifter.interfaces.ChangInconmeBetwoonOutdoneInterface;
import com.wxl.export.lifter.lifter.R;
import com.wxl.export.lifter.widget.pop.NoteTypePopupWindow;

import java.util.List;


public class NoteEditAddOrderActivity extends BaseNoteKeyboardToolActivity implements ChangInconmeBetwoonOutdoneInterface, ViewPager.OnPageChangeListener, NoteTypePopupWindow.NoteTypePopupWindowItemOnclickListener, NoteEditAddOrderTempleFragment.NoteEditItemClickListener {
    private static int ERERYVERTIALNUMS = 5;
    private static int ERERYHORINTANUMS = 2;
    public static int CHOICE_DATE_REQUESTCODE = 1009;
    //income 页面ViewPager
    private ViewPager vp_activity_note_edit_add_order_pager_income;
    private BaseFragmentPagerAdapter mBaseFragmentPagerAdapterForIncome;
    //outdone 页面ViewPager
    private ViewPager vp_activity_note_edit_add_order_pager_outdone;
    private BaseFragmentPagerAdapter mBaseFragmentPagerAdapterForOutdone;

    // 指示器LinearLayout
    private LinearLayout ll_activity_note_edit_add_order_indicatorLayout;
    private ImageView[] indicators;

    //NAVI按钮
    private ImageButton btn_top_left;
    private LinearLayout ll_top_type_change;
    private TextView tv_top_type_change_textshow;
    private NoteTypePopupWindow noteTypePopupWindow;

    //数据

    public List<NoteOrderSubTypeGridItemShow> resourceIncome;
    public List<NoteOrderSubTypeGridItemShow> resourceOutdone;
    private boolean flagBetwoonIncomeAndOutdone;
    private boolean flagOutdoneInitFirst;
    private boolean flagIncomeInitFirst;

    //写入数据的数据
    private NoteTabelCellOrder noteTabelCellOrder;

    @Override
    protected void iniNaviUserInterface() {
        btn_top_left = (ImageButton) findViewById(R.id.btn_top_left);
        ll_top_type_change = (LinearLayout) findViewById(R.id.ll_top_type_change);
        tv_top_type_change_textshow = (TextView) findViewById(R.id.tv_top_type_change_textshow);
    }

    @Override
    protected void keyboardToolInit() {
        super.keyboardToolInit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_note_edit_add_order);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void OnInitUiAndData() {
        iniNaviUserInterface();
        keyboardToolInit();
        vp_activity_note_edit_add_order_pager_income = (ViewPager) findViewById(R.id.vp_activity_note_edit_add_order_pager_income);
        vp_activity_note_edit_add_order_pager_outdone = (ViewPager) findViewById(R.id.vp_activity_note_edit_add_order_pager_outdone);

        ll_activity_note_edit_add_order_indicatorLayout = (LinearLayout) findViewById(R.id.ll_activity_note_edit_add_order_indicatorLayout);
        mBaseFragmentPagerAdapterForIncome = new BaseFragmentPagerAdapter(getSupportFragmentManager());
        mBaseFragmentPagerAdapterForOutdone = new BaseFragmentPagerAdapter(getSupportFragmentManager());
        vp_activity_note_edit_add_order_pager_income.setOnPageChangeListener(this);
        vp_activity_note_edit_add_order_pager_outdone.setOnPageChangeListener(this);


        noteTypePopupWindow = new NoteTypePopupWindow(mContext);
        noteTypePopupWindow.setNoteTypePopupWindowItemOnclickListener(this);
        resourceIncome = new NoteOrderIncomeSubTypeConst().getResource();
        resourceOutdone = new NoteOrderOutdoneSubTypeConst().getResource();

        noteTabelCellOrder = new NoteTabelCellOrder();
    }

    @Override
    public void OnBindDataWithUi() {
        vp_activity_note_edit_add_order_pager_income.setAdapter(mBaseFragmentPagerAdapterForIncome);
        vp_activity_note_edit_add_order_pager_outdone.setAdapter(mBaseFragmentPagerAdapterForOutdone);
        changeToOutdone();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==CHOICE_DATE_REQUESTCODE&&resultCode==RESULT_OK&&data!=null)
        {
            LogUtil.e(CHOICE_DATE_REQUESTCODE+"callback..");
        }

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.btn_top_left) {
            onBackPressed();
        } else if (v.getId() == R.id.ll_top_type_change) {
            noteTypePopupWindow.showAsDropDown(v);
        } else if (v.getId() == R.id.btn_date_choice) {
            NoteChoiceDateActivity.lunch(this,CHOICE_DATE_REQUESTCODE);
        } else if (v.getId() == R.id.btn_order_description) {
            NoteSetOrderDescActivity.lunch(this);
        }
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

    }

    /**
     * @param activity
     */
    public static void lunch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, NoteEditAddOrderActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void changeToIncome() {

        tv_top_type_change_textshow.setText(getString(R.string.textview_hint_of_shouru));
        flagBetwoonIncomeAndOutdone = false;
        if (!flagIncomeInitFirst) {
            flagIncomeInitFirst = true;
            mBaseFragmentPagerAdapterForIncome.clear();
            int geDuanCache = ERERYHORINTANUMS * ERERYVERTIALNUMS;
            NoteEditAddOrderTempleFragment mNoteEditAddOrderTempleFragment = null;
            for (int i = 0; i < resourceIncome.size(); i++) {
                //满一页了新建一个Fragment
                if (i % geDuanCache == 0) {
                    mNoteEditAddOrderTempleFragment = new NoteEditAddOrderTempleFragment(NoteEditTempleFragmentGridAdapter.TYPE_OF_INCOMEER);
                    mNoteEditAddOrderTempleFragment.setNoteEditItemClickListener(this);
                    mBaseFragmentPagerAdapterForIncome.addItem(mNoteEditAddOrderTempleFragment);
                }
                if (mNoteEditAddOrderTempleFragment != null) {
                    mNoteEditAddOrderTempleFragment.addItem(resourceIncome.get(i));
                }
            }
            //防止Fragment在ViewPager滑动的时候被销毁
            vp_activity_note_edit_add_order_pager_income.setOffscreenPageLimit(mBaseFragmentPagerAdapterForIncome.getCount() - 1);
        }
        initIndicator();
        vp_activity_note_edit_add_order_pager_income.setVisibility(View.VISIBLE);
        vp_activity_note_edit_add_order_pager_outdone.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeToOutdone() {
        tv_top_type_change_textshow.setText(getString(R.string.textview_hint_of_zhichu));
        flagBetwoonIncomeAndOutdone = true;
        if (!flagOutdoneInitFirst) {
            flagOutdoneInitFirst = true;
            mBaseFragmentPagerAdapterForOutdone.clear();
            int geDuanCache = ERERYHORINTANUMS * ERERYVERTIALNUMS;
            NoteEditAddOrderTempleFragment mNoteEditAddOrderTempleFragment = null;
            for (int i = 0; i < resourceOutdone.size(); i++) {
                //满一页了新建一个Fragment
                if (i % geDuanCache == 0) {
                    mNoteEditAddOrderTempleFragment = new NoteEditAddOrderTempleFragment(NoteEditTempleFragmentGridAdapter.TYPE_OF_OUTEDONE);
                    mNoteEditAddOrderTempleFragment.setNoteEditItemClickListener(this);
                    mBaseFragmentPagerAdapterForOutdone.addItem(mNoteEditAddOrderTempleFragment);
                }
                if (mNoteEditAddOrderTempleFragment != null) {
                    mNoteEditAddOrderTempleFragment.addItem(resourceOutdone.get(i));
                }
            }
            //防止Fragment在ViewPager滑动的时候被销毁
            vp_activity_note_edit_add_order_pager_outdone.setOffscreenPageLimit(mBaseFragmentPagerAdapterForOutdone.getCount() - 1);

        }
        initIndicator();
        vp_activity_note_edit_add_order_pager_outdone.setVisibility(View.VISIBLE);
        vp_activity_note_edit_add_order_pager_income.setVisibility(View.INVISIBLE);
    }

    @SuppressLint("InflateParams")
    @Override
    public void initIndicator() {
        //outdone
        if (flagBetwoonIncomeAndOutdone) {
            int ivSize = mBaseFragmentPagerAdapterForOutdone.getCount();
            // 设置指示器
            indicators = new ImageView[ivSize];
            ll_activity_note_edit_add_order_indicatorLayout.removeAllViews();
            for (int i = 0; i < indicators.length; i++) {
                View view = LayoutInflater.from(this).inflate(
                        com.wxl.export.lifter.common.R.layout.view_cycle_viewpager_indicator, null);
                indicators[i] = (ImageView) view.findViewById(com.wxl.export.lifter.common.R.id.image_indicator);
                ll_activity_note_edit_add_order_indicatorLayout.addView(view);
            }
        } else {
            int ivSize = mBaseFragmentPagerAdapterForIncome.getCount();
            // 设置指示器
            indicators = new ImageView[ivSize];
            ll_activity_note_edit_add_order_indicatorLayout.removeAllViews();
            for (int i = 0; i < indicators.length; i++) {
                View view = LayoutInflater.from(this).inflate(
                        com.wxl.export.lifter.common.R.layout.view_cycle_viewpager_indicator, null);
                indicators[i] = (ImageView) view.findViewById(com.wxl.export.lifter.common.R.id.image_indicator);
                ll_activity_note_edit_add_order_indicatorLayout.addView(view);
            }
        }
        setIndicatorPosition(0);
    }

    @Override
    public void setIndicatorPosition(int position) {
        for (ImageView indicator : indicators) {
            indicator
                    .setBackgroundResource(R.drawable.icon_indactor_unchecked);
        }
        if (indicators.length > position)
            indicators[position]
                    .setBackgroundResource(R.drawable.icon_indactor_inchecked);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setIndicatorPosition(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void OnTypeIncomeClick() {
        changeToIncome();
    }

    @Override
    public void OnTypeOutdneClick() {
        changeToOutdone();
    }

    @Override
    public void onItemClickCallBack(NoteOrderSubTypeGridItemShow noteOrderSubTypeGridItemShow) {
        noteTabelCellOrder.setSubType(noteOrderSubTypeGridItemShow);
        //outdone
        if (flagBetwoonIncomeAndOutdone) {
            for (Fragment a : mBaseFragmentPagerAdapterForOutdone.getFragments()) {
                ((NoteEditAddOrderTempleFragment) a).notifyDataSetChanged(noteOrderSubTypeGridItemShow);
            }
        } else {
            for (Fragment a : mBaseFragmentPagerAdapterForIncome.getFragments()) {
                ((NoteEditAddOrderTempleFragment) a).notifyDataSetChanged(noteOrderSubTypeGridItemShow);
            }
        }

    }

    @Override
    public void onCamerakeyCkicked() {

    }

    @Override
    public void onSurekeyCkicked() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
