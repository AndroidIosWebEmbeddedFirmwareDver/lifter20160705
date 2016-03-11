package com.wxl.export.lifter.activity.note;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.wxl.export.lifter.adapter.NoteEditTempleFragmentGridAdapter;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;
import com.wxl.export.lifter.common.fragment.BaseFragment;
import com.wxl.export.lifter.common.utils.common.LogUtil;
import com.wxl.export.lifter.enty.show.NoteOrderSubTypeGridItemShow;
import com.wxl.export.lifter.lifter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wxl.export.lifter.activity.notebook
 * Sintn
 * Created by Sintn on 16/3/8 下午2:51.
 */
public class NoteEditAddOrderTempleFragment extends BaseFragment {
    private List<NoteOrderSubTypeGridItemShow> lists;
    private int type;

    private ViewGroup vg_root_of_fragment_note_edit_add_order_temple;
    private GridView gv_fragment_note_edit_add_order_temple_lists;
    private NoteEditTempleFragmentGridAdapter mNoteEditTempleFragmentGridAdapter;

    private NoteEditItemClickListener noteEditItemClickListener;

    public NoteEditItemClickListener getNoteEditItemClickListener() {
        return noteEditItemClickListener;
    }

    public void setNoteEditItemClickListener(NoteEditItemClickListener noteEditItemClickListener) {
        this.noteEditItemClickListener = noteEditItemClickListener;
    }

    public void addItem(NoteOrderSubTypeGridItemShow e) {
        lists.add(e);
    }

    public NoteEditAddOrderTempleFragment() {
        lists = new ArrayList<NoteOrderSubTypeGridItemShow>();
    }

    @SuppressLint("ValidFragment")
    public NoteEditAddOrderTempleFragment(int type) {
        this.lists = new ArrayList<NoteOrderSubTypeGridItemShow>();
        this.type = type;
    }

    @Override
    protected View onRealCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_note_edit_add_order_temple, container, false);
        return rootView;
    }

    @Override
    protected void OnInitUiAndData() {
        if (rootView != null) {
            vg_root_of_fragment_note_edit_add_order_temple = (ViewGroup) rootView.findViewById(R.id.vg_root_of_fragment_note_edit_add_order_temple);
            gv_fragment_note_edit_add_order_temple_lists = (GridView) vg_root_of_fragment_note_edit_add_order_temple.findViewById(R.id.gv_fragment_note_edit_add_order_temple_lists);
            mNoteEditTempleFragmentGridAdapter = new NoteEditTempleFragmentGridAdapter(activity, 5, 5, true, true, this.type);
            if (lists != null && lists.size() > 0)
                mNoteEditTempleFragmentGridAdapter.addAllItem(lists);
            gv_fragment_note_edit_add_order_temple_lists.setOnItemClickListener(this);
        }
    }

    @Override
    protected void OnBindDataWithUi() {
        gv_fragment_note_edit_add_order_temple_lists.setAdapter(mNoteEditTempleFragmentGridAdapter);
    }

    @Override
    public void onEventRunEnd(MobileCashBaseEvent event, int eventCode) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        LogUtil.e("position->" + position);
        if (mNoteEditTempleFragmentGridAdapter != null && mNoteEditTempleFragmentGridAdapter.getlistObject() != null && mNoteEditTempleFragmentGridAdapter.getlistObject().size() > 0) {
            if (noteEditItemClickListener != null) {
                noteEditItemClickListener.onItemClickCallBack((NoteOrderSubTypeGridItemShow) mNoteEditTempleFragmentGridAdapter.getItem(position));
            }
        }
    }

    @Override
    public void onClick(View view, int clickedViewId) {

    }

    public interface NoteEditItemClickListener {
        public void onItemClickCallBack(NoteOrderSubTypeGridItemShow noteOrderSubTypeGridItemShow);
    }


    public void notifyDataSetChanged(NoteOrderSubTypeGridItemShow noteOrderSubTypeGridItemShow) {
        for (int i = 0; i < mNoteEditTempleFragmentGridAdapter.getlistObject().size(); i++) {
            if (((NoteOrderSubTypeGridItemShow) mNoteEditTempleFragmentGridAdapter.getItem(i)).getTypeId() == noteOrderSubTypeGridItemShow.getTypeId()) {
                ((NoteOrderSubTypeGridItemShow) mNoteEditTempleFragmentGridAdapter.getItem(i)).setSelected(true);
            } else {
                ((NoteOrderSubTypeGridItemShow) mNoteEditTempleFragmentGridAdapter.getItem(i)).setSelected(false);
            }
        }
        mNoteEditTempleFragmentGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lists.clear();
        lists = null;
        vg_root_of_fragment_note_edit_add_order_temple = null;
        gv_fragment_note_edit_add_order_temple_lists = null;
        mNoteEditTempleFragmentGridAdapter.getlistObject().clear();
        mNoteEditTempleFragmentGridAdapter = null;
    }
}