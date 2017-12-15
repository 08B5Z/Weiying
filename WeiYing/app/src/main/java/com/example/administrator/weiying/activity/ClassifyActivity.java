package com.example.administrator.weiying.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.adapter.ClassifyAdapter;
import com.example.administrator.weiying.adapter.ClassifyAdapter2;
import com.example.administrator.weiying.model.bean.ClassifyBean;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.presenter.ClassifyPresenter;
import com.example.administrator.weiying.presenter.ClassifyPresenter2;
import com.example.administrator.weiying.view.IClassifyView2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/14.
 */

public class ClassifyActivity extends AppCompatActivity implements IClassifyView2 {
    private ClassifyAdapter2 classifyAdapter2;
    private RecyclerView recyclerView;
    private Context context;
    private String catalogId;
    private String title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classify);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this , 3));
        ClassifyPresenter2 classifyPresenter2 = new ClassifyPresenter2(this);
        classifyPresenter2.getClassify();

        catalogId = getIntent().getStringExtra("catalogId");
        title = getIntent().getStringExtra("title");
    }


    @Override
    public void showClassify2(ClassifyBean classifyBean) {

        final List<ClassifyBean.RetBean.ListBean> list = classifyBean.getRet().getList();
        if(classifyAdapter2==null){
            classifyAdapter2=new ClassifyAdapter2(ClassifyActivity.this,list);
            recyclerView.setAdapter(classifyAdapter2);

        }else {
            classifyAdapter2.notifyDataSetChanged();

        }

        classifyAdapter2.setOnitemclicklistener(new ClassifyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(ClassifyActivity.this , DetailActivity.class);
                String dataId = (list.get(position).getDataId());
                intent.putExtra("dataId" , dataId);
                startActivity(intent);
            }
        });
    }


}
