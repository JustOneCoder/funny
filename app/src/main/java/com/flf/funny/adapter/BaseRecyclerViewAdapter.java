package com.flf.funny.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.flf.funny.holder.BaseViewHolder;
import com.flf.funny.model.bean.BaseItem;
import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2017/4/12:17:45
 * 说明：条目显示适配器基类
 */

public abstract class BaseRecyclerViewAdapter<VH extends BaseViewHolder> extends UltimateViewAdapter {

    public Context mContext;
    public static final String TAG = "BaseRecyclerViewAdapter";
    public ArrayList<BaseItem> oldDatas;

    public BaseRecyclerViewAdapter(Context context) {
        oldDatas = new ArrayList<>();
        this.mContext = context;
    }


    //获取条目条数
    @Override
    public int getAdapterItemCount() {
        Log.e(TAG, "getAdapterItemCount: " + oldDatas.size());
        return oldDatas == null || oldDatas.isEmpty() ? 0 : oldDatas.size();
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent);


    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder newFooterHolder(View view) {
        return new UltimateRecyclerviewViewHolder<>(view);
    }

    @Override
    public RecyclerView.ViewHolder newHeaderHolder(View view) {
        return new UltimateRecyclerviewViewHolder<>(view);
    }


    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    //绑定item头部view的数据
    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    //添加数据
    public void appendToList(ArrayList<BaseItem> data) {
        if (data == null) {
            return;
        }
        oldDatas.addAll(data);
        notifyDataSetChanged();
    }

    public void append(BaseItem data) {
        if (data == null) {
            return;
        }
        oldDatas.add(data);
        notifyDataSetChanged();
    }

    public void appendToTop(BaseItem item) {
        if (item == null) {
            return;
        }
        oldDatas.add(0, item);
        notifyDataSetChanged();
    }

    public void appendToTopList(ArrayList<BaseItem> data) {
        oldDatas.clear();
        if (data == null) {
            return;
        }
        oldDatas.addAll(0, data);
        notifyDataSetChanged();
    }


    public void remove(int position) {
        if (position < oldDatas.size() - 1 && position >= 0) {
            oldDatas.remove(position);
        }
        notifyDataSetChanged();
    }

    //添加数据


}

