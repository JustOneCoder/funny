package com.flf.funny.ui.fragment.news;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.NewsCommonRecyclerAdapter;
import com.flf.funny.presenter.news.HeadLinePagerPresenter;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 * 作者：Administrator
 * 时间：2017/4/10:18:05
 * 说明： 娱乐新闻,这些pagerFragment才是进行真正的数据加载和显示的view
 */
public class HeadLinePagerFragment extends BasePagerFragment<HeadLinePagerPresenter>{

    public static final String TAG = "HeadLinePagerFragment";

    public static HeadLinePagerFragment newInstance() {
        Bundle args = new Bundle();
        HeadLinePagerFragment fragment = new HeadLinePagerFragment();
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
    public HeadLinePagerPresenter newP() {
        return new HeadLinePagerPresenter(this);
    }

    @Override
    public boolean firstChild() {
        return true;
    }
}
