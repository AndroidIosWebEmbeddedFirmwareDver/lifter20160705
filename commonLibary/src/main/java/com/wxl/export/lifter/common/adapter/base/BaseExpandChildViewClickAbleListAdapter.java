package com.wxl.export.lifter.common.adapter.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.BaseExpandableListAdapter;

import com.wxl.export.lifter.common.listener.OnListViewChildViewClickListener;


/**
 * 
 * @Desc: 基本适配设置器类
 * @com.wxl.export.easyproject.adapter
 * @HuiyuantongVenus-V3.x
 * @SetBaseExpandableListAdapter.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午3:19:19
 */

public abstract class BaseExpandChildViewClickAbleListAdapter<E extends Object> extends BaseExpandableListAdapter implements OnClickListener, OnLongClickListener
{

	protected List<E> objects;
	private OnListViewChildViewClickListener onListViewChildViewClickListener;
	private OnExpandableListViewItemLongClickListener OnExpandableListViewItemLongClickListener;

	public void setOnExpandableListViewItemLongClick(OnExpandableListViewItemLongClickListener OnExpandableListViewItemLongClickListener)
	{
		this.OnExpandableListViewItemLongClickListener = OnExpandableListViewItemLongClickListener;
	}

	public void setOnListViewChildViewClickListener(OnListViewChildViewClickListener onListViewChildViewClickListener)
	{
		this.onListViewChildViewClickListener = onListViewChildViewClickListener;
	}

	public interface OnExpandableListViewItemLongClickListener
	{
		public void onExpandableListViewItemLongClick(int viewId, Object object);
	}

	@Override
	public void onClick(View v)
	{
		onListViewChildViewClickListener.onListChildViewClicked(v, v.getTag());
	}

	@Override
	public boolean onLongClick(View v)
	{
		OnExpandableListViewItemLongClickListener.onExpandableListViewItemLongClick(v.getId(), v.getTag());
		return true;
	}

	public List<E> getlistObject()
	{
		return objects;
	}

	public BaseExpandChildViewClickAbleListAdapter()
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

	public void replaceAll(Collection<E> collection)
	{
		objects.clear();
		if (collection != null)
		{
			objects.addAll(collection);
		}
		notifyDataSetChanged();
	}

	public void addItem(E e)
	{
		objects.add(e);
		notifyDataSetChanged();
	}

	public void addItem(E e, int position)
	{
		objects.add(position, e);
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

	public void removeItem(E e)
	{
		objects.remove(e);
		notifyDataSetChanged();
	}

	public void removeItem(int i)
	{
		objects.remove(i);
		notifyDataSetChanged();
	}

	public void removeAllItem(List<E> list)
	{
		objects.removeAll(list);
		notifyDataSetChanged();
	}

	public void clear()
	{
		objects.clear();
		notifyDataSetChanged();
	}

}
