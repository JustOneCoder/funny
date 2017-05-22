package com.flf.funny.holder;

import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.adapter.AutoViewPagerAdapter;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.ListBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * 作者：Administrator
 * 时间：2017/5/8:12:55
 * 说明：
 */

public class HeaderViewHolder extends BaseViewHolder<ListBean.ChildListBean> {
        @BindView(R.id.auto_viewPager)
        AutoScrollViewPager autoViewPager;

        public HeaderViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(ListBean.ChildListBean bean) {
            //autoViewPager.setAdapter(new AutoViewPagerAdapter());
           /* Glide.with(getContext())
                    .load(bean.getPic())
                    .centerCrop()
                    .into(autoViewPager)*/
        }
}
