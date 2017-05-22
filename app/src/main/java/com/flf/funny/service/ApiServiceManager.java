package com.flf.funny.service;

import com.flf.funny.service.config.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 作者：Administrator
 * 时间：2017/4/22:20:29
 * 说明：所有ApiService管理类
 */

public class ApiServiceManager {

    private static ApiServiceManager mApiServiceManager;
    private static OkHttpClient mClient;
    private MovieApiService mMovieApi;
    private NewsApiService mNewsApi;
    private GameLiveApiService mGameLiveApi;

    public static ApiServiceManager getInstence() {
        if (mApiServiceManager == null) {
            synchronized (ApiServiceManager.class) {
                if (mApiServiceManager == null) {
                    mApiServiceManager = new ApiServiceManager();
                }
            }
        }
        mClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        return mApiServiceManager;
    }

    /**
     * 封装网易新闻API
     */
    public NewsApiService getNewsApiServie() {
        if (mNewsApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.NETEASY_NEWS_API)
                    .client(mClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            mNewsApi = retrofit.create(NewsApiService.class);
        }
        return mNewsApi;
    }

    /**
     * 封装电影 API
     */
    public MovieApiService getMovieService() {
        if (mMovieApi == null){
        Retrofit retrofit = new Retrofit.Builder()
                     .baseUrl(Config.MOVIE_API_URL)
                     .client(mClient)
                     .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
        mMovieApi = retrofit.create(MovieApiService.class);
        }
        return mMovieApi;
    }

    /**
     * 游戏直播 API
     */
    public GameLiveApiService getGameLiveService() {
        if (mGameLiveApi == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_LIVE_URL)
                    .client(mClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mGameLiveApi = retrofit.create(GameLiveApiService.class);
        }
        return mGameLiveApi;
    }


}
