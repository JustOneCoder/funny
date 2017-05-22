package com.flf.funny.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.flf.funny.model.bean.movie.ListBean;
import com.flf.funny.ui.fragment.movie.MovieFragment;

import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * 作者：Administrator
 * 时间：2017/5/8:11:58
 * 说明：
 */

public class AutoViewPagerAdapter extends PagerAdapter {
    List<ListBean.ChildListBean> childList;
    Context context;
    ListBean bean;
    public AutoViewPagerAdapter(Context context,List<ListBean.ChildListBean> childList) {
        this.context = context;
        this.childList = childList;
    }

    @Override
    public int getCount() {
        return childList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return object == view;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ListBean.ChildListBean childListBean = childList.get(position);
        String pic = childListBean.getPic();
        ImageView imageView = new ImageView(context);
        Glide.with(context)
                .load(pic)
                .centerCrop()
                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);

    }
}
