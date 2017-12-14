package com.example.administrator.weiying.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.activity.ClassifyActivity;
import com.example.administrator.weiying.adapter.ClassifyAdapter;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.example.administrator.weiying.presenter.ClassifyPresenter;
import com.example.administrator.weiying.view.IClassifyView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_book extends Fragment implements IClassifyView{
    private ClassifyAdapter adapter;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, container, false);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 2));
        ClassifyPresenter classifyPresenter = new ClassifyPresenter(getActivity() , this );
        classifyPresenter.getClassify();
        return view;
    }

    @Override
    public void showClassify(ShouYeBean shouYeBean) {


        final List<ShouYeBean.RetBean.ListBean.ChildListBean> list = new ArrayList<>();
        final List<ShouYeBean.RetBean.ListBean> list1 = new ArrayList<>();

        for (int i=0; i<shouYeBean.getRet().getList().size() ; i++){
            if (!TextUtils.isEmpty(shouYeBean.getRet().getList().get(i).getMoreURL()) &&
                    !TextUtils.isEmpty(shouYeBean.getRet().getList().get(i).getTitle())) {
                ShouYeBean.RetBean.ListBean.ChildListBean childListBean = shouYeBean.getRet().getList().get(i).getChildList().get(0);
                ShouYeBean.RetBean.ListBean moreURL = shouYeBean.getRet().getList().get(i);
                moreURL.setMoreURL(shouYeBean.getRet().getList().get(i).getMoreURL());
                list1.add(moreURL) ;
                childListBean.setPic(childListBean.getPic());
                childListBean.setTitle(childListBean.getTitle());
                list.add(childListBean);
            }

            if(adapter==null){

                adapter =new ClassifyAdapter(getContext(),list1);

                recyclerView.setAdapter(adapter);

            }else{
                adapter.notifyDataSetChanged();
            }
            }
        adapter.setOnitemclicklistener(new ClassifyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity() , ClassifyActivity.class);
                String catalogId = getCatalogId(list1.get(position).getMoreURL());
                intent.putExtra("catalogId" , catalogId);
                intent.putExtra("title" , list.get(position).getTitle());
                startActivity(intent);
            }
        });
        }
    public static String getCatalogId(String url) {
        String catalogId = "";
        String key = "catalogId=";
        if (!TextUtils.isEmpty(url) && url.contains("="))
            catalogId = url.substring(url.indexOf(key) + key.length(), url.lastIndexOf("&"));
        return catalogId;
    }

}
