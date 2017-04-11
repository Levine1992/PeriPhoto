package com.example.bdwen.acartoon.p;

import com.example.bdwen.acartoon.bean.B2;
import com.example.bdwen.acartoon.m.M2;
import com.example.bdwen.acartoon.m.MIOnNetListener;
import com.example.bdwen.acartoon.v.VI2;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class P2 {
    private VI2 vi2;
    private M2 m2;
    public P2(VI2 vi2){
        this.m2=new M2();
        this.vi2=vi2;
    }
    public void getDetauls(String id){
        vi2.showLoading();
        m2.getDetails(new MIOnNetListener() {
            @Override
            public void success(Object object) {
                vi2.hideLoading();
                B2 b2= (B2) object;
                vi2.showData(b2);
            }

            @Override
            public void error(Throwable t) {
                vi2.hideLoading();
                vi2.error(t);
            }
        },id);
    }
}
