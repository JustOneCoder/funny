package com.flf.funny.model.model.news;

import com.flf.funny.contract.NewsAndGameLiveContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.news.HealthNewsList;
import com.flf.funny.model.bean.news.NewsBean;
import com.flf.funny.service.ApiServiceManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：Administrator
 * 时间：2017/4/28:13:01
 * 说明：新闻头条model
 * url = "http://c.m.163.com/nc/article/list/T1348647909107/0-10.html?index=0";
 */

public class NewsHealthModel extends NewsAndGameLiveContract.Model {

    public static final String TAG = "NewsHealthModel";

    //下拉刷新
    @Override
    public void refresh(int currentIndex, SingleObserver<ArrayList<BaseItem>> singleObserver) {
        ApiServiceManager.getInstence()
                .getNewsApiServie()
                .getRecommendNews(currentIndex + "")
                .map(new Function<HealthNewsList, ArrayList<NewsBean>>() {
                    @Override
                    public ArrayList<NewsBean> apply(HealthNewsList healthNewsList) {
                        return healthNewsList.getRecNewsArrayList();
                    }
                })
                .flatMap(new Function<ArrayList<NewsBean>, Observable<NewsBean>>() {
                    @Override
                    public Observable<NewsBean> apply(ArrayList<NewsBean> topNewses) throws Exception {
                        return Observable.fromIterable(topNewses);
                    }
                })
                .filter(new Predicate<NewsBean>() {
                    @Override
                    public boolean test(NewsBean topNews) throws Exception {
                        return topNews.getUrl() != null;
                    }
                })
                .map(new Function<NewsBean, BaseItem>() {
                    @Override
                    public BaseItem apply(NewsBean topNews) {
                        BaseItem<NewsBean> baseItem = new BaseItem<>();
                        baseItem.setData(topNews);
                        return baseItem;
                    }
                })
                .toList()
                //将 List 转为ArrayList 缓存存储 ArrayList Serializable对象
                .map(new Function<List<BaseItem>, ArrayList<BaseItem>>() {
                    @Override
                    public ArrayList<BaseItem> apply(List<BaseItem> baseItems) {
                        ArrayList<BaseItem> items = new ArrayList<>();
                        items.addAll(baseItems);
                        return items;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(singleObserver);
    }


    //上划加载更多
    @Override
    public void loadMore(int currentIndex, SingleObserver<ArrayList<BaseItem>> singleObserver) {
        ApiServiceManager.getInstence()
                .getNewsApiServie()
                .getRecommendNews(currentIndex + "")
                .map(new Function<HealthNewsList, ArrayList<NewsBean>>() {
                    @Override
                    public ArrayList<NewsBean> apply(HealthNewsList recommendNewsList) {
                        return recommendNewsList.getRecNewsArrayList();
                    }
                })
                .flatMap(new Function<ArrayList<NewsBean>, Observable<NewsBean>>() {
                    @Override
                    public Observable<NewsBean> apply(ArrayList<NewsBean> topNewses) throws Exception {
                        return Observable.fromIterable(topNewses);
                    }
                })
                .filter(new Predicate<NewsBean>() {
                    @Override
                    public boolean test(NewsBean topNews) throws Exception {
                        return topNews.getUrl() != null;
                    }
                })
                .map(new Function<NewsBean, BaseItem>() {
                    @Override
                    public BaseItem apply(NewsBean topNews) {
                        BaseItem<NewsBean> baseItem = new BaseItem<>();
                        baseItem.setData(topNews);
                        return baseItem;
                    }
                })
                .toList()
                //将 List 转为ArrayList 缓存存储 ArrayList Serializable对象
                .map(new Function<List<BaseItem>, ArrayList<BaseItem>>() {
                    @Override
                    public ArrayList<BaseItem> apply(List<BaseItem> baseItems) {
                        ArrayList<BaseItem> items = new ArrayList<>();
                        items.addAll(baseItems);
                        return items;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(singleObserver);
    }
}
