package com.example.administrator.weiying.presenter;

import com.example.administrator.weiying.model.GankModel;
import com.example.administrator.weiying.model.bean.GankBean;
import com.example.administrator.weiying.view.GankView;

/**
 * Created by DELL on 2017/12/15.
 */

public class GankPresenter {
    private GankView gankView;
    private final GankModel gankModel;

    public GankPresenter(GankView gankView) {
        this.gankView = gankView;
        gankModel = new GankModel();
    }
    public void getGankPresenter(){
        gankModel.getGank();
        gankModel.setOnDetailListener(new GankModel.OnGankListener() {
            @Override
            public void onSuccess(GankBean gankBean) {
                gankView.showGank(gankBean);
            }
        });
    }
}
