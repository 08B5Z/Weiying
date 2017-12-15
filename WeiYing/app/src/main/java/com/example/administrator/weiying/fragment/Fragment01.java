package com.example.administrator.weiying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.adapter.GridAdapter;
import com.example.administrator.weiying.model.bean.DetailBean;
import com.example.administrator.weiying.presenter.DetailPresenter;
import com.example.administrator.weiying.view.DetailView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */

public class Fragment01 extends Fragment implements DetailView{
    private View view;
    private TextView mName;
    private TextView mName2;
    private TextView mDescription;
    private RecyclerView mGridRv;
    private String dataId;
    private String description;
    private TextView show;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment05, container, false);
        initView(view);
        Intent intent = getActivity().getIntent();
        dataId = intent.getStringExtra("dataId");
        description = intent.getStringExtra("description");

        DetailPresenter detailPresenter = new DetailPresenter(this);
        detailPresenter.getDetailPresenter();

        return view;
    }

    private void initView(View view) {
        mName = (TextView) view.findViewById(R.id.name);
        mName2 = (TextView) view.findViewById(R.id.name2);
        mDescription = (TextView) view.findViewById(R.id.description);
        mGridRv = (RecyclerView) view.findViewById(R.id.grid_rv);
        mGridRv.setLayoutManager(new GridLayoutManager(getContext(),3));
        show = view.findViewById(R.id.show);
    }

    @Override
    public String getMediaId() {
        return dataId;
    }

    @Override
    public void getDetailView(DetailBean detailBean) {
        DetailBean.RetBean ret = detailBean.getRet();
        String director = ret.getDirector();
        String videoType = ret.getVideoType();
        final String description = ret.getDescription();
        final List<DetailBean.RetBean.ListBean.ChildListBean> childList = ret.getList().get(0).getChildList();

        mName.setText("导演："+director);
        mName2.setText("类型："+videoType);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().equals("展开")){
                    show.setText("收起");
                    mDescription.setVisibility(View.VISIBLE);
                    mDescription.setText(description);
                }else{
                    show.setText("展开");
                    mDescription.setVisibility(View.GONE);
                }
            }
        });

        GridAdapter gridAdapter = new GridAdapter(getContext(), childList);
        mGridRv.setAdapter(gridAdapter);
    }
}
