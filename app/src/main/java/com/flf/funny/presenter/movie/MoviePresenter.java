package com.flf.funny.presenter.movie;

import android.util.Log;

import com.flf.funny.contract.MovieContract;
import com.flf.funny.model.model.MovieModel;
import com.flf.funny.model.bean.movie.ListBean;
import com.flf.funny.ui.fragment.movie.MovieFragment;

import java.util.ArrayList;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 作者：Administrator
 * 时间：2017/4/22:19:50
 * 说明：
 * http://api.svipmovie.com/front/homePageApi/homePage.do
 */

public class MoviePresenter extends MovieContract.Presenter {

    public static final String TAG = "MoviePresenter";
    private MovieModel model;
    private MovieFragment view;

    public MoviePresenter(MovieFragment fragment) {
        this.view = fragment;
        model = new MovieModel();
    }

    @Override
    public void setRefresh() {
        model.refresh(new SingleObserver<ArrayList<ListBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: "+d );
            }

            @Override
            public void onSuccess(ArrayList<ListBean> value) {
                Log.e(TAG, "onSuccess: "+value.size() );
                 view.showMovie(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError:"+e.toString());
            }
        });
    }


}
