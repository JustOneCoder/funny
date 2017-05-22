package com.flf.funny.contract.base;

import android.os.Bundle;
import android.view.View;

/**
 * 作者：Administrator
 * 时间：2017/4/10:11:08
 * 说明： 新闻界面数模型
 */

public interface BaseView<P> {
    void bindUI(View rootView);      //绑定ui,也就是使用butterKnife绑定

    //void initView();               //初始化视图

    void initData(Bundle savedInstanceState);   //初始化数据

    int getLayoutId();                //设置布局文件id

    P newP();                        //获取Presenter层引用,view向他报告用户的行为
}
