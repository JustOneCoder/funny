package com.flf.funny.presenter.news;

import android.content.Context;
import android.util.Log;

import com.flf.funny.model.model.news.NewsSportModel;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.presenter.base.NewsAndGameLivePagerPresenter;
import com.flf.funny.ui.fragment.news.SportPagerFragment;

import java.util.ArrayList;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 作者：Administrator
 * 时间：2017/4/12:20:18
 * 说明：新闻-->娱乐数据的加载
 */

public class SportPagerPresenter extends NewsAndGameLivePagerPresenter {

    public static final String TAG = "SportPagerPresenter";
    Context context;
    private NewsSportModel model;
    private SportPagerFragment view;
    public int currentIndex;

    public SportPagerPresenter(SportPagerFragment fragment) {
        this.view = fragment;
        model = new NewsSportModel();
    }

    @Override
    public void setRefresh() {
        currentIndex = 0;
        model.refresh(0, new SingleObserver<ArrayList<BaseItem>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(ArrayList<BaseItem> value) {
                //获取数据成功
                //DiskCacheManager manager = new DiskCacheManager(FunnyApplication.getContext(), Constants.CACHE_NEWS_FILE);
                //manager.put(Constants.CACHE_RECOMMEND_NEWS, value);
                currentIndex += 20;
                view.showRefreshData(value);
                Log.e(TAG, "onSuccess: "+value.size());
            }

            @Override
            public void onError(Throwable e) {

            }

        });
    }

    @Override
    public void setLoadMore() {
        model.loadMore(currentIndex, new SingleObserver<ArrayList<BaseItem>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(ArrayList<BaseItem> value) {
                //获取数据成功
                Log.e(TAG, "onSuccess: "+value.size());
                //DiskCacheManager manager = new DiskCacheManager(FunnyApplication.getContext(), Constants.CACHE_NEWS_FILE);
                //manager.put(Constants.CACHE_RECOMMEND_NEWS, value);
                currentIndex += 20;
                view.showLoadMoreData(value); //显示数据
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e);
            }
        });
    }
}
