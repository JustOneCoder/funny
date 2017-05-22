package com.flf.funny.model.bean.base;

import com.flf.funny.contract.base.IModel;

/**
 * 作者：Administrator
 * 时间：2017/4/12:21:19
 * 说明：
 */

public class BaseListModel<T> implements IModel {
    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return false;
    }

    @Override
    public boolean isBizError() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }

    @Override
    public void onDestroy() {

    }

    //specific service handle methods
    private int retcode;
    private String retmsg = "";
    private ListWrapper<T> datas;

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public ListWrapper<T> getDatas() {
        return datas;
    }

    public void setDatas(ListWrapper<T> datas) {
        //this.datas = datas;
    }
}
