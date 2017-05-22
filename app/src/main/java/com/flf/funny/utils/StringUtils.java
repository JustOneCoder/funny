package com.flf.funny.utils;

/**
 * 作者：Administrator
 * 时间：2017/5/16:15:59
 * 说明：字符串相关工具集
 */

public class StringUtils {

    public static String stringConnect(String start,String end){
        StringBuilder builder = new StringBuilder();
        builder.append(start).append(end);
        return builder.toString();
    }
}
