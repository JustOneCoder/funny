package com.flf.funny.presenter.gamelive;

import android.util.Log;

import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.model.live.YingXiongModel;
import com.flf.funny.presenter.base.NewsAndGameLivePagerPresenter;
import com.flf.funny.ui.fragment.gamelive.YingXiongPagerFragment;

import java.util.ArrayList;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 作者：Administrator
 * 时间：2017/5/11:11:14
 * 说明：
 */

public class YingXiongPresenter extends NewsAndGameLivePagerPresenter {
    public static final String TAG = "YingXiongPresenter";

    private YingXiongModel model;
    private YingXiongPagerFragment view;
    public int currentIndex;

    public YingXiongPresenter(YingXiongPagerFragment fragment) {
        this.view = fragment;
        model = new YingXiongModel();
    }

    @Override
    public void setRefresh() {
        model.refresh(1, new SingleObserver<ArrayList<BaseItem>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe:"+ d);
            }

            @Override
            public void onSuccess(ArrayList<BaseItem> value) {
                Log.e(TAG, "onSuccess: "+value.size());
                view.showRefreshData(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.toString());
            }
        });
    }

    @Override
    public void setLoadMore() {

    }
}
