package com.example.administrator.weiying.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.adapter.SearchAdapter;
import com.example.administrator.weiying.model.bean.SearchBean;
import com.example.administrator.weiying.presenter.SearchPresenter;
import com.example.administrator.weiying.view.SearchView;

import java.util.List;

public class ShowSearchActivity extends AppCompatActivity implements SearchView{

    private String keyword;
    private RecyclerView search_rv;
    private TextView finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_search);
        Intent intent = getIntent();
        keyword = intent.getStringExtra("keyword");

        search_rv = (RecyclerView) findViewById(R.id.search_rv);
        search_rv.setLayoutManager(new GridLayoutManager(this,3));
        finish = (TextView) findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SearchPresenter searchPresenter = new SearchPresenter(this);
        searchPresenter.getFindPresneter();
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public void getSearchView(SearchBean searchBean) {
        final List<SearchBean.RetBean.ListBean> list = searchBean.getRet().getList();
        SearchAdapter searchAdapter = new SearchAdapter(ShowSearchActivity.this,list);
        search_rv.setAdapter(searchAdapter);
        searchAdapter.setOnClickListener(new SearchAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                String dataId = list.get(position).getDataId();
                Intent intent = new Intent(ShowSearchActivity.this,DetailActivity.class);
                intent.putExtra("dataId",dataId);
                startActivity(intent);
            }
        });
    }
}
