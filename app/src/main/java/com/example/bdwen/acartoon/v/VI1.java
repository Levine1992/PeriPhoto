package com.example.bdwen.acartoon.v;

import com.example.bdwen.acartoon.bean.B1;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public interface VI1 {
    void showLoading();
    void hideLoading();
    void error(Throwable t);
    void showData(B1 b1);
}
