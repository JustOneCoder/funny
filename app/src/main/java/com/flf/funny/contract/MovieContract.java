package com.flf.funny.contract;


import com.flf.funny.contract.base.BaseModel;
import com.flf.funny.contract.base.BasePresenter;
import com.flf.funny.contract.base.BaseView;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.ListBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;

/**
 * 作者：Administrator
 * 时间：2017/4/27:19:06
 * 说明：新闻
 */

public interface MovieContract {
    abstract class Model extends BaseModel {
        public abstract void refresh(SingleObserver<ArrayList<ListBean>> singleObserver);
    }

    interface View extends BaseView {
        void showError();
        void showMovie(ArrayList<ListBean> value);
    }

    abstract class Presenter extends BasePresenter<Model, View> {
        public abstract void setRefresh();

    }
}
