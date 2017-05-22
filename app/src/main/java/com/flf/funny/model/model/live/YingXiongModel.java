package com.flf.funny.model.model.live;

import com.flf.funny.contract.NewsAndGameLiveContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.Live.LiveBaseBean;
import com.flf.funny.model.bean.Live.ResultBean;
import com.flf.funny.service.ApiServiceManager;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：Administrator
 * 时间：2017/5/11:11:15
 * 说明：英雄联盟数据加载model
 * http://api.maxjia.com/api/live/list/?currentIndex=0&&limit=10&&live_type=panda&&game_type=lol
 */

public class YingXiongModel extends NewsAndGameLiveContract.Model {

    private int currentIndex = 0;
    @Override
    public void refresh(int currentIndex, SingleObserver<ArrayList<BaseItem>> singleObserver) {
        ApiServiceManager.getInstence()
                .getGameLiveService()
                .getLiveList(0, 10, "douyu", "lol")
                .map(new Function<LiveBaseBean<ArrayList<ResultBean>>, ArrayList<ResultBean>>() {
                    @Override
                    public ArrayList<ResultBean> apply(LiveBaseBean<ArrayList<ResultBean>> listLiveBaseBean) throws Exception {
                        return listLiveBaseBean.getResult();
                    }
                })
                .flatMap(new Function<ArrayList<ResultBean>, Observable<ResultBean>>() {
                    @Override
                    public Observable<ResultBean> apply(ArrayList<ResultBean> resultBeen) throws Exception {
                        return Observable.fromIterable(resultBeen);
                    }
                })
                .map(new Function<ResultBean, BaseItem>() {
                    @Override
                    public BaseItem apply(ResultBean resultBean) throws Exception {
                        BaseItem<ResultBean> baseItem = new BaseItem<>();
                        baseItem.setData(resultBean);
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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(singleObserver);

    }

    @Override
    public void loadMore(int currentIndex, SingleObserver<ArrayList<BaseItem>> singleObserver) {

    }
}
