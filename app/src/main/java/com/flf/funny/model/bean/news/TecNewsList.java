package com.flf.funny.model.bean.news;

import com.flf.funny.service.config.Constants;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PandaQ on 2016/9/20.
 * Description : 新闻科技
 */

public class TecNewsList {

    @SerializedName(Constants.NETEASY_NEWS_TEC)

    private ArrayList<NewsBean> mTecNewsArrayList;

    public ArrayList<NewsBean> getTecNewsArrayList() {
        return mTecNewsArrayList;
    }
}
