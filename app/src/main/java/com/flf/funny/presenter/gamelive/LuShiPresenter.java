package com.flf.funny.presenter.gamelive;

import com.flf.funny.model.model.live.LuShiModel;
import com.flf.funny.presenter.base.NewsAndGameLivePagerPresenter;
import com.flf.funny.ui.fragment.gamelive.LuShiPagerFragment;

/**
 * 作者：Administrator
 * 时间：2017/5/11:11:06
 * 说明：
 */

public class LuShiPresenter extends NewsAndGameLivePagerPresenter {

    private LuShiModel model;
    private LuShiPagerFragment view;
    public int currentIndex;

    public LuShiPresenter(LuShiPagerFragment fragment) {
        this.view = fragment;
        model = new LuShiModel();
    }
    @Override
    public void setRefresh() {

    }

    @Override
    public void setLoadMore() {

    }
}
