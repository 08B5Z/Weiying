package com.example.administrator.weiying.presenter;

import android.content.Context;

import com.example.administrator.weiying.model.ClassifyModel;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.view.IClassifyView;

/**
 * Created by lenovo on 2017/12/14.
 */

public class ClassifyPresenter {
    private IClassifyView classifyView;
    private ClassifyModel classifyModel;
    private  Context context;

    public ClassifyPresenter(Context context ,IClassifyView classifyView) {
        this.classifyView = classifyView;
        classifyModel = new ClassifyModel();
        this.context = context;
    }

    public void  getClassify(){
        classifyModel.showmodel(new ClassifyModel.SendData() {
            @Override
            public void senddata(ShouYeBean shouYeBean) {
                classifyView.showClassify(shouYeBean);
            }
        });
    }
}
