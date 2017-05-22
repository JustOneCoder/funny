package com.flf.funny.model.model.live;

import com.flf.funny.contract.NewsAndGameLiveContract;
import com.flf.funny.model.bean.BaseItem;

import java.util.ArrayList;

import io.reactivex.SingleObserver;

/**
 * 作者：Administrator
 * 时间：2017/5/11:11:01
 * 说明：
 */

public class Dota2Model extends NewsAndGameLiveContract.Model {

    @Override
    public void refresh(int currentIndex, SingleObserver<ArrayList<BaseItem>> singleObserver) {

    }

    @Override
    public void loadMore(int currentIndex, SingleObserver<ArrayList<BaseItem>> singleObserver) {

    }
}
