package com.example.bdwen.acartoon.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.bdwen.acartoon.fragment.MyFragmentManager;

import java.util.List;

/**
 * Created by Administrator on 2017/3/20 0020.
 */

public class AdapterMainFragmentAdapter extends FragmentPagerAdapter {
    private static final String TAG = "AdapterMainFragmentAdap";
    private MyFragmentManager myFragmentManager;
    private String[] strings;

    public AdapterMainFragmentAdapter(FragmentManager fm, MyFragmentManager myFragmentManager, String[] strings) {
        super(fm);
        this.myFragmentManager = myFragmentManager;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return myFragmentManager.getFragment(position);
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
