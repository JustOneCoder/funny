package com.flf.funny.ui.fragment.gamelive;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.GameLiveRecyclerAdapter;
import com.flf.funny.presenter.gamelive.Dota2Presenter;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 * return
 * description
 */
public class Dota2PagerFragment extends BasePagerFragment<Dota2Presenter> {

    public static Dota2PagerFragment newInstance() {
        Bundle args = new Bundle();
        Dota2PagerFragment fragment = new Dota2PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dota2Presenter newP() {
        return new Dota2Presenter(this);
    }

    @Override
    protected void setLayoutManager(UltimateRecyclerView mFunnyRecyclerView) {
        mFunnyRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
    }

    @Override
    protected BaseRecyclerViewAdapter createAdapter() {
        return new GameLiveRecyclerAdapter(mContext);
    }

    public boolean getNewsOrLive() {
        return true;
    }

}
