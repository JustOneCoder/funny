package com.flf.funny.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

/**
 * 作者：Administrator
 * 时间：2017/4/12:22:52
 * 说明：封装后的ViewHolder基类
 */

public abstract class BaseViewHolder<T> extends UltimateRecyclerviewViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public BaseViewHolder(ViewGroup parent, int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    }

    public abstract void setData(T data);

}
