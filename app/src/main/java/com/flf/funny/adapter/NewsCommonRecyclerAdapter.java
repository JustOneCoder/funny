package com.flf.funny.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.holder.BaseViewHolder;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.news.NewsBean;
import com.flf.funny.ui.activity.NewsInfoActivity;
import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Administrator
 * 时间：2017/4/13:21:07
 * 说明：新闻展示页面共同的Adapter
 */

public class NewsCommonRecyclerAdapter extends BaseRecyclerViewAdapter{

    public static final String TAG = "NewsCommonRecyclerAdapter";
    NewsBean mNewsBean;
    public NewsCommonRecyclerAdapter(Context context){
        super(context);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news_normal, parent, false);
        return new NewsCommonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        //一定要加这个判断  因为UltimateRecyclerView本身有加了头部和尾部  这个方法返回的是包括头部和尾部在内的
        if (position < getItemCount() && (customHeaderView != null ? position <= oldDatas.size() : position < oldDatas.size()) && (customHeaderView != null ? position > 0 : true)) {
            BaseItem b = (BaseItem) oldDatas.get(customHeaderView != null ? position - 1 : position);
            mNewsBean = (NewsBean) b.getData();
            ((NewsCommonViewHolder) holder).setData(mNewsBean);

        }
    }

    static class NewsCommonViewHolder extends BaseViewHolder<NewsBean> {
        public static final String TAG = "NewsCommonViewHolder";
        @BindView(R.id.news_item_normal_img)
        ImageView img;
        @BindView(R.id.news_item_normal_title)
        TextView title;
        @BindView(R.id.news_item_normal_source)
        TextView source;
        public NewsCommonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setData(NewsBean newsBean) {
            title.setText(newsBean.getTitle());
            source.setText(newsBean.getSource());
            String imgsrc = newsBean.getImgsrc();
            Glide.with(getContext())
                    .load(imgsrc)
                    .fitCenter()
                    .thumbnail(0.1f)
                    .into(img);
        }
    }
}
