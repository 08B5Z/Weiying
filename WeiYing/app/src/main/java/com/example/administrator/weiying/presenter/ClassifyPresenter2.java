package com.example.administrator.weiying.presenter;

import android.content.Context;

import com.example.administrator.weiying.model.ClassifyModel;
import com.example.administrator.weiying.model.ClassifyModel2;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.view.IClassifyView;
import com.example.administrator.weiying.view.IClassifyView2;

/**
 * Created by lenovo on 2017/12/14.
 */

public class ClassifyPresenter2 {
    private IClassifyView2 classifyView2;
    private ClassifyModel2 classifyModel2;
    private Context context;


    public ClassifyPresenter2(IClassifyView2 classifyView2, ClassifyModel2 classifyModel2, Context context) {
        this.classifyView2 = classifyView2;
        classifyModel2 = new ClassifyModel2();
        this.context = context;
    }

    public void  getClassify(){
        classifyModel2.showmodel(new ClassifyModel2.SendData() {
            @Override
            public void senddata(ShouYeBean shouYeBean) {
                classifyView2.showClassify(shouYeBean);
            }
        });
    }
}
