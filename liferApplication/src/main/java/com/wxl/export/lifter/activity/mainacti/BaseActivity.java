package com.wxl.export.lifter.activity.mainacti;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wxl.export.lifter.event.LiftEventCode;
import com.wxl.export.lifter.common.event.MobileCashBaseCallbackEvent;
import com.wxl.export.lifter.common.manager.AndroidEventManager;
import com.wxl.export.lifter.lifter.R;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.ContactsPage;
import cn.smssdk.gui.RegisterPage;

/**
 * com.wxl.export.lifter.lifter
 * Sintn
 * Created by Sintn on 16/3/4 下午4:53.
 */
public abstract class BaseActivity extends com.wxl.export.lifter.common.activity.base.BaseActivity implements View.OnClickListener {

    public Context mContext;
    //导航视图
    protected ImageButton btn_top_left;
    protected TextView text_top_middle;
    protected ImageButton btn_top_right;

    protected  void iniNaviUserInterface()
    {
        btn_top_left= (ImageButton) findViewById(R.id.btn_top_left);
        text_top_middle= (TextView) findViewById(R.id.text_top_middle);
        btn_top_right= (ImageButton) findViewById(R.id.btn_top_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onInitBaseActivity();
        mContext = this;

    }

    @Override
    public void onInitBaseActivity() {
        new AsyncTask<Void, Integer, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                // TODO Auto-generated method stub
                OnInitUiAndData();
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                // TODO Auto-generated method stub
                super.onPostExecute(result);
                OnBindDataWithUi();
            }
        }.execute();
    }


    public void JumpToMobRegistActivity(Context context) {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    // 提交用户信息
                    //          registerUser(country, phone);
                    AndroidEventManager.getInstance().postEvent(new MobileCashBaseCallbackEvent(LiftEventCode.HTTP_REGIST_SUCESS_CALLBACK), 0, mContext, phoneMap);
                }
            }
        });
        registerPage.show(context);
    }

    public void JumpToMobContactsActivity(Context context) {
        //打开通信录好友列表页面
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.show(context);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
