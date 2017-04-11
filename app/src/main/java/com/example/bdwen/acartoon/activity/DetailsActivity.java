package com.example.bdwen.acartoon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bdwen.acartoon.R;
import com.example.bdwen.acartoon.adapter.AdapterDetailsViewPager;
import com.example.bdwen.acartoon.bean.B2;
import com.example.bdwen.acartoon.p.P2;
import com.example.bdwen.acartoon.utils.ScreenUtils;
import com.example.bdwen.acartoon.v.VI2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Administrator on 2017/4/10 0010.
 * 详情
 */

public class DetailsActivity extends BaseActivity implements VI2, PhotoViewAttacher.OnPhotoTapListener {
    private static final String TAG = "DetailsActivity";
    @BindView(R.id.activity_details_vp)
    ViewPager activityDetailsVp;
    @BindView(R.id.activity_details_tv_indicate)
    TextView activityDetailsTvIndicate;
    @BindView(R.id.view_status_tv)
    TextView viewStatusTv;
    @BindView(R.id.view_progressbar_pb)
    ProgressBar viewProgressbarPb;
    private P2 p2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setStatusBar(this, false);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        init();
    }

    @Override
    public void init() {
        p2 = new P2(this);
        Intent intent = getIntent();
        if (intent != null) {
            String id = intent.getExtras().getString("id");
            p2.getDetauls(id);
        }
        viewStatusTv.getLayoutParams().height = ScreenUtils.getStatusHeight(this);
        viewStatusTv.setBackgroundColor(getResources().getColor(R.color.opacity_0_black_20));
        viewStatusTv.bringToFront();
    }

    @Override
    public void iniView() {

    }

    @Override
    public void showLoading() {
        activityDetailsVp.setVisibility(View.GONE);
        viewProgressbarPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        activityDetailsVp.setVisibility(View.VISIBLE);
        viewProgressbarPb.setVisibility(View.GONE);
    }

    @Override
    public void error(Throwable t) {

    }

    @Override
    public void showData(B2 b2) {
        final List<String> imgList = b2.getShowapi_res_body().getImgList();
        final List<PhotoView> photoViews = new ArrayList<>();
        for (String img : imgList) {
            PhotoView photoView = new PhotoView(this);
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            photoView.setClickable(true);
            photoView.setOnPhotoTapListener(this);
            Glide.with(this).load(img).crossFade().into(photoView);
            photoViews.add(photoView);
        }
        final AdapterDetailsViewPager adapterDetailsViewPager = new AdapterDetailsViewPager(photoViews);
        activityDetailsTvIndicate.setVisibility(View.VISIBLE);
        activityDetailsVp.setAdapter(adapterDetailsViewPager);
        final int size = photoViews.size();
        activityDetailsTvIndicate.setText("1/" + size);
        activityDetailsVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                activityDetailsTvIndicate.setText((position + 1) + "/" + size);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p2.cancel();
    }

    @Override
    public void onPhotoTap(View view, float x, float y) {
        finish();
    }
}
