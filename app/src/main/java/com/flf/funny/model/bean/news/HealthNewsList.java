package com.flf.funny.model.bean.news;

import com.flf.funny.service.config.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PandaQ on 2016/9/20.
 * Description : 新闻要闻
 */

public class HealthNewsList{

    @SerializedName(Constants.NETEASY_NEWS_HEALTH)

    private ArrayList<NewsBean> mRecommNewsArrayList;

    public ArrayList<NewsBean> getRecNewsArrayList() {
        return mRecommNewsArrayList;
    }
}
