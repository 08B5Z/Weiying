package com.example.administrator.weiying.view;

import com.example.administrator.weiying.model.bean.DetailBean;

/**
 * Created by Administrator on 2017/12/14.
 */

public interface DetailView {
    String getMediaId();
    void getDetailView(DetailBean detailBean);
}