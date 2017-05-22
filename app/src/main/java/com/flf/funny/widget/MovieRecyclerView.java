package com.flf.funny.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

/**
 * 作者：Administrator
 * 时间：2017/5/21:20:46
 * 说明： 实现事件的拦截或分发,解决MovieFragment中的RecyclerView的嵌套点击事件问题
 */

public class MovieRecyclerView extends UltimateRecyclerView {

    public MovieRecyclerView(Context context) {
        super(context);
    }

    public MovieRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                //如果你觉得需要拦截
                return true ;
            case MotionEvent.ACTION_MOVE:
                //如果你觉得需要拦截
                return super.onInterceptTouchEvent(ev) ;
            case MotionEvent.ACTION_UP:
                //如果你觉得需要拦截
                return true ;
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                //如果你觉得需要拦截
                return true ;
            case MotionEvent.ACTION_MOVE:
                //如果你觉得需要拦截
                return super.onTouchEvent(ev) ;
            case MotionEvent.ACTION_UP:
                //如果你觉得需要拦截
                return true ;
        }

        return false;
    }
}
