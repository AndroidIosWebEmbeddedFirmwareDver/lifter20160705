package com.wxl.export.lifter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wxl.export.lifter.activity.note.NoteEditAddOrderTempleFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * com.wxl.export.lifter.adapter
 * Sintn
 * Created by Sintn on 16/3/8 下午12:55.
 */
public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public List<Fragment> getFragments() {
        return fragments;
    }

    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<>();
    }

    public void replaceAll(Collection<Fragment> collection) {
        fragments.clear();
        if (collection != null) {
            fragments.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public void addItem(Fragment e) {
        fragments.add(e);
        notifyDataSetChanged();
    }

    public void addItem(Fragment e, int position) {
        fragments.add(position, e);
        notifyDataSetChanged();
    }

    public void addAllItem(List<NoteEditAddOrderTempleFragment> list) {
        if (list != null) {
            fragments.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void removeItem(Fragment e) {
        fragments.remove(e);
        notifyDataSetChanged();
    }

    public void removeItem(int i) {
        fragments.remove(i);
        notifyDataSetChanged();
    }

    public void removeAllItem(List<Fragment> list) {
        fragments.removeAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        fragments.clear();
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments != null)
            return fragments.get(position);
        return null;
    }

    @Override
    public int getCount() {
        if (fragments != null)
            return fragments.size();
        return 0;
    }
}
