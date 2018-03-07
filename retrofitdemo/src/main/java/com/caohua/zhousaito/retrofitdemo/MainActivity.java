package com.caohua.zhousaito.retrofitdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private View btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.main_download_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                first();
                login();
            }
        });

    }

    public static String unicode(String source){
        StringBuffer sb = new StringBuffer();
        char [] source_char = source.toCharArray();
        String unicode = null;
        for (int i=0;i<source_char.length;i++) {
            unicode = Integer.toHexString(source_char[i]);
            if (unicode.length() <= 2) {
                unicode = "00" + unicode;
            }
            sb.append("\\u" + unicode);
        }
        System.out.println(sb);
        return sb.toString();
    }

    private void login() {
        Retrofit build = new Retrofit.Builder().baseUrl("http://oa.caohua.com/").addConverterFactory(GsonConverterFactory.create()).build();
        LoginApi loginApi = build.create(LoginApi.class);
        //requestBody=%7B%22account%22%3A%2218618474505%22%2C%22password%22%3A%2288888888%22%7D
        Map<String, String> map = new HashMap<>();
        map.put("requestBody", "{\"account\":\"18618474505\",\"password\":\"88888888\"}");
        Call<UserBean> userBean = loginApi.getUserBean(map);
        userBean.enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                UserBean body = response.body();
                Log.e("MainActivity", "body: " + body);
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {

            }
        });
    }

    private void first() {
        Retrofit build = new Retrofit.Builder().baseUrl("https://www.jianshu.com/").build();
        ServerApi serverApi = build.create(ServerApi.class);
        serverApi.load().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String body = null;
//                        try {
//                            body = response.body();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                Log.e("MainActivity", "Thread" + Thread.currentThread().getName());
                Log.e("MainActivity", "body: " + body);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("MainActivity", " onFailure Thread" + Thread.currentThread().getName());
                Log.e("MainActivity", "onFailure t" + t);
            }
        });
    }
}
