package com.flf.funny.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.flf.funny.BaseActivity;
import com.flf.funny.R;
import com.flf.funny.adapter.MovieMoreRecyclerAdapter;
import com.flf.funny.contract.MovieMoreContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.moviemore.ListBean;
import com.flf.funny.presenter.movie.MovieMorePresenter;
import com.flf.funny.service.config.Constants;
import com.marshalchen.ultimaterecyclerview.ItemTouchListenerAdapter;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.List;

import butterknife.BindView;

/**
 * return     展示更多电影条目的Activity
 * description     recyclerView   下拉加载   沉浸式布局
 */

public class MovieMoreActivity extends BaseActivity implements MovieMoreContract.View, UltimateRecyclerView.OnLoadMoreListener, View.OnClickListener {

    public static final String TAG = "MovieMoreActivity";
    @BindView(R.id.movie_more_head_img)
    ImageView mHeadImg;
    @BindView(R.id.toolbar_movie_more)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout_movie_more)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.app_bar_movie_more)
    AppBarLayout mAppBar;
    @BindView(R.id.UltimateRecyclerView_movie_more)
    UltimateRecyclerView mUltimateRecyclerView;
    private String mMovieMoreType;
    private String mMoreUrl;
    private List<BaseItem> value;
    private String mCatalogId;
    private boolean firstLoad = true;


    private void initView() {
        mUltimateRecyclerView.setOnLoadMoreListener(this);      //返回键点击事件
        mToolbar.setNavigationOnClickListener(this);
        mUltimateRecyclerView.reenableLoadmore();
        mUltimateRecyclerView.setNestedScrollingEnabled(false);
        mUltimateRecyclerView.setLoadMoreView(R.layout.custom_loadmore_progressbar);
        LoadMoreData();

        //第一次打开页面自动进行数据加载


    }

    //加载数据
    private void LoadMoreData() {
        newP().setLoadMore();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        mMovieMoreType = getIntent().getStringExtra(Constants.TYPED_MORE_TITLE);
        mMoreUrl = getIntent().getStringExtra(Constants.MOVIE_MOREURL);  //这个就是电影类型详情
        mCatalogId = mMoreUrl.substring(mMoreUrl.indexOf("=") + 1);
        initView();
        initItemClick();
    }

    //条目点击之后跳转到视频播放界面
    private void initItemClick() {
        String s = "c5d337a6b560056d99e37dfaf2d554cd";
        mUltimateRecyclerView.mRecyclerView.addOnItemTouchListener(new ItemTouchListenerAdapter(mUltimateRecyclerView.mRecyclerView,
                new ItemTouchListenerAdapter.RecyclerViewOnItemClickListener() {
                    @Override
                    public void onItemClick(RecyclerView parent, View clickedView, int position) {

                        if (position<value.size()) {
                            ListBean bean = (ListBean) value.get(position).getData();
                            String loadURL = bean.getLoadURL();    //视频播放Activity的所有数据
                            //String h5URL = bean.getShareURL();    //视频播放Activity的H5地址
                            Log.e(TAG, "onItemClick: " + loadURL);
                            Intent intent = new Intent(mContext, MoviePlayActivity.class);
                            intent.putExtra(Constants.MOVIE_PLAY_URL, loadURL);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onItemLongClick(RecyclerView parent, View clickedView, int position) {

                    }
                }));
    }


    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_movie_more_info;
    }

    @Override
    public MovieMorePresenter newP() {
        return new MovieMorePresenter(this, mCatalogId);
    }


    //展示数据
    @Override
    public void showLoadMoreData(List<BaseItem> value) {
        this.value = value;
       mToolbar.setTitle(mMovieMoreType);
        Glide.with(this)
                .load(((ListBean) (value.get(0).getData())).getPic())
                .centerCrop()
                .into(mHeadImg);
        Log.e(TAG, "showLoadMoreData7777777: "+mMovieMoreType );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        linearLayoutManager.setAutoMeasureEnabled(true);
        mUltimateRecyclerView.setLayoutManager(linearLayoutManager);
        if (firstLoad) {
            firstLoad = false;
            mUltimateRecyclerView.setAdapter(new MovieMoreRecyclerAdapter(this, value));
        }else{
            //将数据添加到原来的集合下面
            new MovieMoreRecyclerAdapter(this).appendToList(value);
        }
    }

    @Override
    public void showError() {

    }

    //下拉加载
    @Override
    public void loadMore(int itemsCount, int maxLastVisiblePosition) {
        LoadMoreData();
    }

    //底部显示没有更多的布局文件提示用户
    public void noMoreMovie() {
        Log.e(TAG, "noMoreMovie: "+"执行了没" );
        mUltimateRecyclerView.setLoadMoreView(R.layout.item_no_more);
        new MovieMoreRecyclerAdapter(this).notifyDataSetChanged();
    }

}
