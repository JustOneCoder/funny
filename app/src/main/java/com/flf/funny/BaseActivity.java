package com.flf.funny;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.flf.funny.contract.base.BasePresenter;
import com.flf.funny.contract.base.BaseView;
import com.flf.funny.utils.StatusBarUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P> extends AppCompatActivity implements BaseView<P>{

    public Context mContext;
    private Unbinder mUnbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;
        mUnbinder = ButterKnife.bind(this);
        initData(savedInstanceState);
    }

    @Override
    public void bindUI(View rootView) {

    }

    @Override
    public P newP() {
        return null;
    }

    public abstract void initData(Bundle savedInstanceState);

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
