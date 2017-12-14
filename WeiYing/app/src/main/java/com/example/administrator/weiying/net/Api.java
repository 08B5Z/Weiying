package com.example.administrator.weiying.net;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Api {
    private static final String HOST = "http://api.svipmovie.com/";
    //首页：http://api.svipmovie.com/front/homePageApi/homePage.do 请求方式：GET
    public static final String HOMEPAGE = HOST;
    //频道列表：http://api.svipmovie.com/columns/getVideoList.do 参数：catalogId pnum 请求方式：GET
    public static final String VIDEOLIST = HOST;
    //详情：http://api.svipmovie.com/front/videoDetailApi/videoDetail.do 参数：mediaId 请求方式：GET
    public static final String DETAIL = HOST;
    //搜索：http://api.svipmovie.com/front/searchKeyWordApi/getVideoListByKeyWord.do 参数：keyword pnum 请求方式：GET
    public static final String SEARCH = HOST;
    //评论列表：http://api.svipmovie.com/front/Commentary/getCommentList.do?mediaId=CMCC_00000000000000001_621653189
    public static final String COMMENT = HOST;
}
