package com.flf.funny.ui.fragment.movie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.flf.funny.R;
import com.flf.funny.adapter.AutoViewPagerAdapter;
import com.flf.funny.adapter.MovieRecyclerAdapter;
import com.flf.funny.contract.MovieContract;
import com.flf.funny.model.bean.BaseItem;
import com.flf.funny.model.bean.movie.ListBean;
import com.flf.funny.presenter.movie.MoviePresenter;
import com.flf.funny.service.config.Constants;
import com.flf.funny.ui.activity.MoviePlayActivity;
import com.flf.funny.ui.base.BaseFragment;
import com.flf.funny.widget.MovieRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;


/**
 * 作者：Administrator
 * 时间：2017/4/10:12:37
 * 说明： 影院界面
 */
public class MovieFragment extends BaseFragment implements MovieContract.View {
    public static final String TAG = "MovieFragment";
    @BindView(R.id.UltimateRecyclerView_movie)
    UltimateRecyclerView mFunnyRecyclerView;
    @BindView(R.id.auto_viewPager)
    AutoScrollViewPager mAutoViewPager;
    public MovieRecyclerAdapter movieHomeAdapter;
    private AutoViewPagerAdapter mPagerAdapter;
    public ArrayList<BaseItem> mBaseItems;
    private ArrayList<ListBean> value;
    private List<ListBean.ChildListBean> mPagerNumList;


    public static MovieFragment newInstance() {
        Bundle args = new Bundle();
        MovieFragment fragment = new MovieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initView() {
        mBaseItems = new ArrayList<BaseItem>();
        initHeadViewPager();
        mFunnyRecyclerView.setHasFixedSize(true);
        mFunnyRecyclerView.enableDefaultSwipeRefresh(false);
        //mFunnyRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        mFunnyRecyclerView.setLayoutManager(linearLayoutManager);
        refreshData();

    }

    //初始化顶部ViewPager
    private void initHeadViewPager() {
        mAutoViewPager.startAutoScroll(); //启动自动滚动
        mAutoViewPager.setScrollDurationFactor(2);   //设置切图动画过度的速度的倍率
        mAutoViewPager.setInterval(2000);
        //设置成无限循环的样子
        //mAutoViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mPagerNumList.size());
        mAutoViewPager.setOnClickListener(new AutoScrollViewPager.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MoviePlayActivity.class));
            }
        });
    }


    @Override
    public void initData(Bundle savedInstanceState) {
        //下拉刷新
        mFunnyRecyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

    }





    //顶部ViewPager点击事件,跳转视频播放界面

    //更多点击事件,携带数据,跳转到展示多部视频的activity


    private void refreshData() {
        newP().setRefresh();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    public MoviePresenter newP() {
        return new MoviePresenter(this);
    }

    /**
     * return   展示电影界面的数据,返回电影首页所有数据
     * description
     * ListBean.getList  [0]   视频界面顶部ViewPager的六张图片和点击详情    banner
     * ListBean.getList  [1]
     * ListBean.getList  [2]
     * <p>
     * ListBean.getList  [3]     电影列表展示
     * ListBean.getList  [4]
     */
    @Override
    public void showMovie(ArrayList<ListBean> value) {
        mFunnyRecyclerView.setRefreshing(false);
        this.value = value;
        //设置顶部ViewPaer数据
        ListBean listBean = value.get(0);
        mPagerNumList = listBean.getChildList();

        String showType = listBean.getShowType();
        if (Constants.SHOW_TYPE_BANNER.equals(showType)) { //判断是否为 banner
            if (mPagerAdapter == null) {
                mPagerAdapter = new AutoViewPagerAdapter(mContext, mPagerNumList);
                mAutoViewPager.setAdapter(mPagerAdapter);

            }
            value.remove(listBean);
        }


        //底部电影类别数据
        mBaseItems.clear();
        for (ListBean bean : value) {
            if (!bean.getTitle().equals("直播专区") && !bean.getTitle().equals("专题")) {
                BaseItem<ListBean> baseItem = new BaseItem<>();
                baseItem.setData(bean);
                mBaseItems.add(baseItem);
            }
                movieHomeAdapter = new MovieRecyclerAdapter(mContext, mBaseItems);
                mFunnyRecyclerView.setAdapter(movieHomeAdapter);
        }
    }

    @Override
    public void showError() {

    }


}

