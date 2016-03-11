package com.wxl.export.lifter.activity.mainacti;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wxl.export.lifter.common.utils.common.LogUtil;
import com.wxl.export.lifter.enty.constenty.RedoamLuncherImageUrlConst;
import com.wxl.export.lifter.event.LiftEventCode;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.lifter.R;

public class StartActivity extends BaseActivity {

    private ImageView im_start_lunch_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_start);
        super.onCreate(savedInstanceState);
//        JumpToMobRegistActivity(this);
//        addCallbackEventListener(LiftEventCode.HTTP_REGIST_SUCESS_CALLBACK);
    }

    @Override
    public void OnInitUiAndData() {
        im_start_lunch_image = (ImageView) findViewById(R.id.im_start_lunch_image);
    }

    @SuppressLint("SetTextI18n")
    public void changBackUpShowStatus(int time) {
        ((Button) findViewById(R.id.btn_start_lunch_image)).setText("" + time + "s" + "后跳过");
    }

    @Override
    public void OnBindDataWithUi() {
        Glide.with(mContext)
                .load(RedoamLuncherImageUrlConst.redomeImageUrl())
                .into(im_start_lunch_image);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    LifterActivity.lunch(StartActivity.this);
                    finish();
                }
            }
        }).start();
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {
        if (event.getEventCode() == LiftEventCode.HTTP_REGIST_SUCESS_CALLBACK) {
            LifterActivity.lunch(this);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.btn_start_lunch_image) {
//            LifterActivity.lunch(this);
//            finish();
//        }
    }
}
