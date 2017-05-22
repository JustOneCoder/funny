package com.flf.funny.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.flf.funny.R;
import com.flf.funny.holder.BaseViewHolder;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.ListBean;
import com.flf.funny.service.config.Constants;
import com.flf.funny.ui.activity.MovieMoreActivity;
import com.flf.funny.ui.activity.MoviePlayActivity;
import com.flf.funny.widget.MovieRecyclerView;
import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 作者：Administrator
 * 时间：2017/4/22:19:59
 * 说明：
 */

public class MovieRecyclerAdapter extends BaseRecyclerViewAdapter {

    public static final String TAG = "MovieRecyclerAdapter";
    ArrayList<BaseItem> list;
    public Context mContext;


    public MovieRecyclerAdapter(Context context, ArrayList<BaseItem> mBaseItems) {
        super(context);
        this.mContext = context;
        this.list = mBaseItems;
    }

    @Override
    public int getAdapterItemCount() {
        Log.e(TAG, "getAdapterItemCount: " + list.size());
        return list.size();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent) {
        return new MovieTypeViewHolder(parent, R.layout.item_movie_type);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < getItemCount() && (customHeaderView != null ? position <= list.size() : position < list.size()) && (customHeaderView != null ? position > 0 : true)) {
            position = customHeaderView != null ? position - 1 : position;

            final ListBean bean = (ListBean) list.get(position).getData();
            ((MovieTypeViewHolder) holder).movieItemTypeName.setText(bean.getTitle());
            List<ListBean.ChildListBean> childList = bean.getChildList();
            ((MovieTypeViewHolder) holder).setData(childList);
            ((MovieTypeViewHolder) holder).more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击更多跳转到该电影类型的列表页Activity
                    if (bean.getMoreURL() != null && bean.getMoreURL().length() != 0) {
                        Intent intent = new Intent(mContext, MovieMoreActivity.class);
                        intent.putExtra(Constants.TYPED_MORE_TITLE, bean.getTitle());
                        intent.putExtra(Constants.MOVIE_MOREURL, bean.getMoreURL());
                        mContext.startActivity(intent);
                    } else {
                        Toast.makeText(mContext, "抱歉!暂时没有更多", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }


    static class MovieTypeViewHolder extends BaseViewHolder<List<ListBean.ChildListBean>> {
        public static final String TAG = "MovieTypeViewHolder";
        @BindView(R.id.movie_item_type_name)
        TextView movieItemTypeName;
        @BindView(R.id.recyclerView_movie_item)
        UltimateRecyclerView horizontalRecyclerView;
        @BindView(R.id.movie_more)
        TextView more;
        //List<ListBean.ChildListBean> childList;

        MovieTypeViewHolder(ViewGroup view, int layoutId) {
            super(view, layoutId);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(final List<ListBean.ChildListBean> childList) {
            //this.childList.addAll(childList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalRecyclerView.setLayoutManager(linearLayoutManager);
            horizontalRecyclerView.setAdapter(new HorizontalRecyclerViewAdapter(getContext(), childList));
            horizontalRecyclerView.mRecyclerView.addOnItemTouchListener(new ItemTouchListenerAdapter(horizontalRecyclerView.mRecyclerView,
                    new ItemTouchListenerAdapter.RecyclerViewOnItemClickListener() {
                        @Override
                        public void onItemClick(RecyclerView parent, View clickedView, int position) {
                            String loadURL = childList.get(position).getLoadURL();
                            Intent intent = new Intent(getContext(), MoviePlayActivity.class);
                            intent.putExtra(Constants.MOVIE_PLAY_URL, loadURL);
                            getContext().startActivity(intent);
                        }

                        @Override
                        public void onItemLongClick(RecyclerView parent, View clickedView, int position) {

                        }
                    }));
        }



    }

}
