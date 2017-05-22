package com.flf.funny.contract.base;

/**
 * 作者：Administrator
 * 时间：2017/4/10:11:03
 * 说明： model层和View层的交互层顶级接口,获取数据到给view去显示
 */

public interface IPresenter<M,V> {
    void setup(M model, V view);

    void onCreate();

    void onStart();

    void onDestroy();
}
