package com.flf.funny.model.model;

import com.flf.funny.contract.MovieContract;
import com.flf.funny.model.bean.movie.ListBean;
import com.flf.funny.model.bean.movie.MovieResponseListBean;
import com.flf.funny.model.bean.movie.MovieResponseRetBean;
import com.flf.funny.service.ApiServiceManager;
import com.flf.funny.service.config.Constants;

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
 * 说明：url = "http://api.svipmovie.com/front/homePageApi/homePage.do";
 */

public class MovieModel extends MovieContract.Model {

    public static final String TAG = "MovieModel";

    //下拉刷新
    @Override
    public void refresh(SingleObserver<ArrayList<ListBean>> singleObserver) {
        //使用RxJava和Retrofit进行网络请求
        ApiServiceManager.getInstence()
                .getMovieService()
                .getMovie()
                .flatMap(new Function<MovieResponseListBean<MovieResponseRetBean>, Observable<ListBean>>() {
                    @Override
                    public Observable<ListBean> apply(MovieResponseListBean<MovieResponseRetBean> response) {
                        return Observable.fromIterable(response.getData().getList());
                    }
                })
                //去广告
                .filter(new Predicate<ListBean>() {
                    @Override
                    public boolean test(ListBean listBean) throws Exception {
                        String showType = listBean.getShowType();
                        //只返回顶部ViewPager的数据和下面电影分类集合的数据
                        return Constants.SHOW_TYPE_IN.equals(showType) || Constants.SHOW_TYPE_BANNER.equals(showType);
                    }
                })
                .toList()
                //将 List 转为ArrayList 缓存存储 ArrayList Serializable对象
                .map(new Function<List<ListBean>, ArrayList<ListBean>>() {
                    @Override
                    public ArrayList<ListBean> apply(List<ListBean> listBeen) {
                        ArrayList<ListBean> arr = new ArrayList<ListBean>();
                        arr.addAll(listBeen);
                        //DiskCacheManager manager = new DiskCacheManager(CustomApplication.getContext(), Constants.CACHE_VIDEO_FILE);
                        //manager.put(Constants.CACHE_VIDEO, arr);
                        return arr;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(singleObserver);
    }
}
