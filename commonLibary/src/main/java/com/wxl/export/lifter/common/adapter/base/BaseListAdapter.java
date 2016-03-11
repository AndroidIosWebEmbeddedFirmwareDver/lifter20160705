package com.wxl.export.lifter.common.adapter.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @com.sintn.hera.shop.adapter
 * @HuiyuantongVenusShopCash-V3.x
 * @SetBaseAdapter.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 基本适配设置器类
 * @2015-2-10上午11:57:28
 */

public abstract class BaseListAdapter<E extends Object> extends BaseAdapter {

    protected List<E> objects;

    public List<E> getlistObject() {
        return objects;
    }

    public BaseListAdapter() {
        objects = new ArrayList<E>();
    }

    public int getCount() {
        return objects.size();
    }

    public E getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    public abstract View getView(int position, View convertView, ViewGroup parent);

    public void replaceAll(Collection<E> collection) {
        objects.clear();
        if (collection != null) {
            objects.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public void addItem(E e) {
        objects.add(e);
        notifyDataSetChanged();
    }

    public void addItem(E e, int position) {
        objects.add(position, e);
        notifyDataSetChanged();
    }

    public void addAllItem(List<E> list) {
        if (list != null) {
            objects.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void removeItem(E e) {
        objects.remove(e);
        notifyDataSetChanged();
    }

    public void removeItem(int i) {
        objects.remove(i);
        notifyDataSetChanged();
    }

    public void removeAllItem(List<E> list) {
        objects.removeAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        objects.clear();
        notifyDataSetChanged();
    }

}
