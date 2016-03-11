package com.wxl.export.lifter.activity.mainacti;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.lifter.R;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void OnInitUiAndData() {

    }

    @Override
    public void OnBindDataWithUi() {

    }

    /**
     *
     * @param activity
     */
    public static void lunch(Activity activity)
    {
        Intent intent=new Intent();
        intent.setClass(activity,LoginActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event) {

    }
}
