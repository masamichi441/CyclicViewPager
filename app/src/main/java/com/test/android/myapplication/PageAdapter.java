package com.test.android.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


final class PageAdapter extends FragmentPagerAdapter {

    private static final int NUM_PAGES = 3;

    PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return PageFragment.createInstance(NUM_PAGES - 1, position);
        }

        int count = getCount();
        if (position == (count - 1)) {
            return PageFragment.createInstance(0, position);
        }

        return PageFragment.createInstance(position - 1, position);
    }

    @Override
    public int getCount() {
        // Returns actual page number plus dummy pages of both sides.
        return NUM_PAGES + 2;
    }
}
