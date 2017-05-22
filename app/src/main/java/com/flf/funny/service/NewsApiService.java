package com.flf.funny.service;

import com.flf.funny.model.bean.news.HeadLineList;
import com.flf.funny.model.bean.news.HealthNewsList;
import com.flf.funny.model.bean.news.SportNewsList;
import com.flf.funny.model.bean.news.TecNewsList;
import com.flf.funny.service.config.Constants;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 作者：Administrator
 * 时间：2017/4/28:13:54
 * 说明：
 */

public interface NewsApiService {
    @GET("list/" + Constants.NETEASY_NEWS_HEADLINE + "/{index}-20.html")
    Observable<HeadLineList> getTopNews(@Path("index") String index);

    @GET("list/" + Constants.NETEASY_NEWS_TEC + "/{index}-20.html")
    Observable<TecNewsList> getTecNews(@Path("index") String index);

    @GET("list/" + Constants.NETEASY_NEWS_SPORT + "/{index}-20.html")
    Observable<SportNewsList> getSportNews(@Path("index") String index);

    @GET("list/" + Constants.NETEASY_NEWS_HEALTH + "/{index}-20.html")
    Observable<HealthNewsList> getRecommendNews(@Path("index") String index);


    @GET("{id}/full.html")
    Observable<ResponseBody> getNewsContent(@Path("id") String id);
}
