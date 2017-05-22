package com.flf.funny.service;

import android.widget.RemoteViews;

import com.flf.funny.model.bean.movie.MovieResponseListBean;
import com.flf.funny.model.bean.movie.MovieResponseRetBean;
import com.flf.funny.model.bean.movie.moviemore.MovieMoreBean;
import com.flf.funny.model.bean.movie.moviemore.MovieMoreRetBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：Administrator
 * 时间：2017/4/22:20:36
 * 说明：电影api
 */

public interface MovieApiService {
    /**
     * 获取首页数据 json
     *
     * @return 首页数据的 Observer
     */
    @GET("homePageApi/homePage.do")
    Observable<MovieResponseListBean<MovieResponseRetBean>> getMovie();

    /*获取分类视频列 (其实是在首页json解析过来的)
        catalogId = 402834815584e463015584e539700019*/
    @GET("columns/getVideoList.do")
    Observable<MovieMoreBean<MovieMoreRetBean>> getMovieMore(@Query("catalogId") String catalogId, @Query("pnum") String pnum);


    /**
     * 获取电影详情 json
     *
     * @param mediaId 影片Id
     * @return 影片详情 bserver
     *//*
    @GET("videoDetailApi/videoDetail.do")
    Observable<MovieResponse<MovieInfo>> getMovieDaily(@Query("mediaId") String mediaId);

    *//**
     * 影片搜索
     *
     * @param keyword 搜索关键词
     * @param pnum    页码
     * @return 影片搜索结果
     *//*
    @GET("searchKeyWordApi/getVideoListByKeyWord.do")
    Observable<MovieResponse<SearchData>> getVideoListByKeyWord(@Query("keyword") String keyword, @Query("pnum") String pnum);

    *//**
     * 获取评论列表
     *
     * @param mediaId 影片 ID
     * @param pnum    页码
     * @return 评论结果
     *//*
    @GET("Commentary/getCommentList.do")
    Observable<MovieResponse<CommentBean>> getCommentList(@Query("mediaId") String mediaId, @Query("pnum") String pnum);



    *//**
     * 获取直播列表
     *//*
    @GET("liveData/getLiveDataByTVcatalogId.do")
    Observable<MovieResponse<TypedVideos>> getLiveVideo(@Query("catalogId") String catalogId, @Query("pnum") String pnum);
//    *//**
     //     * 获取专题列表
     //     *//*
//    @GET("columns/getVideoList.do")
//    Observable<MovieResponse<TypedVideos>> getMovieMore(@Query("catalogId") String catalogId);*/
}
