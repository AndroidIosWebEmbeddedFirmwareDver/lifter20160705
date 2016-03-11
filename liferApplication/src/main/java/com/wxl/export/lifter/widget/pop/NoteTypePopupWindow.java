package com.wxl.export.lifter.widget.pop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

import com.wxl.export.lifter.common.utils.common.DensityManagerUtils;
import com.wxl.export.lifter.interfaces.PopupWindowInitInterface;
import com.wxl.export.lifter.lifter.R;

/**
 * @com.sintn.hera.shop.widget.popupwindow
 * @HuiyuantongVenusShopCash-V3.x
 * @PopupWindowEditCustomerInOrderWithCallback.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: TODO
 * @2015-3-7下午5:36:10
 */
@SuppressLint(
        {"InflateParams", "ClickableViewAccessibility"})
public class NoteTypePopupWindow extends PopupWindow implements OnClickListener, PopupWindowInitInterface {
    private View vPopWindow;
    private NoteTypePopupWindowItemOnclickListener noteTypePopupWindowItemOnclickListener;

    public NoteTypePopupWindowItemOnclickListener getNoteTypePopupWindowItemOnclickListener() {
        return noteTypePopupWindowItemOnclickListener;
    }

    public void setNoteTypePopupWindowItemOnclickListener(NoteTypePopupWindowItemOnclickListener noteTypePopupWindowItemOnclickListener) {
        this.noteTypePopupWindowItemOnclickListener = noteTypePopupWindowItemOnclickListener;
    }

    public NoteTypePopupWindow(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        vPopWindow = inflater.inflate(R.layout.activity_note_edit_add_popup_order_type, null, false);
        setContentView(vPopWindow);
        // 设置宽度
        setWidth(LayoutParams.WRAP_CONTENT);
        // 设置高度
        setHeight(LayoutParams.WRAP_CONTENT);

        setBackgroundDrawable(context.getResources().getDrawable(R.color.transparent));
        // 设置window外面的其他控件是否有效，是的话就有效
        setOutsideTouchable(true);
        //
        setAnimationStyle(R.style.mystyle_scale);
        update();
        // 设置PopupWindow可获得焦点
        setFocusable(true);
        // 设置PopupWindow外部区域是否可触摸
        setTouchable(true);
        OnInitUiAndData();
        OnBindDataWithUi();
    }

    @Override
    public void OnInitUiAndData() {

    }

    @Override
    public void OnBindDataWithUi() {
        vPopWindow.findViewById(R.id.btn_activity_note_edit_add_popup_order_type_outdone).setOnClickListener(this);
        vPopWindow.findViewById(R.id.btn_activity_note_edit_add_popup_order_type_income).setOnClickListener(this);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        // TODO Auto-generated method stub
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override
    public void dismiss() {
        // TODO Auto-generated method stub
        vPopWindow = null;
        super.dismiss();
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.btn_activity_note_edit_add_popup_order_type_outdone) {
            if (this.noteTypePopupWindowItemOnclickListener != null) {
                this.noteTypePopupWindowItemOnclickListener.OnTypeOutdneClick();
            }
            dismiss();
        } else if (v.getId() == R.id.btn_activity_note_edit_add_popup_order_type_income) {
            if (this.noteTypePopupWindowItemOnclickListener != null) {
                this.noteTypePopupWindowItemOnclickListener.OnTypeIncomeClick();
            }
            dismiss();
        }
    }

    @Override
    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
    }

    public interface NoteTypePopupWindowItemOnclickListener {
        public void OnTypeIncomeClick();

        public void OnTypeOutdneClick();
    }

}
