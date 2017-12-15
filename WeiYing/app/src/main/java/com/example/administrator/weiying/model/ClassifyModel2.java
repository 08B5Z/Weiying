package com.example.administrator.weiying.model;

import android.util.Log;

import com.example.administrator.weiying.model.bean.ClassifyBean;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.net.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/12/14.
 */

public class ClassifyModel2 implements IClassifyModel2{
    private String url  = "http://api.svipmovie.com";
    @Override
    public void showmodel2(final SendData2 sendData2) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxxx", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Flowable<ClassifyBean> string = apiService.getString2();

        string .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ClassifyBean>() {
                    @Override
                    public void onNext(ClassifyBean classifyBean) {
                        Log.i("xxxx", "sucess"+classifyBean.toString());
                        sendData2.senddata2(classifyBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("xxxx", "sb"+t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface SendData2{
        void senddata2(ClassifyBean classifyBean);
    }
}
