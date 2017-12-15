package com.example.administrator.weiying.model;

import com.example.administrator.weiying.model.bean.NewsBean;
import com.example.administrator.weiying.net.Api;
import com.example.administrator.weiying.net.ApiService;
import com.example.administrator.weiying.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by せしおゆ on 2017/12/14.
 */

public class RecyModel {

    private OnListListener onListListener;
    public interface OnListListener {
        public void OnSuccess(NewsBean newsBean);
    }
   public void SetOnListListener(OnListListener onListListener){
       this.onListListener=onListListener;
   }

    public void findData(String catalogId,String pnum){
        RetrofitUtils retrofitUtils = new RetrofitUtils();
        ApiService apiService = retrofitUtils.getInstance().getApiService(Api.HOMEPAGE, ApiService.class);
        apiService.getList(catalogId,pnum).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<NewsBean>() {
                    @Override
                    public void onNext(NewsBean newsBean) {
                        if (onListListener!=null){
                            onListListener.OnSuccess(newsBean);
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
