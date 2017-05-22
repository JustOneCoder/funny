package com.flf.funny.ui.fragment.gamelive;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.GameLiveRecyclerAdapter;
import com.flf.funny.presenter.gamelive.ShouWangPresenter;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 *return
 *description
 */
public class ShouWangPagerFragment extends BasePagerFragment<ShouWangPresenter> {

    public static ShouWangPagerFragment newInstance() {
        Bundle args = new Bundle();
        ShouWangPagerFragment fragment = new ShouWangPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ShouWangPresenter newP() {
        return new ShouWangPresenter(this);
    }

    @Override
    protected void setLayoutManager(UltimateRecyclerView mFunnyRecyclerView) {
        mFunnyRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
    }

    @Override
    protected BaseRecyclerViewAdapter createAdapter() {
        return new GameLiveRecyclerAdapter(mContext);
    }

    public boolean getNewsOrLive() {
        return true;
    }
}
