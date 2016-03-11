package com.wxl.export.lifter.common.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.wxl.export.lifter.common.listener.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sintn on 15/11/10.
 */
public abstract  class BaseRecyclerAdapter<E extends Object> extends RecyclerView.Adapter{

    public OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    protected Context context;

    protected List<E> objects;

    public List<E> getlistObject()
    {
        return objects;
    }

    public BaseRecyclerAdapter(Context context) {
        this.context = context;
        objects = new ArrayList<E>();
    }

    public BaseRecyclerAdapter()
    {
        objects = new ArrayList<E>();
    }

    public int getCount()
    {
        return objects.size();
    }

    public Object getItem(int position)
    {
        return objects.get(position);
    }

    public void addItem(E e)
    {
        objects.add(e);
        notifyDataSetChanged();
    }


    public void addAllItem(List<E> list)
    {
        if (list != null)
        {
            objects.addAll(list);
            notifyDataSetChanged();
        }
    }

  
    public void replaceAll(Collection<E> collection) {
        objects.clear();
        if (collection != null) {
            objects.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public void addItem(E e, boolean notifyData) {
        objects.add(e);
        if (notifyData) {
            notifyDataSetChanged();
        }
    }

    public void addItem(E e, int position) {
        objects.add(position, e);
        notifyDataSetChanged();
    }

    public void addAllItem(List<E> list, boolean notifyData) {
        if (list != null) {
            objects.addAll(list);
            if (notifyData) {
                notifyDataSetChanged();
            }
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
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    @Override
    public int getItemCount() {
        return objects == null ? 0 : objects.size();
    }

    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener)
    {
        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }
}
