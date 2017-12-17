package com.example.administrator.weiying.presenter;


import com.example.administrator.weiying.model.RecyModel;
import com.example.administrator.weiying.model.bean.NewsBean;
import com.example.administrator.weiying.view.IRecyView;

/**
 * Created by せしおゆ on 2017/11/21.
 */

public class RecyPresenter{
    IRecyView view;
    RecyModel model;

    public RecyPresenter(IRecyView view) {
        this.view = view;
        model=new RecyModel();
    }
    public void relevance(String catalogId,String pnum){
        model.findData(catalogId,pnum);
        model.SetOnListListener(new RecyModel.OnListListener() {
            @Override
            public void OnSuccess(NewsBean newsBean) {
                   view.getData(newsBean);
            }
        });
    }



}
