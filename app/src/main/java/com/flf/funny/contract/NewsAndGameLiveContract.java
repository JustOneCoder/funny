package com.flf.funny.contract;


import com.flf.funny.contract.base.BaseModel;
import com.flf.funny.contract.base.BasePresenter;
import com.flf.funny.contract.base.BaseView;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.presenter.base.FunnySingleObserver;
import com.flf.funny.ui.base.BasePagerFragment;

import java.util.ArrayList;

import io.reactivex.SingleObserver;

/**
 * 作者：Administrator
 * 时间：2017/4/27:19:06
 * 说明：新闻Contract
 */

public interface NewsAndGameLiveContract {
    abstract class Model extends BaseModel {
        public abstract void refresh(int currentIndex,SingleObserver<ArrayList<BaseItem>> singleObserver);
        public abstract void loadMore(int currentIndex,SingleObserver<ArrayList<BaseItem>> singleObserver);
    }

    interface View extends BaseView {
        void showError();
      /*  void showRefreshData(ArrayList<BaseItem> value);
        void showLoadMoreData(ArrayList<BaseItem> value);*/
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void setRefresh();
        public abstract void setLoadMore();

    }
}
