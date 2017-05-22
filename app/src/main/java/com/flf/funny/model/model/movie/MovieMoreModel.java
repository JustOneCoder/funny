package com.flf.funny.model.model.movie;

import android.content.Context;

import com.flf.funny.contract.MovieMoreContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.moviemore.ListBean;
import com.flf.funny.model.bean.movie.moviemore.MovieMoreBean;
import com.flf.funny.model.bean.movie.moviemore.MovieMoreRetBean;
import com.flf.funny.service.ApiServiceManager;
import com.flf.funny.ui.activity.MovieMoreActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：Administrator
 * 时间：2017/5/14:13:33
 * 说明：分类电影等多界面的数据请求
 */

public class MovieMoreModel extends MovieMoreContract.Model{

    private MovieMoreActivity mContext;
    private int currentPage = 0;

    public MovieMoreModel(MovieMoreActivity context) {
        this.mContext = context;
    }

    @Override
    public void loadMore(String catalogId,SingleObserver<List<BaseItem>> singleObserver) {
        ApiServiceManager.getInstence()
                .getMovieService()
                .getMovieMore(catalogId,String.valueOf(currentPage + 1))
                .map(new Function<MovieMoreBean<MovieMoreRetBean>, List<ListBean>>() {
                    @Override
                    public List<ListBean> apply(MovieMoreBean<MovieMoreRetBean> response) {
                        currentPage = response.getData().getPnum();
                        int totalPum = response.getData().getTotalPnum();
                        if (currentPage == totalPum) { //加载完所有的视频后
                            mContext.noMoreMovie();   //可以在界面底部添加已经加载完的标识
                        }
                        return response.getData().getList();
                    }
                })
                .flatMap(new Function<List<ListBean>, Observable<ListBean>>() {
                    @Override
                    public Observable<ListBean> apply(List<ListBean> listBeen) {
                        return Observable.fromIterable(listBeen);
                    }
                })
                .map(new Function<ListBean, BaseItem>() {
                    @Override
                    public BaseItem apply(ListBean listBean) {
                        BaseItem<ListBean> base = new BaseItem<>();
                        base.setData(listBean);
                        return base;
                    }
                })
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(singleObserver);
    }
}
