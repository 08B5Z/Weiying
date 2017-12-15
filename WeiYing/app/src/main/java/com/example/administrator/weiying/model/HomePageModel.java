package com.example.administrator.weiying.model;

import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.net.Api;
import com.example.administrator.weiying.net.ApiService;
import com.example.administrator.weiying.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Administrator on 2017/12/14.
 */

public class HomePageModel {

    private OnShowyeListener onShowyeListener;

    public interface OnShowyeListener{
        void onSuccess(ShouYeBean shouYeBean);
    }

    public void setOnShowyeListener(OnShowyeListener onShowyeListener){
        this.onShowyeListener = onShowyeListener;
    }

    public void getHomePageData(){
        RetrofitUtils retrofitUtils = new RetrofitUtils();
        ApiService apiService = retrofitUtils.getInstance().getApiService(Api.HOMEPAGE, ApiService.class);
        apiService.getHomePage().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ShouYeBean>() {
                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        if(onShowyeListener!=null){
                            onShowyeListener.onSuccess(shouYeBean);
                        }
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
