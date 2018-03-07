package com.caohua.zhousaito.retrofitdemo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zhousaito on 2018/3/2.
 */

public interface ServerApi {
    @GET("p/308f3c54abdd")
    Call<String> load();
}
