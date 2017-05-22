package com.flf.funny.contract;

import com.flf.funny.contract.base.BaseModel;
import com.flf.funny.contract.base.BasePresenter;
import com.flf.funny.contract.base.BaseView;
import com.flf.funny.model.bean.BaseItem;

import java.util.ArrayList;

import io.reactivex.SingleObserver;

/**
 * 作者：Administrator
 * 时间：2017/5/11:10:50
 * 说明：游戏直播Contract
 */

public interface GameLiveContract {
    abstract class Model extends BaseModel {
        public abstract void refresh(int currentIndex,SingleObserver<ArrayList<BaseItem>> singleObserver);
        public abstract void loadMore(int currentIndex,SingleObserver<ArrayList<BaseItem>> singleObserver);
    }

    interface View extends BaseView {
        void showError();
    }

    abstract class Presenter extends BasePresenter<NewsAndGameLiveContract.Model, NewsAndGameLiveContract.View> {
        public abstract void setRefresh();
        public abstract void setLoadMore();

    }
}
