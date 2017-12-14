package com.example.administrator.weiying.model;

import com.example.administrator.weiying.model.bean.DetailBean;
import com.example.administrator.weiying.net.Api;
import com.example.administrator.weiying.net.ApiService;
import com.example.administrator.weiying.utils.RetrofitUtils;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by Administrator on 2017/12/14.
 */

public class DetailModel {

    private OnDetailListener onDetailListener;

    public interface OnDetailListener{
        void onSuccess(DetailBean detailBean);
    }

    public void setOnDetailListener(OnDetailListener onDetailListener){
        this.onDetailListener = onDetailListener;
    }

    public void getDetailData(String mediaId){
        RetrofitUtils retrofitUtils = new RetrofitUtils();
        ApiService apiService = retrofitUtils.getInstance().getApiService(Api.DETAIL, ApiService.class);
        Flowable<DetailBean> detail = apiService.getDetail(mediaId);
        detail.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DetailBean>() {
                    @Override
                    public void onNext(DetailBean detailBean) {
                        if(onDetailListener!=null){
                            onDetailListener.onSuccess(detailBean);
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
