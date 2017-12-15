package com.example.administrator.weiying.view;

import com.example.administrator.weiying.model.bean.CommentaryBean;

/**
 * Created by Administrator on 2017/12/14.
 */

public interface CommentaryView {
    String getMediaId();
    void getCommentView(CommentaryBean commentaryBean);
}
