package com.example.administrator.wangye_2017_8_25.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/8/21.
 */

public class MyBlankAdapter extends FragmentPagerAdapter {
    public MyBlankAdapter(FragmentManager fm) {
        super(fm);
    }
    private List<Fragment> list ;


    public void setFragment(List<Fragment> lists ){
        list = lists;

    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = list.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}