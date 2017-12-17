package com.example.administrator.weiying.model;

import com.example.administrator.weiying.model.bean.GankBean;
import com.example.administrator.weiying.net.Api;
import com.example.administrator.weiying.net.ApiService;
import com.example.administrator.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by DELL on 2017/12/15.
 */

public class GankModel {
    private OnGankListener onGankListener;

    public interface OnGankListener{
        void onSuccess(GankBean gankBean);
    }

    public void setOnDetailListener(OnGankListener onGankListener){
        this.onGankListener = onGankListener;
    }
    public void getGank(){
        ApiService apiService = new RetrofitUtils().getApiService(Api.GANK, ApiService.class);
        Flowable<GankBean> gank = apiService.getGank(156, 1);
        gank.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<GankBean>() {
                    @Override
                    public void onNext(GankBean gankBean) {
                        onGankListener.onSuccess(gankBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
