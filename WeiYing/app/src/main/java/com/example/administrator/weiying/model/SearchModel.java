package com.example.administrator.weiying.model;

import com.example.administrator.weiying.model.bean.SearchBean;
import com.example.administrator.weiying.net.Api;
import com.example.administrator.weiying.net.ApiService;
import com.example.administrator.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Administrator on 2017/12/15.
 */

public class SearchModel {

    private OnSearchListener onSearchListener;

    public interface OnSearchListener{
        void onSuccess(SearchBean searchBean);
    }

    public void setOnSearchListener(OnSearchListener onSearchListener){
        this.onSearchListener = onSearchListener;
    }

    public void getSearchData(String keyword){
        RetrofitUtils retrofitUtils = new RetrofitUtils();
        ApiService apiService = retrofitUtils.getInstance().getApiService(Api.SEARCH, ApiService.class);
        Flowable<SearchBean> search = apiService.getSearch(keyword);
        search.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SearchBean>() {
                    @Override
                    public void onNext(SearchBean searchBean) {
                        if(onSearchListener!=null){
                            onSearchListener.onSuccess(searchBean);
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
