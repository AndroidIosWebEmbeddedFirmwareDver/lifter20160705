package com.wxl.export.lifter.common.activity.base;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.wxl.export.lifter.common.app.BaseApplication;
import com.wxl.export.lifter.common.manager.AndroidEventManager;
import com.wxl.export.lifter.common.utils.core.EventManager;
import com.wxl.export.lifter.common.R;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



/**
 * @Desc: Activity基类
 * @com.sintn.hera.mobile.cash.activity.base
 * @HuiyuantongVenusShopCash-V3.x
 * @BaseActivity.java
 * @Author:Wxl@Sintn.Inc
 * @2015-2-6下午3:21:33
 */
@SuppressLint(
        {"InflateParams", "SdCardPath", "InlinedApi"})
public abstract class BaseActivity extends AppCompatActivity implements EventManager.OnEventListener {
    //每个界面上所有事件编码集合
    private SparseArray<EventManager.OnEventListener> codeToListenerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * >4.4沉浸式 顶层布局 android:background="@color/red"
         * android:clipToPadding="true" android:fitsSystemWindows="true"
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        BaseApplication.addActivity(this);
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
    }
    // 异步加载UI元素和数据
    public  abstract void onInitBaseActivity();

    /**
     * 加载UI元素和数据
     */
    public abstract void OnInitUiAndData();

    /**
     * 绑定数据到UI元素上
     */
    public abstract void OnBindDataWithUi();
    /**
     * 添加回调事件
     *
     * @param nEventCode
     */
    protected void addCallbackEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            codeToListenerMap = new SparseArray<EventManager.OnEventListener>();
        }
        codeToListenerMap.put(nEventCode, this);
        AndroidEventManager.getInstance().addEventListener(nEventCode, this, false);
    }

    /**
     * 添加一次性事件
     *
     * @param nEventCode
     */
    protected void addOncesEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            codeToListenerMap = new SparseArray<EventManager.OnEventListener>();
        }
        codeToListenerMap.put(nEventCode, this);
        AndroidEventManager.getInstance().addEventListener(nEventCode, this, true);
    }

    /**
     * 移除事件
     *
     * @param nEventCode
     */
    protected void removeCallbackEventListener(int nEventCode) {
        if (codeToListenerMap == null) {
            return;
        }
        codeToListenerMap.remove(nEventCode);
        AndroidEventManager.getInstance().removeEventListener(nEventCode, this);
    }



    /**
     * 检测某ActivityUpdate是否在当前Task的栈顶
     */
    public boolean isTopActivy(){
        ActivityManager manager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        String cmpNameTemp = null;

        if(null != runningTaskInfos){
            cmpNameTemp= (runningTaskInfos.get(0).topActivity.getClassName());
            Log.e("cmpname","cmpname:"+cmpNameTemp);
            Log.e("cmpname","this:"+this.getPackageName()+this.getLocalClassName());
            Log.e("cmpname","this:=="+cmpNameTemp.equals(this.getPackageName()+"." + this.getLocalClassName()));
        }

        if(null == cmpNameTemp)return false;
        return cmpNameTemp.equals(this.getPackageName() + "." + this.getLocalClassName());
    }


    /**
     * @param mEtInput
     */
    protected void hiddleSoftInputForEdittext(EditText mEtInput) {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            mEtInput.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(mEtInput, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop =
                    {0, 0};
            // 获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    @Override
    public void onBackPressed()
    {
        // TODO Auto-generated method stub
//        super.onBackPressed();
        this.finish();
    }

    //获取当前日期
    @SuppressLint("SimpleDateFormat")
    public String getNowTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTimeInMillis(System.currentTimeMillis());
        return sdf.format(calendar.getTime());
    }


    /**
     * 界面销毁回调函数
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApplication.removeActivity(this);
        if (codeToListenerMap != null) {
            final int nCount = codeToListenerMap.size();
            for (int nIndex = 0; nIndex < nCount; ++nIndex) {
                removeCallbackEventListener(codeToListenerMap.keyAt(nIndex));
            }
            codeToListenerMap.clear();
        }
        // 设置空的布局快速释放内存
        setContentView(R.layout.a_a_null_view);
        // 强制清理此Activity对象资源
        System.gc();
    }

}
