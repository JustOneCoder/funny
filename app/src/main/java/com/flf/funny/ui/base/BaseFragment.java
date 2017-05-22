package com.flf.funny.ui.base;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.flf.funny.contract.base.BasePresenter;
import com.flf.funny.contract.base.BaseView;
import com.flf.funny.service.config.disklrucache.DiskCacheManager;
import com.flf.funny.utils.KnifeKit;
import com.flf.funny.utils.StatusBarUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Administrator
 * 时间：2017/4/10:11:49
 * 说明：所有Fragment的基类
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView<P> {


    public Activity mContext;
    public View rootView;
    public Unbinder mUnbinderm;
    private P p;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutId(), container, false);
        bindUI(rootView);
        initView();           //初始化视图
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData(savedInstanceState); //MainActivity创建完成就加载数据
        super.onActivityCreated(savedInstanceState);


    }

    //返回对应Fragmeng的布局文件
    @Override
    public abstract int getLayoutId();


    public void initView() {
    }


    @Override
    public void bindUI(View rootView) {
        //mUnbinderm = KnifeKit.bind(this,rootView);
        mUnbinderm = ButterKnife.bind(this, rootView);

    }

    //加载数据
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onPause() {
        super.onPause();
        //同步 DiskCache 的缓存日志
        DiskCacheManager.flush();
    }

    //获取所依附的Activity,就是context
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.mContext = (Activity) context;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinderm.unbind();
    }

    protected P getP() {
        if (p == null) {
            p = newP();
        }
        return p;
    }

}
