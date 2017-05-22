package com.flf.funny.contract.base;

import com.flf.funny.contract.base.IModel;

/**
 * 作者：Administrator
 * 时间：2017/4/12:21:19
 * 说明：
 */

public class BaseModel<T> implements IModel {
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
        //取消网络请求
    }

}
