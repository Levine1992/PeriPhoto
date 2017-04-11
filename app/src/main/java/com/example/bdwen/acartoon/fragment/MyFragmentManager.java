package com.example.bdwen.acartoon.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2017/4/7 0007.
 * fragment管理者
 */

public class MyFragmentManager {
    /**
     * @param position 根据不同的position获取相应的fragment
     */
    public Fragment getFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Fragment1.getInstance();
                break;
            case 1:
                fragment = Fragment2.getInstance();
                break;
            case 2:
                fragment = Fragment3.getInstance();
                break;
            case 3:
                fragment = Fragment4.getInstance();
                break;
            case 4:
                fragment = Fragment5.getInstance();
                break;
            case 5:
                fragment = Fragment6.getInstance();
                break;
            case 6:
                fragment = Fragment7.getInstance();
                break;
            case 7:
                fragment = Fragment8.getInstance();
                break;
            case 8:
                fragment = Fragment9.getInstance();
                break;
        }
        return fragment;
    }

}
