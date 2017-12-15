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
import android.view.WindowManager;
import android.widget.EditText;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.activity.DetailActivity;
import com.example.administrator.weiying.activity.FrescoImageLoader;
import com.example.administrator.weiying.activity.SearchActivity;
import com.example.administrator.weiying.adapter.ListAdapter;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.presenter.HomePagePresenter;
import com.example.administrator.weiying.view.HomePageView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_choice extends Fragment implements HomePageView{
    private View view;
    private Banner mBan;
    /**
     * 一念天堂
     */
    private EditText mFind;
    private RecyclerView mRv;
    private List<String> imgList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);

        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        HomePagePresenter homePagePresenter = new HomePagePresenter(this);
        homePagePresenter.getPresenter();

        initView(view);
        return view;
    }

    private void initView(View view) {
        mBan = (Banner) view.findViewById(R.id.ban);
        mFind = (EditText) view.findViewById(R.id.find);
        mRv = (RecyclerView) view.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        mFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void getHomePageView(ShouYeBean shouYeBean) {
        List<ShouYeBean.RetBean.ListBean> list = shouYeBean.getRet().getList();

        List<ShouYeBean.RetBean.ListBean.ChildListBean> child = list.get(0).getChildList();
        final List<ShouYeBean.RetBean.ListBean.ChildListBean> childList = list.get(10).getChildList();
        for (int i=0;i<child.size();i++){
            String pic = child.get(i).getPic();
            imgList.add(pic);
        }

        mBan.isAutoPlay(true);
        mBan.setImages(imgList);
        mBan.setImageLoader(new FrescoImageLoader());
        mBan.start();

        ListAdapter listAdapter = new ListAdapter(getContext(),childList);
        mRv.setAdapter(listAdapter);
        listAdapter.setOnClickListener(new ListAdapter.OnClickListener() {
            @Override
            public void OnClick(int position) {
                String dataId = childList.get(position).getDataId();
                String description = childList.get(position).getDescription();

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("dataId",dataId);
                intent.putExtra("description",description);
                startActivity(intent);
            }
        });
    }
}
