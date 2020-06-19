package com.bat.studio.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bat.studio.utils.ContactUtils.BASE_URL;

public class RetrofitX {
    private static RetrofitX instance;
    private Retrofit retrofit;

    public static RetrofitX getInstance() {
        if (instance == null) {
            synchronized (RetrofitX.class){
                if (instance==null){
                    instance = new RetrofitX();
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }

}
