package com.flf.funny;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.smtt.sdk.QbSdk;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * 作者：Administrator
 * 时间：2017/4/10:16:14
 * 说明：可以放置全局的方法h和变量
 */

public class FunnyApplication extends Application {



    public static FunnyApplication myApplication;//上下文
    public static Handler mHandler; //主线程的handler

    @Override
    public void onCreate() {//程序的入口方法
        super.onCreate();

        if (myApplication == null) {
            myApplication = this;
        }
        mHandler = new Handler();    //初始化主线程的一个handler
        UMShareAPI.get(this);           //初始化友盟
        QbSdk.initX5Environment(getContext(), null);//预加载腾讯浏览服务 X5 内核
        LeakCanary.install(this);//内存泄漏检测初始化
    }

    /**
     * 得到上下文对象
     *
     * @return
     */
    public static Context getContext() {
        return myApplication;
    }

    /**
     * 得到主线程handler对象
     *
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }

    /**
     * 获取应用的版本号
     *
     * @return 应用版本号，默认返回1
     */
    public static int getAppVersionCode() {
        Context context = getContext();
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    //友盟各个平台的配置
    {
        PlatformConfig.setWeixin("wx5c008d725d60e0c4", "2deb876a5e8045e4bf5bd9fb4e4182ad");  //已申请
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("2912530748", "a0d7c263353322ea8183934f70c63b17", "http://sns.whalecloud.com");//已申请
    }

}
