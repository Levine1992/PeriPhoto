package com.example.bdwen.acartoon.v;

import com.example.bdwen.acartoon.bean.B2;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public interface VI2 {
    void showLoading();
    void hideLoading();
    void error(Throwable t);
    void showData(B2 b2);
}
