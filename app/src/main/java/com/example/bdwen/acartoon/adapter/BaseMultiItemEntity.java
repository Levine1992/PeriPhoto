package com.example.bdwen.acartoon.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public class BaseMultiItemEntity implements MultiItemEntity{
    //item类型
    public static final int ITEMTYPE1 = 1;
    public static final int ITEMTYPE2 = 2;
    public static final int ITEMTYPE3 = 3;
    public static final int ITEMTYPE4 = 4;
    public static final int ITEMTYPE5 = 5;
    public static final int ITEMTYPE6 = 6;
    public static final int ITEMTYPE7 = 7;
    public static final int ITEMTYPE8 = 8;
    public static final int ITEMTYPE9 = 9;
    public static final int ITEMTYPE10 = 10;
    //item权重
    public static final int SPAN1 = 1;
    public static final int SPAN2 = 2;
    public static final int SPAN3 = 3;
    public static final int SPAN4 = 4;
    public static final int SPAN5 = 5;
    public static final int SPAN6 = 6;
    public static final int SPAN7 = 7;
    public static final int SPAN8 = 8;
    public static final int SPAN9 = 9;
    public static final int SPAN10 = 10;
    private int itemType;
    private int spanSize;
    private Object data;

    /**
     *
     * @param itemType item类型
     * @param spanSize item占比
     * @param data 数据
     */
    public BaseMultiItemEntity(int itemType, int spanSize, Object data){
        this.itemType=itemType;
        this.spanSize=spanSize;
        this.data=data;
    }
    @Override
    public int getItemType() {
        return itemType;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public Object getData() {
        return data;
    }
}
