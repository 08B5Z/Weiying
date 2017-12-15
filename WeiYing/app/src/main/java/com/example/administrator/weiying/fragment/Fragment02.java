package com.example.administrator.weiying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.adapter.CommentAdapter;
import com.example.administrator.weiying.model.bean.CommentaryBean;
import com.example.administrator.weiying.presenter.CommentaryPresneter;
import com.example.administrator.weiying.view.CommentaryView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Fragment02 extends Fragment implements CommentaryView {
    private View view;
    private String dataId;
    private String description;
    private RecyclerView mCommentRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment06, container, false);

        Intent intent = getActivity().getIntent();
        dataId = intent.getStringExtra("dataId");
        description = intent.getStringExtra("description");
        initView(view);

        CommentaryPresneter commentaryPresneter = new CommentaryPresneter(this);
        commentaryPresneter.getCommentPresenter();

        return view;
    }

    @Override
    public String getMediaId() {
        return dataId;
    }

    @Override
    public void getCommentView(CommentaryBean commentaryBean) {
        List<CommentaryBean.RetBean.ListBean> list = commentaryBean.getRet().getList();

        CommentAdapter commentAdapter = new CommentAdapter(getContext(),list);
        mCommentRv.setAdapter(commentAdapter);
    }

    private void initView(View view) {
        mCommentRv = (RecyclerView) view.findViewById(R.id.comment_rv);
        mCommentRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mCommentRv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
    }
}
