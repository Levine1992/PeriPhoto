package com.example.bdwen.acartoon.m;

import com.example.bdwen.acartoon.bean.B1;
import com.example.bdwen.acartoon.bean.B2;
import com.example.bdwen.acartoon.net.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/4/7 0007.
 */

public class M1 implements MI1 {

    private Call<B1> bDetailsCall;

    @Override
    public void getNetList(final MIOnNetListener mIOnNetListener, String type) {
        Api api = new Retrofit.Builder()
                .baseUrl(Api.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
        bDetailsCall = api.apiList(Api.APPID, Api.SECRET, type);
        bDetailsCall.enqueue(new Callback<B1>() {
            @Override
            public void onResponse(Call<B1> call, Response<B1> response) {
                B1 body = response.body();
                mIOnNetListener.success(body);
            }

            @Override
            public void onFailure(Call<B1> call, Throwable t) {
                mIOnNetListener.error(t);
            }
        });
    }

    @Override
    public void cancel() {
        if (bDetailsCall!=null){
            bDetailsCall.cancel();
        }
    }

}
