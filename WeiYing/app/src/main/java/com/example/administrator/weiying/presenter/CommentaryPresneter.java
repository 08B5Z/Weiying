package com.example.administrator.weiying.presenter;

import com.example.administrator.weiying.model.CommentaryModel;
import com.example.administrator.weiying.model.bean.CommentaryBean;
import com.example.administrator.weiying.view.CommentaryView;

/**
 * Created by Administrator on 2017/12/14.
 */

public class CommentaryPresneter {

    private CommentaryView commentaryView;
    private final CommentaryModel commentaryModel;

    public CommentaryPresneter(CommentaryView commentaryView) {
        this.commentaryView = commentaryView;
        commentaryModel = new CommentaryModel();
    }

    public void getCommentPresenter(){
        String mediaId = commentaryView.getMediaId();
        commentaryModel.getCommentData(mediaId);
        commentaryModel.setOnCommentListener(new CommentaryModel.OnCommentListener() {
            @Override
            public void onSuccess(CommentaryBean commentaryBean) {
                commentaryView.getCommentView(commentaryBean);
            }
        });
    }
}
