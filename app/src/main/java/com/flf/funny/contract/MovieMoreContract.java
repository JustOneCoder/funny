package com.flf.funny.contract;

import com.flf.funny.contract.base.BaseModel;
import com.flf.funny.contract.base.BasePresenter;
import com.flf.funny.contract.base.BaseView;
import com.flf.funny.model.bean.BaseItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;

/**
 * 作者：Administrator
 * 时间：2017/5/14:13:17
 * 说明：展示更多电影界面Vontract
 */

public interface MovieMoreContract {
    abstract class Model extends BaseModel {
        public abstract void loadMore(String catalogId,SingleObserver<List<BaseItem>> singleObserver);
    }

    interface View extends BaseView {
        void showError();
        void showLoadMoreData(List<BaseItem> value);
    }

    abstract class Presenter extends BasePresenter {
        public abstract void setLoadMore();
    }
}
