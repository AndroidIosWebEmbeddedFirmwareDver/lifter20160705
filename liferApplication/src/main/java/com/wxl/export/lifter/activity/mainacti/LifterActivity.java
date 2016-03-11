package com.wxl.export.lifter.activity.mainacti;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wxl.export.lifter.activity.note.NoteBookActivity;
import com.wxl.export.lifter.activity.todaything.ToDayThingActivity;
import com.wxl.export.lifter.adapter.BaseFragmentPagerAdapter;
import com.wxl.export.lifter.adapter.MainActivityGridAdapter;
import com.wxl.export.lifter.common.widget.view.GridViewForScrollView;
import com.wxl.export.lifter.enty.db.note.NoteTabelCellOrder;
import com.wxl.export.lifter.enty.show.DefaultGridItemShow;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.widget.cycleviewpager.ADInfo;
import com.wxl.export.lifter.common.widget.cycleviewpager.CycleViewPager;
import com.wxl.export.lifter.lifter.R;
import com.wxl.export.lifter.util.ViewFactory;
import com.wxl.export.lifter.util.sqlite.LiferDatabaseUtils;

import java.util.ArrayList;
import java.util.List;

public class LifterActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    //navi
    private ImageButton btn_top_shape, btn_top_wode, btn_top_search, btn_top_add;
    private TextView text_top_text;

    private GridViewForScrollView gv_maincontent_lists;
    private MainActivityGridAdapter<DefaultGridItemShow> mainActivityGridAdapter;

    private GridViewForScrollView gv_maincontent_other_lists;
    private MainActivityGridAdapter<DefaultGridItemShow> mainOthersActivityGridAdapter;


    private List<ImageView> views = new ArrayList<ImageView>();
    private List<ADInfo> infos = new ArrayList<ADInfo>();
    private CycleViewPager cycleViewPager;
    private ViewPager viewPager;
    private BaseFragmentPagerAdapter baseFragmentPagerAdapter;

    private String[] imageUrls = {"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void iniNaviUserInterface() {
        btn_top_shape = (ImageButton) findViewById(R.id.btn_top_shape);
        btn_top_wode = (ImageButton) findViewById(R.id.btn_top_wode);
        btn_top_search = (ImageButton) findViewById(R.id.btn_top_search);
        btn_top_add = (ImageButton) findViewById(R.id.btn_top_add);
        text_top_text = (TextView) findViewById(R.id.text_top_text);
    }

    @Override
    public void OnInitUiAndData() {
        //TODO 2016年03月09日14:44:53
        NoteTabelCellOrder noteTabelCellOrder = new NoteTabelCellOrder();
        noteTabelCellOrder.defaultInit();
        LiferDatabaseUtils.writeNoteTabelCellOrderToDataBase(noteTabelCellOrder, mContext);
        LiferDatabaseUtils.writeNoteTabelCellOrderToDataBase(noteTabelCellOrder, mContext);
        LiferDatabaseUtils.writeNoteTabelCellOrderToDataBase(noteTabelCellOrder, mContext);

        iniNaviUserInterface();
        mainActivityGridAdapter = new MainActivityGridAdapter<>(mContext);
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_jizhang), R.drawable.icon_jizhang));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_zhuanzhuang), R.drawable.icon_zhuanzhuang));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_xinyongkahuankuan), R.drawable.icon_xinyongkahuankuan));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_caipiao), R.drawable.icon_caipiao));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_dache), R.drawable.icon_dache));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_gupiao), R.drawable.icon_gupiao));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_huilvhuansuan), R.drawable.icon_huilvhuansuan));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_kuaiqiang), R.drawable.icon_kuaiqiang));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_qinmifu), R.drawable.icon_qinmifu));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_shoujichongzhi), R.drawable.icon_shoujichongzhi));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_lishi), R.drawable.icon_lishi));
        mainActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_aixinjuanzeng), R.drawable.icon_aixinjuanzeng));
        gv_maincontent_lists = (GridViewForScrollView) findViewById(R.id.gv_maincontent_lists);
        gv_maincontent_lists.setOnItemClickListener(this);


        mainOthersActivityGridAdapter = new MainActivityGridAdapter<>(mContext);
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_aliyouxi), R.drawable.icon_aliyouxi));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_taodiandian), R.drawable.icon_taodiandian));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_jipiao), R.drawable.icon_jipiao));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_kuaidi), R.drawable.icon_kuaidi));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_lvyoutehui), R.drawable.icon_lvyoutehui));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_taobao), R.drawable.icon_taobao));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_wodebaozhang), R.drawable.icon_wodebaozhang));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_youxichongzhi), R.drawable.icon_youxichongzhi));
        mainOthersActivityGridAdapter.addItem(new DefaultGridItemShow(getString(R.string.hint_of_text_gengduo), R.drawable.icon_gengduo));

        gv_maincontent_other_lists = (GridViewForScrollView) findViewById(R.id.gv_maincontent_other_lists);
        gv_maincontent_other_lists.setOnItemClickListener(this);
    }

    @Override
    public void OnBindDataWithUi() {
        gv_maincontent_lists.setAdapter(mainActivityGridAdapter);
        gv_maincontent_other_lists.setAdapter(mainOthersActivityGridAdapter);
        initialize();
    }


    @SuppressLint("NewApi")
    private void initialize() {
        viewPager = (ViewPager) findViewById(R.id.fragment_cycle_viewpager_content);
        cycleViewPager = new CycleViewPager(this);
        for (int i = 0; i < imageUrls.length; i++) {
            ADInfo info = new ADInfo();
            info.setUrl(imageUrls[i]);
            info.setContent("图片-->" + i);
            infos.add(info);
        }

        // 将最后一个ImageView添加进来
        views.add(ViewFactory.getImageView(mContext, infos.get(infos.size() - 1).getUrl()));
        for (int i = 0; i < infos.size(); i++) {
            views.add(ViewFactory.getImageView(mContext, infos.get(i).getUrl()));
        }
        // 将第一个ImageView添加进来
        views.add(ViewFactory.getImageView(mContext, infos.get(0).getUrl()));

        // 设置循环，在调用setData方法前调用
        cycleViewPager.setCycle(true);

        // 在加载数据前设置是否循环
        cycleViewPager.setData(views, infos, mAdCycleViewListener);
        //设置轮播
        cycleViewPager.setWheel(true);

        // 设置轮播时间，默认5000ms
        cycleViewPager.setTime(2000);
        //设置圆点指示图标组居中显示，默认靠右
        cycleViewPager.setIndicatorCenter();


        baseFragmentPagerAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());
        baseFragmentPagerAdapter.addItem(cycleViewPager);
        viewPager.setAdapter(baseFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {
            if (cycleViewPager.isCycle()) {
                position = position - 1;
//                Toast.makeText(LifterActivity.this,
//                        "position-->" + info.getContent(), Toast.LENGTH_SHORT)
//                        .show();
            }

        }

    };

    /**
     * @param activity
     */
    public static void lunch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, LifterActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == gv_maincontent_lists) {
            if (position == 0) {
                NoteBookActivity.lunch(this);
            } else if (position == 10) {
                ToDayThingActivity.lunch(this);
            }
        }

    }
}
