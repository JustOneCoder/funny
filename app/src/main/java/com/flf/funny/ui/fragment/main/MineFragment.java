package com.flf.funny.ui.fragment.main;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.flf.funny.R;
import com.flf.funny.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者：Administrator
 * 时间：2017/4/10:12:10
 * 说明： 用户Fragment   相机   基本设置
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.img_mine)
    ImageView mImg;
    @BindView(R.id.toolbar_mine)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_layout_mine)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.app_bar_mine)
    AppBarLayout mAppBar;
    @BindView(R.id.item_cardview1)
    CardView mItemCardview1;
    @BindView(R.id.fab_mine)
    FloatingActionButton mFab;
    private PopupWindow mPopupWindow;


    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void initView() {
        mToolbar.setTitle("高富帅");
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });
    }

    private void initPopWindow(View view) {
        View photoSelect = View.inflate(mContext, R.layout.popwindow_pic_select, null);
        mPopupWindow = new PopupWindow(photoSelect, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation(view,0,0,0);

    }

}
