package com.example.administrator.weiying.model;

import com.example.administrator.weiying.model.bean.CommentaryBean;
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

public class CommentaryModel {

    private OnCommentListener onCommentListener;

    public interface OnCommentListener{
        void onSuccess(CommentaryBean commentaryBean);
    }

    public void setOnCommentListener(OnCommentListener onCommentListener){
        this.onCommentListener = onCommentListener;
    }

    public void getCommentData(String mediaId){
        RetrofitUtils retrofitUtils = new RetrofitUtils();
        ApiService apiService = retrofitUtils.getInstance().getApiService(Api.COMMENT, ApiService.class);
        Flowable<CommentaryBean> commentary = apiService.getCommentary(mediaId);
        commentary.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CommentaryBean>() {
                    @Override
                    public void onNext(CommentaryBean commentaryBean) {
                        if(onCommentListener!=null){
                            onCommentListener.onSuccess(commentaryBean);
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
