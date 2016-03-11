package com.wxl.export.lifter.activity.note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.fragment.BaseFragment;
import com.wxl.export.lifter.lifter.R;

/**
 * com.wxl.export.lifter.activity.notebook
 * Sintn
 * Created by Sintn on 16/3/8 下午2:51.
 */
public class NoteDetialsFragment extends BaseFragment {
    private ViewGroup vg_root_of_notedetialfragment;
    private LinearLayout ll_fragment_for_add_note_order;

    @Override
    protected View onRealCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_note_book_fragment_of_detials, container, false);
        return rootView;
    }

    @Override
    protected void OnInitUiAndData() {
        if (rootView != null) {
            vg_root_of_notedetialfragment = (ViewGroup) rootView.findViewById(R.id.vg_root_of_notedetialfragment);
            ll_fragment_for_add_note_order = (LinearLayout) vg_root_of_notedetialfragment.findViewById(R.id.ll_fragment_for_add_note_order);
            ll_fragment_for_add_note_order.setOnClickListener(this);
        }
    }

    @Override
    protected void OnBindDataWithUi() {

    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event, int eventCode) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View view, int clickedViewId) {
        if (clickedViewId == R.id.ll_fragment_for_add_note_order) {
            NoteEditAddOrderActivity.lunch(activity);
        }
    }
}