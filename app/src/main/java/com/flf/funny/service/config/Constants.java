package com.flf.funny.service.config;

/**
 * 作者：Administrator
 * 时间：2017/4/15:50:20
 * 说明：
 */
public class Constants {
    public static final String CATALOGID = "catalogId";
    public static final String MOVIE_PLAY_H5_URL = "playUrl";    //视频播放H5,key
    public static final String MOVIE_MOREURL = "movie_more_url";
    public static final String NEWS_TITLE = "newsTitle";   //movie界面点击更多带给MovieMoreInfoActivity的数据的intent的key
    public static final String NEWS_INFO_URL = "newsInfo";
    public static final String NEWS_IMAGE = "newsImg";
    public static final String NEWS_DIGEST = "news_digest";
    public static final String MOVIE_PLAY_URL = "movie_play_url";
    //NetWork Erro
    public static String ERRO = "错误信息:";
    //SecretUtil
    public static String NOSUCHALGORITHM = "不支持此种加密方式";
    public static String UNSUPPENCODING = "不支持的编码格式";
    /**
     * SharePreference
     */
    public static final String SP_NAME = "com.pandaq.pandaeye";
    /**
     * BundleKey
     */
    public static final String BUNDLE_KEY_TITLE = "title";//bundle传至用的key各处可以复用
    public static final String BUNDLE_KEY_ID = "id";
    public static final String BUNDLE_KEY_IMG_URL = "img_url";
    public static final String BUNDLE_KEY_TRANSLATION_EXPORD = "expord";//转场动画是否为expord类型
    public static final String BUNDLE_KEY_DATAID = "dataId";
    /**
     * DiskCache
     */
    public static final long CACHE_MAXSIZE = 10 * 1024 * 1024;
    public static final String CACHE_NEWS_FILE = "top_news_cache_file";
    public static final String CACHE_HEADLINE_NEWS = "headline_news_cache";
    public static final String CACHE_TEC_NEWS = "tec_news_cache";
    public static final String CACHE_SPORT_NEWS = "sport_news_cache";
    public static final String CACHE_RECOMMEND_NEWS = "recommend_news_cache";
    public static final String CACHE_CARTOON_NEWS = "cartoon_news_cache";
    public static final String CACHE_MILITARY_NEWS = "military_news_cache";
    public static final String CACHE_TRAVEL_NEWS = "travel_news_cache";

    public static final String CACHE_ZHIHU_FILE = "zhihu_cache_file";
    public static final String CACHE_ZHIHU_DAILY = "zhihu_daily_cache";

    public static final String CACHE_DOUBAN_FILE = "douban_cache_file";
    public static final String CACHE_DOUBAN_MOVIE = "douban_movie_cache";

    public static final String CACHE_VIDEO_FILE = "video_cache_file";
    public static final String CACHE_VIDEO = "video_cache";

    /**
     * video
     */

    public static int getViewType(String viewType) {
        if (viewType.contains("banner")) {
            return 1;
        } else if (viewType.contains("IN")) {
            return 2;
        }
        return 2;
    }

    public static final String SHOW_TYPE_IN = "IN";                //电影类型
    public static final String SHOW_TYPE_BANNER = "banner";       //顶部ViewPager
    public static final String TYPED_MORE_TITLE = "videoType";
    //热点资讯
    public static final String MOVIE_TYPE_HOT = "热点资讯";
    //精彩推荐
    public static final String MOVIE_TYPE_RECOMMEND = "精彩推荐";
    //好莱坞
    public static final String MOVIE_TYPE_HOLLYWOOD = "好莱坞";
    //专题 根据当前时间戳获取
    public static final String MOVIE_TYPE_TOPIC = "专题";
    //直播专区
    public static final String MOVIE_TYPE_LIVE = "直播专区";
    //微电影
    public static final String MOVIE_TYPE_LITTLEMOVIE = "微电影";
    //日韩精选
    public static final String MOVIE_TYPE_JSKS = "日韩精选";
    //大咖剧场
    public static final String MOVIE_TYPE_BIGBRO = "大咖剧场";
    //午夜剧场
    public static final String MOVIE_TYPE_MIDNIGHT = "午夜剧场";

    /**
     * 设置
     */
    public static final String USER_PIC = "/pandaeye/images";
    /**
     * 网易新闻
     */
    public static final String NETEASY_NEWS_HEADLINE = "T1348647909107";//头条
    public static final String NETEASY_NEWS_TEC = "T1348649580692";//科技
    public static final String NETEASY_NEWS_SPORT = "T1348649079062";//体育
    public static final String NETEASY_NEWS_HEALTH = "T1414389941036";//健康
    public static final String NETEASY_NEWS_DADA = "T1350383429665";//轻松一刻
    public static final String NETEASY_NEWS_MILITARY = "T1348648141035";//军事
    public static final String NETEASY_NEWS_TRAVEL = "T1348654204705";//旅游




}
