package com.flf.funny.ui.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.NewsCommonRecyclerAdapter;
import com.flf.funny.presenter.news.HeadLinePagerPresenter;
import com.flf.funny.presenter.news.HealthPagerPresenter;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 * 作者：Administrator
 * 时间：2017/4/10:18:05
 * 说明： 健康新闻
 */
public class HealthPagerFragment extends BasePagerFragment<HealthPagerPresenter>{

    private HeadLinePagerPresenter mPresenter;

    public static HealthPagerFragment newInstance() {
        Bundle args = new Bundle();
        HealthPagerFragment fragment = new HealthPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setLayoutManager(UltimateRecyclerView mFunnyRecyclerView) {
        mFunnyRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    protected BaseRecyclerViewAdapter createAdapter() {
        return new NewsCommonRecyclerAdapter(mContext);
    }

    @Override
    public HealthPagerPresenter newP() {
        return new HealthPagerPresenter(this);
    }
}
