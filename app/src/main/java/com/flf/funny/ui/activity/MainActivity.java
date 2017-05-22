package com.flf.funny.ui.activity;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.flf.funny.BaseActivity;
import com.flf.funny.R;
import com.flf.funny.ui.base.BaseFragment;
import com.flf.funny.ui.fragment.NewsFragment;
import com.flf.funny.ui.fragment.main.GameLiveFragment;
import com.flf.funny.ui.fragment.main.MineFragment;
import com.flf.funny.ui.fragment.movie.MovieFragment;
import com.flf.funny.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    private static final String tab_title[] = {"新闻", "直播", "影院", "我的"};
    @BindView(R.id.bottom_navgation)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.main_view)
    FrameLayout mainView;


    private BaseFragment mCurrentFragment;
    private BaseFragment mNewsFragment;
    private BaseFragment mGameLiveFragment;
    private BaseFragment mMovieFragment;
    private BaseFragment mMineFragment;

    //返回MainActivity的布局
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    //加载数据
    @Override
    public void initData(Bundle savedInstanceState) {
        StatusBarUtils.transparencyBar(this);  //状态栏透明,同时状态栏高度被占用
        getWindow().setFormat(PixelFormat.TRANSLUCENT);        //
        initbottomNavigationBar();        //加载底部导航栏
        initView();
    }

    private void initView() {
        initFragment();
    }

    //主页初始化四个Fragment
    private void initFragment() {
        mNewsFragment = NewsFragment.newInstance();
        mGameLiveFragment = GameLiveFragment.newInstance();
        mMovieFragment = MovieFragment.newInstance();
        mMineFragment = MineFragment.newInstance();
        switchFragment(mNewsFragment);         //第一次启动,自动加载第一个Fragment
    }

    //初始化底部状态选择栏
    private void initbottomNavigationBar() {
        bottomNavigationBar.setAutoHideEnabled(false);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.drawable.news, tab_title[0]).setActiveColorResource(R.color.colorPrimaryDark))
                .addItem(new BottomNavigationItem(R.drawable.gamelive, tab_title[1]).setActiveColorResource(R.color.colorPrimaryDark))
                .addItem(new BottomNavigationItem(R.drawable.movie, tab_title[2]).setActiveColorResource(R.color.colorPrimaryDark))
                .addItem(new BottomNavigationItem(R.drawable.mine, tab_title[3]).setActiveColorResource(R.color.colorPrimaryDark))
                .setFirstSelectedPosition(0)
                .setTabSelectedListener(this)
                .initialise();
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                switchFragment(mNewsFragment);
                break;
            case 1:
                switchFragment(mGameLiveFragment);
                break;
            case 2:
                switchFragment(mMovieFragment);
                break;
            case 3:
                switchFragment(mMineFragment);
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    /**
     * return 切换Fragment
     * description 动态创建Fragment  不会重复创建Fragment
     * params 将要加载的fragment
     */

    private void switchFragment(BaseFragment toFragment) {
        FragmentManager fmManager = getSupportFragmentManager();
        if (mCurrentFragment != toFragment) {
            if (!toFragment.isAdded()) {      //判断是否曾经添加过,没有的话则添加一个Fragment
                if (mCurrentFragment != null) {
                    fmManager.beginTransaction()
                            .hide(mCurrentFragment)
                            .commit();
                }
                fmManager.beginTransaction()
                        .add(R.id.main_view, toFragment)
                        .commit();

            } else {
                fmManager.beginTransaction().hide(mCurrentFragment).show(toFragment).commit();
            }
        }
        mCurrentFragment = toFragment;

    }

}
