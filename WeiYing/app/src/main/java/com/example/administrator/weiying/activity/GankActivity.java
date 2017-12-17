package com.example.administrator.weiying.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.adapter.GankAdapter;
import com.example.administrator.weiying.model.bean.GankBean;
import com.example.administrator.weiying.presenter.GankPresenter;
import com.example.administrator.weiying.view.GankView;

import java.util.List;

public class GankActivity extends AppCompatActivity implements GankView{

    private RecyclerView mGankRv;
    private GankPresenter gankPresenter;
    private GankAdapter gankAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        initView();
        gankPresenter = new GankPresenter(this);
        gankPresenter.getGankPresenter();
    }

    private void initView() {
        mGankRv = (RecyclerView) findViewById(R.id.gank_rv);
        mGankRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    public void showGank(GankBean gankBean) {
        List<GankBean.ResultsBean> results = gankBean.getResults();
        gankAdapter = new GankAdapter(this, results);
        mGankRv.setAdapter(gankAdapter);
    }
}
