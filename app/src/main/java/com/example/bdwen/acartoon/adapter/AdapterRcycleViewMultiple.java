package com.example.bdwen.acartoon.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.bdwen.acartoon.R;
import com.example.bdwen.acartoon.bean.B1;
import com.example.bdwen.acartoon.utils.ScreenUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/3/20 0020.
 */

public class AdapterRcycleViewMultiple extends BaseMultiItemQuickAdapter<BaseMultiItemEntity, BaseViewHolder> {
    private static final String TAG = "AdapterRcycleViewMultip";
    private Context context;
    private final int height;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public AdapterRcycleViewMultiple(Context context, List data) {
        super(data);
        this.context = context;
        //添加item类型
        addItemType(BaseMultiItemEntity.ITEMTYPE1, R.layout.view_list_item);
        height = getHeight();
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, BaseMultiItemEntity baseMultiItemEntity) {
        switch (baseViewHolder.getItemViewType()) {
            case BaseMultiItemEntity.ITEMTYPE1:
                B1.ShowapiResBodyBean.PagebeanBean.ContentlistBean data =
                        (B1.ShowapiResBodyBean.PagebeanBean.ContentlistBean) baseMultiItemEntity.getData();
                View view = baseViewHolder.getView(R.id.view_list_item_iv_img);
                view.getLayoutParams().height =height;
                Glide.with(context)
                        .load(data.getImg())
                        .crossFade()
                        .placeholder(R.drawable.loading)
                        .into((ImageView) view);
                break;
        }
    }

    public int getHeight() {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test);
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float scale =  width/ height;
        int screenWidth = ScreenUtils.getScreenWidth(context) / 2;
        float screenHeight =(screenWidth /scale);
        bitmap.recycle();
        return (int) screenHeight;
    }
}
