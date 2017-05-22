package com.flf.funny.holder;

import android.view.View;

import butterknife.ButterKnife;

/**
 * 作者：Administrator
 * 时间：2017/5/11:10:04
 * 说明：
 */

public class GameLiveViewHolder extends BaseViewHolder {

    public GameLiveViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(Object data) {

    }
}
