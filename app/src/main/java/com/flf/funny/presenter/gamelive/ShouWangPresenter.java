package com.flf.funny.presenter.gamelive;

import com.flf.funny.model.model.live.ShouWangModel;
import com.flf.funny.presenter.base.NewsAndGameLivePagerPresenter;
import com.flf.funny.ui.fragment.gamelive.ShouWangPagerFragment;

/**
 * 作者：Administrator
 * 时间：2017/5/11:11:11
 * 说明：
 */

public class ShouWangPresenter extends NewsAndGameLivePagerPresenter {
    public static final String TAG = "ShouWangPresenter";

    private ShouWangModel model;
    private ShouWangPagerFragment view;
    public int currentIndex;

    public ShouWangPresenter(ShouWangPagerFragment fragment) {
        this.view = fragment;
        model = new ShouWangModel();
    }


    @Override
    public void setRefresh() {

    }

    @Override
    public void setLoadMore() {

    }
}
