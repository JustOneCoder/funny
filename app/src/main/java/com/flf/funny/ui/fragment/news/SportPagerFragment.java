package com.flf.funny.ui.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.NewsCommonRecyclerAdapter;
import com.flf.funny.presenter.news.HeadLinePagerPresenter;
import com.flf.funny.presenter.news.SportPagerPresenter;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 * 作者：Administrator
 * 时间：2017/4/10:18:05
 * 说明： 运动新闻
 */
public class SportPagerFragment extends BasePagerFragment<SportPagerPresenter>{

    private HeadLinePagerPresenter mPresenter;

    public static SportPagerFragment newInstance() {
        Bundle args = new Bundle();
        SportPagerFragment fragment = new SportPagerFragment();
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
    public SportPagerPresenter newP() {
        return new SportPagerPresenter(this);
    }
}
