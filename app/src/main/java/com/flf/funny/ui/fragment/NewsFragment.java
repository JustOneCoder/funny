package com.flf.funny.ui.fragment;

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
import com.flf.funny.ui.fragment.news.HeadLinePagerFragment;
import com.flf.funny.ui.fragment.news.HealthPagerFragment;
import com.flf.funny.ui.fragment.news.SciencePagerFragment;
import com.flf.funny.ui.fragment.news.SportPagerFragment;
import com.flf.funny.utils.StatusBarUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 作者：Administrator
 * 时间：2017/4/10:12:34
 * 说明： 主页新闻界面Fragmeng
 */
public class NewsFragment extends BaseFragment {

    private static final String titles[] = {"要闻", "科技", "运动", "健康"};
    private static final String TAG = "NewsFragment";

    ArrayList<BasePagerFragment> mFragmentList;
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.status_bar_fix_news)
    View mStatusBarFixNews;

    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void initView() {
        mStatusBarFixNews.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarUtils.getStateBarHeight(getActivity())));//填充状态栏
        mFragmentList = new ArrayList<>();
        mFragmentList.add(HeadLinePagerFragment.newInstance());
        mFragmentList.add(SciencePagerFragment.newInstance());
        mFragmentList.add(SportPagerFragment.newInstance());
        mFragmentList.add(HealthPagerFragment.newInstance());

        for (int i = 0; i < titles.length; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles[i]));
        }

        NewsFragmentPagerAdapter adapter = new NewsFragmentPagerAdapter(getChildFragmentManager(), mFragmentList, titles);
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);         //TabLayout关联ViewPager
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);      //给TabLayout设置模式
    }

}
