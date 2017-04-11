package com.example.bdwen.acartoon.net;

import com.example.bdwen.acartoon.bean.B1;
import com.example.bdwen.acartoon.bean.B2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/4/6 0006.
 */

public interface Api {
//    type=dmbz 动漫壁纸
//    type=rwbz 人物壁纸
//    type=bz 壁纸
//    type=nvyou 写真艺术
//    type=xingge 性格美女
//    type=rufang 美女车展
//    type=meitun 美女头像
//    type=qqtx QQ头像
//    type=wxtx 微信头像
//    type=mote 美女模特 *
//    type=qunzhuang 裙装美女
//    type=meinv 美女照片*
//    type=meishi 美食图片
//    type=wenshen 纹身图片
//    type=dongwu 动物图片
//    type=yingshi 影视剧照
//    type=tpzp 自拍艺术
    /**
     * 域名
     */
    public final static String DOMAIN = "http://route.showapi.com";
    /**
     * appid
     */
    public final static String APPID = "35194";
    /**
     * secret
     */
    public final static String SECRET = "093aaddcfe6641ebb70a066a7d17a998";
    /**
     * type 情趣
     */
    public final static String TYPE_QINGQU = "qingqu";
    /**
     * type 丝袜
     */
    public final static String TYPE_SIWA = "siwa";
    /**
     * type 比基尼
     */
    public final static String TYPE_BIJINI = "bijini";
    /**
     * type 制服
     */
    public final static String TYPE_ZHIFU = "zhifu";
    /**
     * type av女演员
     */
    public final static String TYPE_AV = "av";
    /**
     * type 性感
     */
    public final static String TYPE_XINGGAN = "xinggan";
    /**
     * type 模特
     */
    public final static String TYPE_MOTE = "mote";
    /**
     * type 美女
     */
    public final static String TYPE_MEINV = "meinv";
    /**
     * type 裙装
     */
    public final static String TYPE_QUNZHUANG = "qunzhuang";

    @FormUrlEncoded
    @POST("/959-1")
    Call<B1> apiList(@Field("showapi_appid") String appid
            , @Field("showapi_sign") String sign
            , @Field("type") String type);

    @FormUrlEncoded
    @POST("/959-2")
    Call<B2> apiDetails(@Field("showapi_appid") String appid
            , @Field("showapi_sign") String sign
            , @Field("id") String id);
}
