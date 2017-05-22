package com.flf.funny.ui.fragment.gamelive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.flf.funny.R;
import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.adapter.GameLiveRecyclerAdapter;
import com.flf.funny.model.bean.news.NewsBean;
import com.flf.funny.presenter.gamelive.YingXiongPresenter;
import com.flf.funny.service.config.Constants;
import com.flf.funny.ui.activity.NewsInfoActivity;
import com.flf.funny.ui.base.BasePagerFragment;
import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 * return
 * description
 */
public class YingXiongPagerFragment extends BasePagerFragment<YingXiongPresenter> {

    public static YingXiongPagerFragment newInstance() {
        Bundle args = new Bundle();
        YingXiongPagerFragment fragment = new YingXiongPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public YingXiongPresenter newP() {
        return new YingXiongPresenter(this);
    }

    @Override
    protected void setLayoutManager(UltimateRecyclerView mFunnyRecyclerView) {
        mFunnyRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
    }

    @Override
    protected BaseRecyclerViewAdapter createAdapter() {
        return new GameLiveRecyclerAdapter(mContext);
    }

    @Override
    public boolean firstChild() {
        return true;
    }

    public boolean getNewsOrLive() {
        return true;
    }
}
