package com.flf.funny.ui.fragment.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.flf.funny.R;
import com.flf.funny.adapter.NewsFragmentPagerAdapter;
import com.flf.funny.ui.base.BaseFragment;
import com.flf.funny.ui.base.BasePagerFragment;
import com.flf.funny.ui.fragment.gamelive.Dota2PagerFragment;
import com.flf.funny.ui.fragment.gamelive.LuShiPagerFragment;
import com.flf.funny.ui.fragment.gamelive.ShouWangPagerFragment;
import com.flf.funny.ui.fragment.gamelive.YingXiongPagerFragment;
import com.flf.funny.utils.StatusBarUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Administrator
 * 时间：2017/4/10:12:35
 * 说明： 游戏直播界面Fragment
 */
public class GameLiveFragment extends BaseFragment {

    private static final String TAG = "GameLiveFragment";
    private static final String titles[] = {"英雄联盟", "守望先锋", "Dota2", "炉石传说"};
    ArrayList<BasePagerFragment> mFragmentList;
    @BindView(R.id.tabLayout_gameLive)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager_gameLive)
    ViewPager mViewPager;
    @BindView(R.id.status_bar_fix_gamelive)
    View mStatusBarFixGamelive;

    public static GameLiveFragment newInstance() {
        Bundle args = new Bundle();
        GameLiveFragment fragment = new GameLiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Object newP() {
        return null;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_game_live;
    }

    @Override
    public void initView() {
        mStatusBarFixGamelive.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtils.getStateBarHeight(getActivity())));//填充状态栏
        mFragmentList = new ArrayList<>();
        mFragmentList.add(YingXiongPagerFragment.newInstance());
        mFragmentList.add(ShouWangPagerFragment.newInstance());
        mFragmentList.add(Dota2PagerFragment.newInstance());
        mFragmentList.add(LuShiPagerFragment.newInstance());

        for (int i = 0; i < titles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles[i]));
        }

        NewsFragmentPagerAdapter adapter = new NewsFragmentPagerAdapter(getChildFragmentManager(), mFragmentList, titles);
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);         //TabLayout关联ViewPager
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);      //给TabLayout设置模式
    }


}
