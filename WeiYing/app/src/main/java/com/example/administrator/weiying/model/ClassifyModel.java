package com.example.administrator.weiying.model;

import android.database.Observable;
import android.util.Log;

import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.net.Api;
import com.example.administrator.weiying.net.ApiService;
import com.example.administrator.weiying.view.IClassifyView;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscriber;

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

public class ClassifyModel implements IClassifyModel{
    private String url  = "http://api.svipmovie.com/";

    @Override
    public void showmodel(final SendData sendData) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("xxx", message);
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
        Flowable<ShouYeBean> string = apiService.getString();

        string .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShouYeBean>() {
                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        sendData.senddata(shouYeBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface SendData{
        void senddata(ShouYeBean shouYeBean);
    }
}
