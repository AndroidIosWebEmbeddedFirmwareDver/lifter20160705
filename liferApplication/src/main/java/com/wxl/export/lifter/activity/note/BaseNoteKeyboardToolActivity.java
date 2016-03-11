package com.wxl.export.lifter.activity.note;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wxl.export.lifter.activity.mainacti.BaseActivity;
import com.wxl.export.lifter.interfaces.KeyboardToolInterface;
import com.wxl.export.lifter.lifter.R;

/**
 * Created by Sintn on 16/3/11.
 */
public abstract class BaseNoteKeyboardToolActivity extends BaseActivity implements KeyboardToolInterface {
    //调用相机按钮
    protected ImageButton ktool_ibt_cameara;
    //输入数字显示区域
    protected TextView ktool_tv_inputarea;
    //删除已经输入内容按钮
    protected ImageButton ktool_ibt_clearinput;
    //数字按钮1
    protected Button ktool_btn_keynumber1;
    //数字按钮2
    protected Button ktool_btn_keynumber2;
    //数字按钮3
    protected Button ktool_btn_keynumber3;
    //数字按钮4
    protected Button ktool_btn_keynumber4;
    //数字按钮5
    protected Button ktool_btn_keynumber5;
    //数字按钮6
    protected Button ktool_btn_keynumber6;
    //数字按钮7
    protected Button ktool_btn_keynumber7;
    //数字按钮8
    protected Button ktool_btn_keynumber8;
    //数字按钮9
    protected Button ktool_btn_keynumber9;
    //数字按钮0
    protected Button ktool_btn_keynumber0;
    //数字按钮0
    protected Button ktool_btn_keynumber00;
    //数字按钮.
    protected Button ktool_btn_keynumberpoint;
    //完成按钮
    protected Button ktool_btn_keysure;
    //删除一个输入内容按钮
    protected ImageButton ktool_ibt_keydelete;


    protected void keyboardToolInit() {
        //调用相机按钮
        ktool_ibt_cameara = (ImageButton) findViewById(R.id.ktool_ibt_cameara);
        //输入数字显示区域
        ktool_tv_inputarea = (TextView) findViewById(R.id.ktool_tv_inputarea);
        //删除已经输入内容按钮
        ktool_ibt_clearinput = (ImageButton) findViewById(R.id.ktool_ibt_clearinput);
        //数字按钮1
        ktool_btn_keynumber1 = (Button) findViewById(R.id.ktool_btn_keynumber1);
        //数字按钮2
        ktool_btn_keynumber2 = (Button) findViewById(R.id.ktool_btn_keynumber2);
        //数字按钮3
        ktool_btn_keynumber3 = (Button) findViewById(R.id.ktool_btn_keynumber3);
        //数字按钮4
        ktool_btn_keynumber4 = (Button) findViewById(R.id.ktool_btn_keynumber4);
        //数字按钮5
        ktool_btn_keynumber5 = (Button) findViewById(R.id.ktool_btn_keynumber5);
        //数字按钮6
        ktool_btn_keynumber6 = (Button) findViewById(R.id.ktool_btn_keynumber6);
        //数字按钮7
        ktool_btn_keynumber7 = (Button) findViewById(R.id.ktool_btn_keynumber7);
        //数字按钮8
        ktool_btn_keynumber8 = (Button) findViewById(R.id.ktool_btn_keynumber8);
        //数字按钮9
        ktool_btn_keynumber9 = (Button) findViewById(R.id.ktool_btn_keynumber9);
        //数字按钮0
        ktool_btn_keynumber0 = (Button) findViewById(R.id.ktool_btn_keynumber0);
        //数字按钮0
        ktool_btn_keynumber00 = (Button) findViewById(R.id.ktool_btn_keynumber00);
        //数字按钮.
        ktool_btn_keynumberpoint = (Button) findViewById(R.id.ktool_btn_keynumberpoint);
        //完成按钮
        ktool_btn_keysure = (Button) findViewById(R.id.ktool_btn_keysure);
        //删除一个输入内容按钮
        ktool_ibt_keydelete = (ImageButton) findViewById(R.id.ktool_ibt_keydelete);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.ktool_btn_keysure) {
            onSurekeyCkicked();
        } else if (viewId == R.id.ktool_btn_keynumber0) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_0));
        } else if (viewId == R.id.ktool_btn_keynumber1) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_1));
        } else if (viewId == R.id.ktool_btn_keynumber2) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_2));
        } else if (viewId == R.id.ktool_btn_keynumber3) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_3));
        } else if (viewId == R.id.ktool_btn_keynumber4) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_4));
        } else if (viewId == R.id.ktool_btn_keynumber5) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_5));
        } else if (viewId == R.id.ktool_btn_keynumber6) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_6));
        } else if (viewId == R.id.ktool_btn_keynumber7) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_7));
        } else if (viewId == R.id.ktool_btn_keynumber8) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_8));
        } else if (viewId == R.id.ktool_btn_keynumber9) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_9));
        } else if (viewId == R.id.ktool_btn_keynumber00) {
            onNumberkeyCkicked(getString(R.string.button_hint_of_key_00));
        } else if (viewId == R.id.ktool_btn_keynumberpoint) {
            onPointkeyCkicked();
        } else if (viewId == R.id.ktool_ibt_keydelete) {
            onDeletekeyCkicked();
        } else if (viewId == R.id.ktool_ibt_clearinput) {
            onClearkeyCkicked();
        } else if (viewId == R.id.ktool_ibt_cameara) {
            onCamerakeyCkicked();
        }
    }

    @Override
    public void onNumberkeyCkicked(String s) {
        ktool_tv_inputarea.append(s);
    }

    @Override
    public void onPointkeyCkicked() {
        if (ktool_tv_inputarea.getText().toString().length() > 1 && !ktool_tv_inputarea.getText().toString().contains(getString(R.string.button_hint_of_key_point)))
            ktool_tv_inputarea.append(getString(R.string.button_hint_of_key_point));
    }

    @Override
    public void onDeletekeyCkicked() {
        if (ktool_tv_inputarea.getText().toString().length() > 0)
            ktool_tv_inputarea.setText(ktool_tv_inputarea.getText().toString().substring(0, ktool_tv_inputarea.getText().length() - 1));
    }

    @Override
    public void onClearkeyCkicked() {
        ktool_tv_inputarea.setText(getString(R.string.empty));
    }

    @Override
    public String getInputContent() {
        return ktool_tv_inputarea.getText().toString().trim();
    }
}
