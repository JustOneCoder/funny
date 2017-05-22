package com.flf.funny.presenter.movie;

import android.content.Context;
import android.util.Log;

import com.flf.funny.contract.MovieMoreContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.model.movie.MovieMoreModel;
import com.flf.funny.ui.activity.MovieMoreActivity;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 作者：Administrator
 * 时间：2017/5/14:13:39
 * 说明：
 */

public class MovieMorePresenter extends MovieMoreContract.Presenter {

public static final String TAG = "MovieMorePresenter";
    MovieMoreModel model;
    MovieMoreActivity view;
    String mCatalogId;
    public MovieMorePresenter(MovieMoreActivity activity,String catalogId) {
        this.view = activity;
        model = new MovieMoreModel(activity);
        this.mCatalogId = catalogId;
    }

    @Override
    public void setLoadMore() {
             model.loadMore(mCatalogId, new SingleObserver<List<BaseItem>>() {
                 @Override
                 public void onSubscribe(Disposable d) {
                     Log.e(TAG, "onSubscribe: "+d);
                 }

                 @Override
                 public void onSuccess(List<BaseItem> value) {
                     Log.e(TAG, "onSuccess: "+value.size() );
                     view.showLoadMoreData(value);
                 }

                 @Override
                 public void onError(Throwable e) {
                     Log.e(TAG, "onError: "+e.toString() );
                 }
             });
    }
}
