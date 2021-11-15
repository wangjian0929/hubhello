package com.feedAustralia.android.AdpatersPagers;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by asd on 04-02-2019.
 */

public class AMViewPager extends ViewPager {
    private boolean enabled;
    public AMViewPager(Context context) {
        super(context);
        this.enabled=false;
    }
    public AMViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled=false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (this.enabled) {
            return super.onTouchEvent(ev);
        }
        return false;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }
}

