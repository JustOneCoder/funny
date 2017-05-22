package com.flf.funny.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.flf.funny.ui.base.BaseFragment;
import com.flf.funny.ui.base.BasePagerFragment;

import java.util.List;

/**
 * 作者：Administrator
 * 时间：2017/4/10:17:51
 * 说明：
 */

public class NewsFragmentPagerAdapter extends FragmentPagerAdapter {

    String titles[];

    List<BasePagerFragment> mFragmentList;
    public NewsFragmentPagerAdapter(FragmentManager fm, List<BasePagerFragment> list,String[] titles) {
        super(fm);
        mFragmentList = list;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
