package com.flf.funny.presenter.base;

import com.flf.funny.contract.base.BaseView;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * 作者：Administrator
 * 时间：2017/5/4:23:06
 * 说明：
 */

public abstract class FunnySingleObserver<T,V extends BaseView> implements SingleObserver<T>{
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onSuccess(T value) {
        V iView = getIView();
        onNestSuccess(value,iView);
    }
    @Override
    public void onError(Throwable e) {
        V iView = getIView();
        onNestError(e,iView);
    }

    protected abstract V getIView();
    protected abstract void onNestSuccess(T value, V iView);
    protected abstract void onNestError(Throwable e, V iView);



}
