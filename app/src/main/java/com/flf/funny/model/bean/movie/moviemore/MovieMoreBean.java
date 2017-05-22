package com.flf.funny.model.bean.movie.moviemore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：Administrator
 * 时间：2017/5/14:10:24
 * 说明：电影个类型展示更多的json数据
 */

public class MovieMoreBean<MovieMoreRetBean>{

    private String msg;
    private MovieMoreRetBean ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MovieMoreRetBean getData() {
        return ret;
    }

    public void setRet(MovieMoreRetBean ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
