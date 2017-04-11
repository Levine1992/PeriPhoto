package com.example.bdwen.acartoon.p;

import com.bumptech.glide.Glide;
import com.example.bdwen.acartoon.bean.B1;
import com.example.bdwen.acartoon.m.M1;
import com.example.bdwen.acartoon.m.MIOnNetListener;
import com.example.bdwen.acartoon.v.VI1;
import com.makeramen.roundedimageview.RoundedImageView;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public class P1 {
    private VI1 vi1;
    private M1 m1;

    public P1(VI1 vi1) {
        this.vi1 = vi1;
        this.m1 = new M1();
    }

    public void getList(String type) {
        vi1.showLoading();
        m1.getNetList(new MIOnNetListener() {
            @Override
            public void success(Object object) {
                vi1.hideLoading();
                B1 b1= (B1) object;
                if (b1.getShowapi_res_code()==0){
                    vi1.showData((B1) object);
                }else {
                    vi1.error(null);
                }
            }

            @Override
            public void error(Throwable t) {
                vi1.hideLoading();
                vi1.error(t);
            }
        }, type);
    }

}
