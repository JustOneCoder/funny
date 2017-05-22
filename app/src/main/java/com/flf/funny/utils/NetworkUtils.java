package com.flf.funny.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.flf.funny.FunnyApplication;

import java.lang.reflect.Method;

/**
 * 作者：Administrator
 * 时间：2017/5/16:10:52
 * 说明：网络相关工具
 */

public class NetworkUtils {


    //获取正再活动的网络信息
    public static NetworkInfo getActiveNetInfo() {
        return ((ConnectivityManager) FunnyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
    }

    //判断网络是否连接
    public static boolean isNetConnected() {
        NetworkInfo netInfo = getActiveNetInfo();
        return netInfo != null && netInfo.isConnected();
    }

    //判断网络是否可用
    public static boolean isNetAvailable() {
        ShellUtils.CommandResult result = ShellUtils.execCmd("ping -c 1 -w 1 119.75.217.109", false);
        boolean ret = result.result == 0;          //
        if (result.errorMsg != null) {
            Log.e("isAvailableByPing errorMsg", result.errorMsg);
        }
        if (result.successMsg != null) {
            Log.e("isAvailableByPing successMsg", result.successMsg);
        }
        return ret;
    }

    //判断移动数据是否打开
    public static boolean getDataEnabled() {
        try {
            TelephonyManager tm = (TelephonyManager) FunnyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
            Method getMobileDataEnabledMethod = tm.getClass().getDeclaredMethod("getDataEnabled");
            if (null != getMobileDataEnabledMethod) {
                return (boolean) getMobileDataEnabledMethod.invoke(tm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

/**
 *return
 *description   需要添加权限<uses-permission android:name="android.permission.MODIFY_PHONE_STATE"/>
 */
    //打开或关闭移动数据
    public static void setDataEnabled(boolean enabled) {
        try {
            TelephonyManager tm = (TelephonyManager) FunnyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
            Method setMobileDataEnabledMethod = tm.getClass().getDeclaredMethod("setDataEnabled", boolean.class);
            if (null != setMobileDataEnabledMethod) {
                setMobileDataEnabledMethod.invoke(tm, enabled);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //判断wifi是否打开
    public static boolean getWifiEnabled() {
        WifiManager wifiManager = (WifiManager) FunnyApplication.getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }

    /**
     *return      打开或关闭wifi
     *description   <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
     */
    public static void setWifiEnabled(boolean enabled) {
        WifiManager wifiManager = (WifiManager) FunnyApplication.getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if (enabled) {
            if (!wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(true);
            }
        } else {
            if (wifiManager.isWifiEnabled()) {
                wifiManager.setWifiEnabled(false);
            }
        }
    }

    /**
     *return
     *description  获取网络运营商名称
     */
    public static String getNetworkOperatorName() {
        TelephonyManager tm = (TelephonyManager) FunnyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getNetworkOperatorName() : null;
    }

    /**
     *return     判断wifi是否连接
     *description
     */
    public static boolean isWifiConnected() {
        ConnectivityManager cm = (ConnectivityManager) FunnyApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;
    }

    //判断wifi连接是否可用
    public static boolean isWifiAvailable() {
        return getWifiEnabled() && isNetAvailable();
    }

    private static final int NETWORK_TYPE_GSM      = 16;
    private static final int NETWORK_TYPE_TD_SCDMA = 17;
    private static final int NETWORK_TYPE_IWLAN    = 18;

    //获取当前网络类型
    public static NetworkType getNetworkType() {
        NetworkType netType = NetworkType.NETWORK_NO;
        NetworkInfo info = getActiveNetInfo();
        if (info != null && info.isAvailable()) {

            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                netType = NetworkType.NETWORK_WIFI;
            } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                switch (info.getSubtype()) {

                    case NETWORK_TYPE_GSM:
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        netType = NetworkType.NETWORK_2G;
                        break;

                    case NETWORK_TYPE_TD_SCDMA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        netType = NetworkType.NETWORK_3G;
                        break;

                    case NETWORK_TYPE_IWLAN:
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        netType = NetworkType.NETWORK_4G;
                        break;
                    default:

                        String subtypeName = info.getSubtypeName();
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA")
                                || subtypeName.equalsIgnoreCase("WCDMA")
                                || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            netType = NetworkType.NETWORK_3G;
                        } else {
                            netType = NetworkType.NETWORK_UNKNOWN;
                        }
                        break;
                }
            } else {
                netType = NetworkType.NETWORK_UNKNOWN;
            }
        }
        return netType;
    }
    public enum NetworkType {
        NETWORK_WIFI,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

}
