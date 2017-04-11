package com.example.bdwen.acartoon.p;

import com.example.bdwen.acartoon.m.MCategory;
import com.example.bdwen.acartoon.v.VICategory;

/**
 * Created by Administrator on 2017/4/6 0006.
 */

public class PCategory {

    private VICategory vICategory;
    private MCategory mCategory;

    public PCategory(VICategory vICategory) {
        this.vICategory = vICategory;
        this.mCategory = new MCategory();
    }

    public void upView() {
        vICategory.upView(mCategory.factoryData());
    }

}
