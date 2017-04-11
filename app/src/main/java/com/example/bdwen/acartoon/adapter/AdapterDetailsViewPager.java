package com.example.bdwen.acartoon.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class AdapterDetailsViewPager extends PagerAdapter{
    private List<PhotoView> photoViews;
    public AdapterDetailsViewPager(List<PhotoView> photoViews){
        this.photoViews=photoViews;
    }
    @Override
    public int getCount() {
        return photoViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PhotoView photoView = photoViews.get(position);
        container.addView(photoView);
        return photoView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(photoViews.get(position));
    }

    public PhotoView getPhotoView(int position) {
        PhotoView photoView = photoViews.get(position);
        return photoView;
    }
}
