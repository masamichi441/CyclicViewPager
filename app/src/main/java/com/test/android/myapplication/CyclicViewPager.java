package com.test.android.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;


public final class CyclicViewPager extends ViewPager {

    public CyclicViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        PageChangeListener listener = new PageChangeListener();
        addOnPageChangeListener(listener);
    }

    private class PageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

        @Override
        public void onPageSelected(int position) { }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state != SCROLL_STATE_IDLE) {
                return;
            }

            PagerAdapter adapter = getAdapter();
            if (adapter == null) {
                return;
            }

            int count = adapter.getCount();
            int currentItem = getCurrentItem();

            if (currentItem == 0) {
                // Top page
                setCurrentItem(count - 2, false);
                return;
            }

            if (currentItem == (count - 1)) {
                // Last page
                setCurrentItem(1, false);
            }
        }
    }
}
