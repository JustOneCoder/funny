package com.flf.funny.ui.implView;


import com.flf.funny.contract.base.BaseView;

/**
 * 作者：Administrator
 * 时间：2017/4/11:21:31
 * 说明：
 */

public interface INewsView extends BaseView {
    void showRefreshBar();

    void hideRefreshBar();

    void refreshNews();

    void refreshNewsFail(String errorMsg);

    //void refreshNewsSuccessed(ArrayList<BaseItem> topNews);

    void loadMoreNews();

    void loadMoreFail(String errorMsg);

   // void loadMoreSuccessed(ArrayList<BaseItem> topNews);
}
