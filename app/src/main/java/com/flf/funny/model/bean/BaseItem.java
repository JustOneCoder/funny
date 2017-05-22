package com.flf.funny.model.bean;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;

import java.io.Serializable;



/**
 * Created by flf.
 * 说明:新闻条目的基类
 */

public class BaseItem<T> implements Serializable {
    private T data;

  /*  //数据类型
    private BaseRecyclerViewAdapter.RecyclerItemType mItemType;
    //实际使用的数据


    public BaseRecyclerAdapter.RecyclerItemType getItemType() {
        return mItemType == null ? TYPE_NORMAL : mItemType;
    }

    public void setItemType(BaseRecyclerAdapter.RecyclerItemType itemType) {
        mItemType = itemType;
    }
*/
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
