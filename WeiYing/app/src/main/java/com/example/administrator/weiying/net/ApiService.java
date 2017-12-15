package com.example.administrator.weiying.net;

import com.example.administrator.weiying.model.bean.ClassifyBean;
import com.example.administrator.weiying.model.bean.CommentaryBean;
import com.example.administrator.weiying.model.bean.DetailBean;
import com.example.administrator.weiying.model.bean.NewsBean;
import com.example.administrator.weiying.model.bean.SearchBean;
import com.example.administrator.weiying.model.bean.ShouYeBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by Administrator on 2017/12/13.
 */

public interface ApiService {


    @GET("front/homePageApi/homePage.do")
    Flowable<ShouYeBean> getString();

    @GET("front/columns/getVideoList.do?catalogId=402834815584e463015584e538140009")
    Flowable<ClassifyBean> getString2();


    @GET("front/homePageApi/homePage.do")
    Flowable<ShouYeBean> getHomePage();

    //发现
    @POST("front/columns/getVideoList.do")
    @FormUrlEncoded
    Flowable<NewsBean> getList(@Field("catalogId")String catalogId, @Field("pnum")String pnum);


    /**
     *
     * @param mediaId
     * @return
     */
    @GET("front/videoDetailApi/videoDetail.do")
    Flowable<DetailBean> getDetail(@Query("mediaId")String mediaId);

    /**
     *
     * @param mediaId
     * @return
     */
    @GET("front/Commentary/getCommentList.do")
    Flowable<CommentaryBean> getCommentary(@Query("mediaId")String mediaId);

    /**
     *
     * @param keyword
     * @return
     */
    @GET("front/searchKeyWordApi/getVideoListByKeyWord.do")
    Flowable<SearchBean> getSearch(@Query("keyword")String keyword);

}
