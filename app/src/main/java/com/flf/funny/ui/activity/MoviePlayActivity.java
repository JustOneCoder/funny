package com.flf.funny.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.flf.funny.BaseActivity;
import com.flf.funny.R;
import com.flf.funny.service.config.Constants;
import com.shuyu.gsyvideoplayer.GSYVideoPlayer;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import butterknife.BindView;

/**
 * return     视频播放界面
 * description    有直接使用H5页面显示,或是集成ijkPlay进行播放
 */

public class MoviePlayActivity extends BaseActivity {

public static final String TAG = "MoviePlayActivity";
    @BindView(R.id.video_view)
    StandardGSYVideoPlayer mVideoPlayer;

    private String mMovieUrl;
    private OrientationUtils mOrientationUtils;

    @Override
    public void initData(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        mMovieUrl = getIntent().getStringExtra(Constants.MOVIE_PLAY_URL);
        analysisUrl();
        Log.e(TAG, "initData: "+mMovieUrl );
        initPlayer();
        initView();
    }

    //初始化播放器
    private void initPlayer() {
        mOrientationUtils = new OrientationUtils(this, mVideoPlayer);
        //初始化不打开外部的旋转
        mOrientationUtils.setEnable(false);

        mVideoPlayer.setIsTouchWiget(true);
        //detailPlayer.setIsTouchWigetFull(false);
        //关闭自动旋转
        mVideoPlayer.setRotateViewAuto(false);
        mVideoPlayer.setLockLand(false);
        mVideoPlayer.setShowFullAnimation(false);
        mVideoPlayer.setNeedLockFull(true);
        //detailPlayer.setOpenPreView(false);

        mVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                mOrientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                mVideoPlayer.startWindowFullscreen(MoviePlayActivity.this, true, true);
            }
        });

    }

    //解析播放数据
    private void analysisUrl() {

    }

    private void initView() {
        mVideoPlayer.setUp("http://58.135.196.138:8090/live/557a950d2cfcf2ee1aad5a260893c2b8/index.m3u8",false,null,"精品电影");

    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_movie_play;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoPlayer.releaseAllVideos();
        //GSYPreViewManager.instance().releaseMediaPlayer();
        if (mOrientationUtils != null)
            mOrientationUtils.releaseListener();
    }

}
