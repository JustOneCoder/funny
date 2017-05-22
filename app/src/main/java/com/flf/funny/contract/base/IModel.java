package com.flf.funny.contract.base;

/**
 * 作者：Administrator
 * 时间：2017/4/10:11:11
 * 说明： 新闻界面数模型
 */

public interface IModel {
    boolean isNull();       //空数据

    boolean isAuthError();  //验证错误

    boolean isBizError();   //业务错误

    String getErrorMsg();   //后台返回的错误信息

    void onDestroy();
}
