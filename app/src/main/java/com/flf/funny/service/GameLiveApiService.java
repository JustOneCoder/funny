package com.flf.funny.service;

import com.flf.funny.model.bean.Live.LiveBaseBean;
import com.flf.funny.model.bean.Live.ResultBean;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：Administrator
 * 时间：2017/5/11:10:09
 * 说明：游戏直播api
 */

public interface GameLiveApiService {
    int LIMIT = 20;

    //请求获取不同游戏的直播列表
    @GET("api/live/list/")
    Observable<LiveBaseBean<ArrayList<ResultBean>>> getLiveList(
            @Query("offset") int offset,
            @Query("limit") int limit,
            @Query("live_type") String live_type,
            @Query("game_type") String game_type
    );

 /*   //请求获取直播详情
    @GET("api/live/detail/")
    Flowable<LiveBaseBean<LiveDetailBean>> getLiveDetail(
            @Query("live_type") String live_type,
            @Query("live_id") String live_id,
            @Query("game_type") String game_type
    );

    //请求获取弹幕聊天室详情
    @GET("ajax_chatinfo")
    Flowable<LivebarrageBean> getPandaChatroom(
            @Query("roomid") String roomid
    );*/
}
