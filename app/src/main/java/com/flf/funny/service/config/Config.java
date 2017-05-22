package com.flf.funny.service.config;

/**
 * 作者：Administrator
 * 时间：2017/4/15:23:10
 * 说明： 全局的api配置
 */
public class Config {

    //C9MJ项目不同直播平台基本api
    public static final String BASE_USER_URL = "http://api.douban.com/v2/movie/";
    public static final String BASE_EXPLORE_URL = "http://c.m.163.com/";    //网易新闻基本api
    public static final String BASE_LIVE_URL = "http://api.maxjia.com/";
    public static final String BASE_PANDA_URL = "http://www.panda.tv/";

    //熊猫眼项目基本api
    public static final boolean DEBUG = true;
    public static String DOUBAN_API_URL = "http://api.douban.com/v2/";
    public static String ZHIHU_API_URL = "http://news-at.zhihu.com/api/4/";
    public static String NETEASY_NEWS_API = "http://c.m.163.com/nc/article/";
    public static String MOVIE_API_URL = "http://api.svipmovie.com/front/";
    public static String GITHUB_API_URL = "https://api.github.com/";
    /**
     * 视频分类ID
     */
    //热点资讯
    public static final String MOVIE_TYPE_HOT = "402834815584e463015584e539700019";
    //精彩推荐
    public static final String MOVIE_TYPE_RECOMMEND = "402834815584e463015584e53843000b";
    //好莱坞
    public static final String MOVIE_TYPE_HOLLYWOOD = "402834815584e463015584e538140009";
    //专题 根据当前时间戳获取
//    public static String MOVIE_TYPE_TOPIC = "402834815584e463015584e538140009";
    //直播专区
    public static final String MOVIE_TYPE_LIVE = "402834815584e463015584e537d00006";
    //微电影
    public static final String MOVIE_TYPE_LITTLEMOVIE = "402834815584e463015584e538ea0012";
    //日韩精选
    public static final String MOVIE_TYPE_JSKS = "402834815584e463015584e538a2000f";
    //大咖剧场
    public static final String MOVIE_TYPE_BIGBRO = "402834815584e463015584e537bf0005";
    //午夜剧场
    public static final String MOVIE_TYPE_MIDNIGHT = "402834815584e463015584e5390d0014";
}
