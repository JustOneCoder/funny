package com.flf.funny.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.holder.BaseViewHolder;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.moviemore.ListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Administrator
 * 时间：2017/5/14:10:49
 * 说明：电影更多界面adapter
 */

public class MovieMoreRecyclerAdapter extends BaseRecyclerViewAdapter{
    public static final String TAG  = "MovieMoreRecyclerAdapter";
    List<BaseItem> mList = new ArrayList<BaseItem>();
    Context mContext;

    public MovieMoreRecyclerAdapter(Context context, List<BaseItem> list) {
        super(context);
        this.mContext = context;
        this.mList = list;
    }

    public MovieMoreRecyclerAdapter(Context context) {
        super(context);
    }

    //添加数据
    public void appendToList(List<BaseItem> data) {
        if (data == null) {
            return;
        }
        mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getAdapterItemCount() {
        return mList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new MovieMoreInfoViewHolder(parent, R.layout.item_movie_more);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < getItemCount() && (customHeaderView != null ? position <= mList.size() : position < mList.size()) && (customHeaderView != null ? position > 0 : true)) {
            ListBean bean = (ListBean) mList.get(customHeaderView != null ? position - 1 : position).getData();

            ((MovieMoreInfoViewHolder) holder).setData(bean);
        }
    }

    static class MovieMoreInfoViewHolder extends BaseViewHolder<ListBean> {
        @BindView(R.id.movie_more_video_img)
        ImageView mMovieMoreVideoImg;
        @BindView(R.id.movie_more_video_name)
        TextView mMovieMoreVideoName;
        @BindView(R.id.movie_more_video_starts)
        RatingBar mMovieMoreVideoStarts;
        @BindView(R.id.movie_more_video_rate)
        TextView mMovieMoreVideoRate;
        @BindView(R.id.movie_more_airTime)
        TextView mMovieMoreAirTime;
        @BindView(R.id.movie_more_duration)
        TextView mMovieDuration;

        public MovieMoreInfoViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(ListBean listBean) {
            Glide.with(getContext())
                    .load(listBean.getPic())
                    .centerCrop()
                    .into(mMovieMoreVideoImg);
            mMovieMoreVideoName.setText(listBean.getTitle());
            mMovieMoreVideoRate.setText(listBean.getScore()+"");
            mMovieDuration.setText(listBean.getDuration());

        }

    }

}
