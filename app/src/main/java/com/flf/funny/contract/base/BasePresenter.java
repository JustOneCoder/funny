package com.flf.funny.contract.base;

/**
 * 作者：Administrator
 * 时间：2017/4/11:13:39
 * 说明：Presenter基类,添加Presenter对View的绑定和解绑
 */

public class BasePresenter<M extends BaseModel, V extends BaseView> implements IPresenter<M, V> {
    private M mModel;
    private V mView;

    @Override
    public void setup(M model, V view) {
        mModel = model;
        mView = view;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    public V getView() {
        if (mView == null) {
            throw new IllegalStateException("v can not be null");
        }
        return mView;
    }

    public M getModel() {
        return mModel;
    }

    @Override
    public void onDestroy() {
        //取消网络请求
        if (getModel() != null) {
            getModel().onDestroy();
        }
    }

}
