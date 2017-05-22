package com.flf.funny.utils;

import android.app.Activity;
import android.view.WindowManager;

import com.tencent.smtt.sdk.TbsVideo;

/**
 * 作者：Administrator
 * 时间：2017/5/15:15:53
 * 说明：
 */

public class TencentWebViewUtils {

      static void webViewPlay(Activity activity){
          activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
          TbsVideo.canUseTbsPlayer(activity);
          //TbsVideo.openVideo(activity);
      }
}
