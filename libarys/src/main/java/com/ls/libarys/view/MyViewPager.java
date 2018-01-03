package com.ls.libarys.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**

 * 类  名：MyViewPager
 * 描  述: 禁止滑动的viewpager
 */

public class MyViewPager extends ViewPager {

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public MyViewPager(Context context) {
        super(context);
    }



    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
            return false;
    }


}
