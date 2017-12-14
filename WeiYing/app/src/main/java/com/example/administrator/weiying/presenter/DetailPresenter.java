package com.example.administrator.weiying.presenter;

import com.example.administrator.weiying.model.DetailModel;
import com.example.administrator.weiying.model.bean.DetailBean;
import com.example.administrator.weiying.view.DetailView;

/**
 * Created by Administrator on 2017/12/14.
 */

public class DetailPresenter {

    private DetailView detailView;
    private DetailModel detailModel;

    public DetailPresenter(DetailView detailView) {
        this.detailView = detailView;
        detailModel = new DetailModel();
    }

    public void getDetailPresenter(){
        String mediaId = detailView.getMediaId();
        detailModel.getDetailData(mediaId);
        detailModel.setOnDetailListener(new DetailModel.OnDetailListener() {
            @Override
            public void onSuccess(DetailBean detailBean) {
                detailView.getDetailView(detailBean);
            }
        });
    }
}
