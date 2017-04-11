package com.example.bdwen.acartoon.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.bdwen.acartoon.R;
import com.example.bdwen.acartoon.activity.DetailsActivity;
import com.example.bdwen.acartoon.adapter.AdapterRcycleViewMultiple;
import com.example.bdwen.acartoon.adapter.BaseMultiItemEntity;
import com.example.bdwen.acartoon.bean.B1;
import com.example.bdwen.acartoon.net.Api;
import com.example.bdwen.acartoon.p.P1;
import com.example.bdwen.acartoon.utils.DensityUtils;
import com.example.bdwen.acartoon.utils.T;
import com.example.bdwen.acartoon.v.VI1;
import com.example.bdwen.acartoon.view.ItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/7 0007.
 * 少年
 */

public class Fragment8 extends Fragment implements VI1, View.OnClickListener {
    private static final String TAG = "Fragment1";
    private static Fragment8 fragment1;
    @BindView(R.id.fragment_juvenile_recycleview)
    RecyclerView fragmentJuvenileRecycleview;
    @BindView(R.id.view_progressbar_pb)
    ProgressBar viewProgressbarPb;
    @BindView(R.id.view_net_error_tv)
    TextView viewNetErrorTv;
    private View mView;
    private P1 p1;

    public static Fragment8 getInstance() {
        if (fragment1 == null) {
            fragment1 = new Fragment8();
        }
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p1 = new P1(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment, container, false);
        }
        ButterKnife.bind(this, mView);
        if (fragmentJuvenileRecycleview.getAdapter() == null) {
            p1.getList(Api.TYPE_MEINV);
        }
        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        p1.cancel();
    }

    @Override
    public void showLoading() {
        viewNetErrorTv.setVisibility(View.GONE);
        fragmentJuvenileRecycleview.setVisibility(View.GONE);
        viewProgressbarPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        viewNetErrorTv.setVisibility(View.GONE);
        fragmentJuvenileRecycleview.setVisibility(View.VISIBLE);
        viewProgressbarPb.setVisibility(View.GONE);
    }

    @Override
    public void error(Throwable t) {
        viewNetErrorTv.setVisibility(View.VISIBLE);
        viewNetErrorTv.setOnClickListener(this);
    }

    @Override
    public void showData(final B1 b1) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        List<B1.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist = b1.getShowapi_res_body().getPagebean().getContentlist();
        final List<BaseMultiItemEntity> list = new ArrayList();
        for (int i = 0; i < contentlist.size(); i++) {
            list.add(new BaseMultiItemEntity(BaseMultiItemEntity.ITEMTYPE1, BaseMultiItemEntity.SPAN1, contentlist.get(i)));
        }
        AdapterRcycleViewMultiple adapterRcycleViewMultiple = new AdapterRcycleViewMultiple(getActivity(), list);
        adapterRcycleViewMultiple.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int spanSize = list.get(position).getSpanSize();
                return spanSize;
            }
        });
        //设置item加载动画
        adapterRcycleViewMultiple.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        fragmentJuvenileRecycleview.setLayoutManager(gridLayoutManager);
        fragmentJuvenileRecycleview.addItemDecoration(new ItemDecoration(DensityUtils.dp2px(getActivity(), 5)));
        fragmentJuvenileRecycleview.setAdapter(adapterRcycleViewMultiple);

        fragmentJuvenileRecycleview.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                String link = b1.getShowapi_res_body().getPagebean().getContentlist().get(position).getLink();
                intent.putExtra("id", link);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_net_error_tv:
                if (fragmentJuvenileRecycleview.getAdapter() == null) {
                    p1.getList(Api.TYPE_QINGQU);
                }
                break;
        }
    }
}
