package com.caohua.zhousaito.retrofitdemo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zhousaito on 2018/3/2.
 */

public interface LoginApi {
    @POST("login")
    @FormUrlEncoded
    Call<UserBean> getUserBean(@FieldMap Map<String,String> map);
}
