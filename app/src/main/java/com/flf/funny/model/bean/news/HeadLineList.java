package com.flf.funny.model.bean.news;

import com.flf.funny.service.config.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * 作者：Administrator
 * 时间：2017/5/10:17:25
 * 说明：要闻
 */

public class HeadLineList {
    @SerializedName(Constants.NETEASY_NEWS_HEADLINE)

    private ArrayList<NewsBean> mTopNewsArrayList;

    public ArrayList<NewsBean> getTopNewsArrayList() {
        return mTopNewsArrayList;
    }
}
