package com.flf.funny.ui.fragment.gamelive;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.GameLiveRecyclerAdapter;
import com.flf.funny.presenter.gamelive.LuShiPresenter;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 *return
 *description
 */
public class LuShiPagerFragment extends BasePagerFragment<LuShiPresenter> {

    public static LuShiPagerFragment newInstance() {
        Bundle args = new Bundle();
        LuShiPagerFragment fragment = new LuShiPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public LuShiPresenter newP() {
        return new LuShiPresenter(this);
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
