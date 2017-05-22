package com.flf.funny.ui.base;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.flf.funny.R;
import com.flf.funny.adapter.BaseRecyclerViewAdapter;
import com.flf.funny.contract.NewsAndGameLiveContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.news.NewsBean;
import com.flf.funny.service.config.Constants;
import com.flf.funny.ui.activity.LivePlayerActivity;
import com.flf.funny.ui.activity.NewsInfoActivity;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import jp.wasabeef.recyclerview.animators.OvershootInRightAnimator;

/**
 * 作者：Administrator
 * 时间：2017/4/10:18:08
 * 说明：所有pagerFragment的基类,下拉刷新,加载更多,懒加载,列表页
 */

public abstract class BasePagerFragment<P extends NewsAndGameLiveContract.Presenter> extends BaseFragment<P> {

    public static final String TAG = "BasePagerFragment";
    ArrayList<BaseItem> baseItemList;
    @BindView(R.id.funny_recycler_view)
    public CustomUltimateRecyclerview mFunnyRecyclerView;
    public BaseRecyclerViewAdapter mAdapter;
    public boolean isVisible;
    public boolean firstChild;
    public boolean firstRefresh = true;
    StoreHouseHeader storeHouseHeader;


    @Override
    public void initView() {
        if (firstChild() && firstRefresh) {   //如果是第一次进来默认自动刷新第一个子Fragment
            firstRefreshData();
        }

        initRecyclierView();
        initItemClick();//初始化条目点击事件

    }

    private void initRecyclierView() {
        setLayoutManager(mFunnyRecyclerView);//设置mFunnyRecyclerView的layoutManager
        mFunnyRecyclerView.setHasFixedSize(true); //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mFunnyRecyclerView.setCustomSwipeToRefresh();
        mFunnyRecyclerView.reenableLoadmore();//开启上拉加载更多
        mFunnyRecyclerView.setLoadMoreView(R.layout.custom_loadmore_progressbar);
        storeHouseHeader = new StoreHouseHeader(mContext);
        storeHouseHeader.initWithString("loading");
        mFunnyRecyclerView.mPtrFrameLayout.setHeaderView(storeHouseHeader);
        mFunnyRecyclerView.mPtrFrameLayout.addPtrUIHandler(storeHouseHeader);
        mFunnyRecyclerView.mPtrFrameLayout.autoRefresh(false);
        mFunnyRecyclerView.setAdapter(getAdapter());
    }

    public void initItemClick() {
        mFunnyRecyclerView.mRecyclerView.addOnItemTouchListener(new ItemTouchListenerAdapter(mFunnyRecyclerView.mRecyclerView,
                new ItemTouchListenerAdapter.RecyclerViewOnItemClickListener() {
                    @Override
                    public void onItemClick(RecyclerView parent, View clickedView, int position) {
                        //新闻界面点击事件
                        if (getNewsOrLive()) {   //直播
                            //跳转到直播播放界面
                            startActivity(new Intent(mContext, LivePlayerActivity.class));

                        } else {    //新闻
                            if (position < baseItemList.size()) {
                                NewsBean newsBean = (NewsBean) baseItemList.get(position).getData();
                                Bundle bundle = new Bundle();
                                bundle.putString(Constants.NEWS_TITLE, newsBean.getTitle());
                                bundle.putString(Constants.NEWS_INFO_URL, newsBean.getUrl());
                                bundle.putString(Constants.NEWS_IMAGE, newsBean.getImgsrc());
                                bundle.putString(Constants.NEWS_DIGEST, newsBean.getDigest());
                                Intent intent = new Intent(mContext, NewsInfoActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        }
                    }

                    @Override
                    public void onItemLongClick(RecyclerView parent, View clickedView, int position) {

                    }
                }));

    }

    //判断是新闻还是直播   true表示直播
    public boolean getNewsOrLive() {
        return false;
    }

    public boolean firstChild() {
        firstChild = false;
        return firstChild;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        //下拉加载
        mFunnyRecyclerView.mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                boolean canbePullDown = PtrDefaultHandler.checkContentCanBePulledDown(ptrFrameLayout, view, view2);
                return canbePullDown;
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                refreshData();

            }
        });

        mFunnyRecyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, int maxLastVisiblePosition) {
                loadMoreData();
            }
        });

    }

    //设置用户可见才加载(懒加载)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint() && firstRefresh) {  //第一次可见并且第一次刷新,自动刷新,以后都是手动刷新
            isVisible = true;      //用户可见
            firstRefreshData();
        } else {
            isVisible = false;     //不可见
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_pager_base;
    }

    //设置自己界面的布管理器
    protected abstract void setLayoutManager(UltimateRecyclerView mFunnyRecyclerView);

    //子类重写创建自己的adapter
    protected abstract BaseRecyclerViewAdapter createAdapter();

    //数据的加载
    protected void loadMoreData() {
        getP().setLoadMore();
    }

    //数据的刷新
    protected void refreshData() {
        getP().setRefresh();
        Log.e(TAG, "refreshData: " + "刷新数据" + getP());
    }


    //获取对应adapter
    public BaseRecyclerViewAdapter getAdapter() {
        if (mAdapter == null) {
            mAdapter = createAdapter();
        }
        return mAdapter;


    }

    //第一次刷新数据的条件:页面第一次可见
    public void firstRefreshData() {
        if (firstRefresh && mFunnyRecyclerView != null) {
            baseItemList = new ArrayList<>();
            refreshData();
            firstRefresh = false;
        }
    }

    //展示刷新之后的数据
    public void showRefreshData(ArrayList<BaseItem> value) {
        mFunnyRecyclerView.mPtrFrameLayout.refreshComplete();
        baseItemList.addAll(value);

        getAdapter().appendToTopList(value);
    }

    //展示加载更多的数据
    public void showLoadMoreData(ArrayList<BaseItem> value) {
        baseItemList.addAll(value);
        getAdapter().appendToList(value);
    }


    //各种可能,网络错误,解析错误,数据为空等等
    public void showError(Throwable e) {

    }

}
