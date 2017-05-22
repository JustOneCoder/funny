package com.flf.funny.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.holder.BaseViewHolder;
import com.flf.funny.model.bean.movie.ListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Administrator
 * 时间：2017/5/13:12:54
 * 说明：
 */

public class HorizontalRecyclerViewAdapter extends BaseRecyclerViewAdapter {

    List<ListBean.ChildListBean> childList;

    public HorizontalRecyclerViewAdapter(Context context, List<ListBean.ChildListBean> childList) {
        super(context);
        this.childList = childList;
    }

    @Override
    public int getAdapterItemCount() {
        return childList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HorizontalRecyclerViewHolder(parent, R.layout.item_movie_recommend);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ListBean.ChildListBean childListBean = childList.get(position);
        ((HorizontalRecyclerViewHolder) holder).setData(childListBean);
    }

    static class HorizontalRecyclerViewHolder extends BaseViewHolder<ListBean.ChildListBean> {
        public static final String TAG = "HorizontalRecyclerViewHolder";
        @BindView(R.id.movie_item_img)
        ImageView movieItemImg;
        @BindView(R.id.movie_name)
        TextView movieName;
        @BindView(R.id.angelIcon)
        ImageView angelIcon;

        public HorizontalRecyclerViewHolder(ViewGroup view, int layoutId) {
            super(view, layoutId);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(ListBean.ChildListBean bean) {
            movieName.setText(bean.getTitle());

            String bigPicShowFlag = bean.getPic();
            String angleIcon = bean.getAngleIcon();
            Glide.with(getContext())
                    .load(bigPicShowFlag)
                    .centerCrop()
                    .into(movieItemImg);
            Glide.with(getContext())
                    .load(angleIcon)
                    .centerCrop()
                    .into(angelIcon);
        }
    }
}
