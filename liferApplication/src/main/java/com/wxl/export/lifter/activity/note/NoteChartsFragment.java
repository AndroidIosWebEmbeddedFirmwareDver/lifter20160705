package com.wxl.export.lifter.activity.note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.fragment.BaseFragment;
import com.wxl.export.lifter.lifter.R;

/**
 * com.wxl.export.lifter.activity.notebook
 * Sintn
 * Created by Sintn on 16/3/8 下午2:52.
 */
public class NoteChartsFragment  extends BaseFragment {

    @Override
    protected View onRealCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.activity_note_book_fragment_of_charts,container,false);
        return rootView;
    }

    @Override
    protected void OnInitUiAndData() {

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

    }
}