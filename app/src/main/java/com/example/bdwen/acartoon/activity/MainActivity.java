package com.example.bdwen.acartoon.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bdwen.acartoon.R;
import com.example.bdwen.acartoon.adapter.AdapterMainFragmentAdapter;
import com.example.bdwen.acartoon.fragment.MyFragmentManager;
import com.example.bdwen.acartoon.p.PCategory;
import com.example.bdwen.acartoon.v.VICategory;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements VICategory {
    private static final String TAG = "MainActivity";
    @BindView(R.id.view_actionbar_iv_left)
    ImageView viewActionbarIvLeft;
    @BindView(R.id.view_actionbar_tv_title)
    TextView viewActionbarTvTitle;
    @BindView(R.id.view_actionbar_iv_right)
    ImageView viewActionbarIvRight;
    @BindView(R.id.view_actionbar_rl)
    RelativeLayout viewActionbarRl;
    @BindView(R.id.activity_main_tl)
    TabLayout activityMainTl;
    @BindView(R.id.activity_main_vp)
    ViewPager activityMainVp;

    private PCategory pCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        pCategory = new PCategory(this);
        pCategory.upView();
    }

    @Override
    public void upView(String[] strings) {
        MyFragmentManager myFragmentManager=new MyFragmentManager();
        AdapterMainFragmentAdapter adapterMainFragmentAdapter =
                new AdapterMainFragmentAdapter(getSupportFragmentManager(), myFragmentManager, strings);
        activityMainVp.setAdapter(adapterMainFragmentAdapter);
        activityMainTl.setupWithViewPager(activityMainVp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
