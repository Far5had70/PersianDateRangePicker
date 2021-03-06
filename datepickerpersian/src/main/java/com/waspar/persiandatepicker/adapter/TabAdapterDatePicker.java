package com.waspar.persiandatepicker.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.waspar.persiandatepicker.fragment.DateFragment;
import com.waspar.persiandatepicker.fragment.FromDateFragment;
import com.waspar.persiandatepicker.fragment.TillDateFragment;

public class TabAdapterDatePicker extends FragmentPagerAdapter {

    private int numOfTabs;

    public TabAdapterDatePicker(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DateFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

