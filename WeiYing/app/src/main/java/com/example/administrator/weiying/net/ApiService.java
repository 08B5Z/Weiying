package com.example.administrator.weiying.net;

import com.example.administrator.weiying.model.bean.NewsBean;
import com.example.administrator.weiying.model.bean.ShouYeBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface ApiService {

    @GET("front/homePageApi/homePage.do")
    Flowable<ShouYeBean> getHomePage();
    //发现
    @POST("front/columns/getVideoList.do")
    @FormUrlEncoded
    Flowable<NewsBean> getList(@Field("catalogId")String catalogId, @Field("pnum")String pnum);
}
