package com.flf.funny.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.flf.funny.R;
import com.flf.funny.service.config.Constants;
import com.tencent.smtt.sdk.WebView;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * return  具有分享和webView功能的Activity
 * description
 */

public class NewsInfoActivity extends AppCompatActivity {
    public static final String TAG = "NewsInfoActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.news_img)
    ImageView newImg;
    @BindView(R.id.fab_newsInfo)
    FloatingActionButton fab;
    @BindView(R.id.webView)
    WebView webView;
    String mUrl;
    String mTitle;
    String mImgurl;
    UMWeb web;
    public ShareAction shareAction;
    private UMShareListener mShareListener;
    private ShareAction mShareAction;
    private String mNewsDigest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();
        initData(extras);
        initView();
    }

    private void initData(Bundle extras) {
        mUrl = extras.getString(Constants.NEWS_INFO_URL);
        mImgurl = extras.getString(Constants.NEWS_IMAGE);
        mTitle = extras.getString(Constants.NEWS_TITLE);
        mNewsDigest = extras.getString(Constants.NEWS_DIGEST);
    }

    private void initView() {
        toolbar_title.setText(mTitle);
        webView.loadUrl(mUrl);
        Glide.with(this)
                .load(mImgurl)
                .centerCrop()
                .into(newImg);
        initShareData();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShare();     //打开分享面板
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //返回点击事件
                finish();
            }
        });

        Log.e(TAG, "initView: " + mUrl);
    }

    //准备要分享的类容
    private void initShareData() {
        UMImage image = new UMImage(NewsInfoActivity.this, mImgurl);//网络图片
        image.compressStyle = UMImage.CompressStyle.SCALE;   //图片普通压缩
        UMWeb web = new UMWeb(mUrl);
        web.setTitle(mTitle);//标题
        web.setThumb(image);  //缩略图
        web.setDescription(mNewsDigest);//描述
        mShareListener = new CustomShareListener(this);
        shareAction = new ShareAction(NewsInfoActivity.this)
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.SMS, SHARE_MEDIA.EMAIL)
                .withMedia(web)
                .setCallback(mShareListener);
    }

    //分享回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    //设置打开分享面板
    private void openShare() {

        shareAction.open();

    }

    //权限检查
    @Override
    public int checkSelfPermission(String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        return super.checkSelfPermission(permission);
    }

    /**
     * 屏幕横竖屏切换时避免出现window leak的问题
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        shareAction.close();
    }


    //友盟分享之后的回调
    private static class CustomShareListener implements UMShareListener {

        private WeakReference<NewsInfoActivity> mActivity;

        private CustomShareListener(NewsInfoActivity activity) {
            mActivity = new WeakReference(activity);
        }

        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
            Toast.makeText(mActivity.get(), platform + " 分享开始啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onResult(SHARE_MEDIA platform) {

            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(mActivity.get(), platform + " 收藏成功", Toast.LENGTH_SHORT).show();
            } else {
                if (platform == SHARE_MEDIA.SINA || platform == SHARE_MEDIA.QQ
                        || platform == SHARE_MEDIA.QZONE
                        || platform == SHARE_MEDIA.WEIXIN
                        || platform == SHARE_MEDIA.WEIXIN_CIRCLE
                        || platform == SHARE_MEDIA.SMS
                        || platform == SHARE_MEDIA.EMAIL) {
                    Toast.makeText(mActivity.get(), platform + " 分享成功", Toast.LENGTH_SHORT).show();
                }

            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (platform != SHARE_MEDIA.SINA && platform != SHARE_MEDIA.QQ
                    && platform != SHARE_MEDIA.QZONE
                    && platform != SHARE_MEDIA.WEIXIN
                    && platform != SHARE_MEDIA.WEIXIN_CIRCLE
                    && platform != SHARE_MEDIA.SMS
                    && platform != SHARE_MEDIA.EMAIL) {
                Toast.makeText(mActivity.get(), platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                if (t != null) {
                    com.umeng.socialize.utils.Log.d("throw", "throw:" + t.getMessage());
                }
            }

        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {

            Toast.makeText(mActivity.get(), platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    }
}
