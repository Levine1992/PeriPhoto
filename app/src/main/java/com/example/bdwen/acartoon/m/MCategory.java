package com.example.bdwen.acartoon.m;

/**
 * Created by Administrator on 2017/4/6 0006.
 */

public class MCategory implements MICategory{
    private static final String TAG = "MCategory";

    @Override
    public String[] factoryData() {
        String[] strings={"情趣","丝袜","比基尼","制服","AV","性感","模特","美女","裙装"};
        return strings;
    }
}
