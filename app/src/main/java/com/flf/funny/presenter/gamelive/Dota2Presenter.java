package com.flf.funny.presenter.gamelive;

import com.flf.funny.model.model.live.Dota2Model;
import com.flf.funny.presenter.base.NewsAndGameLivePagerPresenter;
import com.flf.funny.ui.fragment.gamelive.Dota2PagerFragment;

/**
 * 作者：Administrator
 * 时间：2017/5/11:10:56
 * 说明：
 */

public class Dota2Presenter extends NewsAndGameLivePagerPresenter {
    public static final String TAG = "Dota2Presenter";

    private Dota2Model model;
    private Dota2PagerFragment view;
    public int currentIndex;

    public Dota2Presenter(Dota2PagerFragment fragment) {
        this.view = fragment;
        model = new Dota2Model();
    }


    @Override
    public void setRefresh() {

    }

    @Override
    public void setLoadMore() {

    }
}
