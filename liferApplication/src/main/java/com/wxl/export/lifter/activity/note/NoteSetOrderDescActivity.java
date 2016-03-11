package com.wxl.export.lifter.activity.note;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.lifter.R;

public class NoteSetOrderDescActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_set_order_desc);
    }

    @Override
    public void OnInitUiAndData() {

    }

    @Override
    public void OnBindDataWithUi() {

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

    /**
     * @param activity
     */
    public static void lunch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, NoteSetOrderDescActivity.class);
        activity.startActivity(intent);
    }
}
