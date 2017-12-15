package com.example.administrator.weiying.presenter;

import com.example.administrator.weiying.model.HomePageModel;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.view.HomePageView;

/**
 * Created by Administrator on 2017/12/14.
 */

public class HomePagePresenter {
    private HomePageView homePageView;
    private HomePageModel homePageModel;

    public HomePagePresenter(HomePageView homePageView) {
        this.homePageView = homePageView;
        homePageModel = new HomePageModel();
    }

    public void getPresenter(){
        homePageModel.getHomePageData();
        homePageModel.setOnShowyeListener(new HomePageModel.OnShowyeListener() {
            @Override
            public void onSuccess(ShouYeBean shouYeBean) {
                homePageView.getHomePageView(shouYeBean);
            }
        });
    }
}
