package com.example.bdwen.acartoon.m;

import com.example.bdwen.acartoon.bean.B2;
import com.example.bdwen.acartoon.net.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class M2 implements MI2{
    @Override
    public void getDetails(final MIOnNetListener miOnNetListener, String id) {
        Api api = new Retrofit.Builder()
                .baseUrl(Api.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
        Call<B2> bDetailsCall = api.apiDetails(Api.APPID, Api.SECRET, id);
        bDetailsCall.enqueue(new Callback<B2>() {
            @Override
            public void onResponse(Call<B2> call, Response<B2> response) {
                B2 body = response.body();
                miOnNetListener.success(body);
            }

            @Override
            public void onFailure(Call<B2> call, Throwable t) {
                miOnNetListener.error(t);
            }
        });
    }
}
