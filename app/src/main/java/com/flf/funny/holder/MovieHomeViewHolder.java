package com.flf.funny.holder;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.ListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 作者：Administrator
 * 时间：2017/4/22:20:02
 * 说明：
 */

public class MovieHomeViewHolder extends BaseViewHolder<ListBean> {


    @BindView(R.id.movie_item_img)
    public ImageView movieItemImg;
    public static final String TAG = "MovieHomeViewHolder";


    public MovieHomeViewHolder(ViewGroup parent, int layoutId) {
        super(parent,layoutId);
        ButterKnife.bind(this, itemView);
    }


    public void setData(ListBean listbean) {
        List<ListBean.ChildListBean> childList = listbean.getChildList();
        ListBean.ChildListBean childListBean = childList.get(0);
        String pic = childListBean.getPic();
        Glide.with(getContext())
                .load(pic)
                .into(movieItemImg);
        Log.e(TAG, "setData: "+pic);

    }
}
