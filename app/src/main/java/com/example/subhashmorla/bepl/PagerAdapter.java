package com.example.subhashmorla.bepl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Subhash Morla on 1/13/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    public PagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                SmartBricks smartBricks=new SmartBricks();
                return smartBricks;

            case 1:
                Windows windows=new Windows();
                return windows;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "smartbricks";
        }
        else
            return "windows";

    }
}
