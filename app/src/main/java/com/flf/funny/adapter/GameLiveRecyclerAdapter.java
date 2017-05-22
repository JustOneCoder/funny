package com.flf.funny.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.holder.BaseViewHolder;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.Live.ResultBean;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Administrator
 * 时间：2017/5/16:14:51
 * 说明：游戏直播界面adapter
 */

public class GameLiveRecyclerAdapter extends BaseRecyclerViewAdapter {

    public static final String TAG = "GameLiveRecyclerAdapter";
    Context mContext;
    public GameLiveRecyclerAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new LiveCommonViewHolder(parent, R.layout.item_gamelive_normal);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position < getItemCount() && (customHeaderView != null ? position <= oldDatas.size() : position < oldDatas.size()) && (customHeaderView != null ? position > 0 : true)) {
            BaseItem b = (BaseItem) oldDatas.get(customHeaderView != null ? position - 1 : position);
            Log.e(TAG, "onBindViewHolder: "+oldDatas.size() );
            ResultBean data = (ResultBean) b.getData();
            ((LiveCommonViewHolder) holder).setData(data);
            ResultBean.UrlInfoBean url_info = data.getUrl_info();
            if (data.getUrl_info()!=null) {    //有的数据中可能没有用户数据
                String user_agent = url_info.getUser_Agent();
                String referer = url_info.getReferer();
                String agentImg = referer+user_agent;
                Log.e(TAG, "onBindViewHolder: "+agentImg );
                Glide.with(mContext)
                        .load(agentImg)
                        .centerCrop()
                        .into(((LiveCommonViewHolder) holder).mliveAgent);
            }
        }
    }

    static class LiveCommonViewHolder extends BaseViewHolder<ResultBean> {
        @BindView(R.id.gamelive_item_img)
        ImageView mliveImg;
        @BindView(R.id.gamelive_item_title)
        TextView mliveTitle;
        @BindView(R.id.gamelive_item_agent)
        ImageView mliveAgent;
        @BindView(R.id.gamelive_item_user_name)
        TextView mliveUserName;
        @BindView(R.id.gamelive_item_online)
        TextView mliveOnline;

        public LiveCommonViewHolder(ViewGroup parent, int layoutId) {
            super(parent, layoutId);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(ResultBean data) {
            String img = data.getLive_img();
            String user_name = data.getLive_nickname();
            String title = data.getLive_title();
            String online = data.getLive_online();
            mliveTitle.setText(title);
            mliveUserName.setText(user_name);
            mliveOnline.setText(online);
            Glide.with(getContext())
                    .load(img)
                    .into(mliveImg);
        }
    }
}
