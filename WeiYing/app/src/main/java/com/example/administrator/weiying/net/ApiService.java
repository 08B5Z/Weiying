package com.example.administrator.weiying.net;

import com.example.administrator.weiying.model.bean.CommentaryBean;
import com.example.administrator.weiying.model.bean.DetailBean;
import com.example.administrator.weiying.model.bean.ShouYeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface ApiService {


    @GET("front/homePageApi/homePage.do")
    Flowable<ShouYeBean> getHomePage();

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
}
