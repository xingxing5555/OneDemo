package com.example.admin.basic.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/10/31.
 */

public class RequestManager {
    private final static String URL="http://v3.wufazhuce.com:8000/";
    private static OkHttpClient client;
    private static NetworkService networkService;


    /**
     * 普通不添加公共的头信息
     */
    public static NetworkService getNormalService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        networkService = retrofit.create(NetworkService.class);
        return networkService;
    }


    /**
     * 通过拦截器添加公共的头信息
     */
    public static NetworkService getHeaderService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(getHeaderClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        networkService = retrofit.create(NetworkService.class);
        return networkService;
    }


    private static OkHttpClient getHeaderClient() {
        client = new OkHttpClient.Builder().addInterceptor(new HeaderInterceptor()).build();
        return client;
    }


    /**
     * 头信息拦截器
     */
    static class HeaderInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request request1 = request.newBuilder()
                    .addHeader("device_id", "597823023")
                    .addHeader("name", "macName")
                    .addHeader("interceptor", "拦截试试啊")
                    .build();
            Response response = chain.proceed(request1);
            return response;
        }
    }


}
