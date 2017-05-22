package com.flf.funny.model.bean.movie;

import com.google.gson.annotations.SerializedName;

/**
 * 作者：Administrator
 * 时间：2017/4/22:20:47
 * 说明：电影实体包装类
 */

public class MovieResponseListBean<T>{
    /**
     * msg : 成功
     * ret : {}
     * code : 200
     */
    @SerializedName("msg")
    private String msg;
    @SerializedName("ret")
    private T data;
    @SerializedName("code")
    private String code;

    @Override
    public String toString() {
        return "MovieResponseListBean{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                ", code='" + code + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setRet(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
