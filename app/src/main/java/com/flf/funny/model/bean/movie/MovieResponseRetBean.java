package com.flf.funny.model.bean.movie;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2017/4/22:22:33
 * 说明：电影首页Json 所有数据
 */

public class MovieResponseRetBean implements Serializable {

    @SerializedName("list")
    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }


}
