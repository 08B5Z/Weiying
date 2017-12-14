package com.example.administrator.weiying.net;

import com.example.administrator.weiying.model.bean.ShouYeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface ApiService {

    @GET("front/homePageApi/homePage.do")
    Flowable<ShouYeBean> getHomePage();
}
