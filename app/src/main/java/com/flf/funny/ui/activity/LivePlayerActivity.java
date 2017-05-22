package com.flf.funny.ui.activity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.flf.funny.BaseActivity;
import com.flf.funny.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * return   直播播放界面
 * description
 */

public class LivePlayerActivity extends BaseActivity {


    @BindView(R.id.surfaceview)
    SurfaceView mSurfaceview;
    @BindView(R.id.progressbar)
    FrameLayout mProgressbar;
    @BindView(R.id.iv_back_landscape)
    ImageView mIvBackLandscape;
    @BindView(R.id.tv_roomname_landscape)
    TextView mTvRoomnameLandscape;
    @BindView(R.id.btn_stream_1080p_landscape)
    Button mBtnStream1080pLandscape;
    @BindView(R.id.btn_stream_360p_landscape)
    Button mBtnStream360pLandscape;
    @BindView(R.id.iv_play_pause_landscape)
    ImageView mIvPlayPauseLandscape;
    @BindView(R.id.iv_refresh_landscape)
    ImageView mIvRefreshLandscape;
    @BindView(R.id.btn_send_landscape)
    Button mBtnSendLandscape;
    @BindView(R.id.iv_fullscreen_exit_landscape)
    ImageView mIvFullscreenExitLandscape;
    @BindView(R.id.layout_landscape)
    RelativeLayout mLayoutLandscape;
    @BindView(R.id.iv_back_portrait)
    ImageView mIvBackPortrait;
    @BindView(R.id.iv_fullscreen_portrait)
    ImageView mIvFullscreenPortrait;

    @Override
    public int getLayoutId() {
        return R.layout.activity_live_player;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
