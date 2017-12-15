package com.example.administrator.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.adapter.MyRecyAdapter;
import com.example.administrator.weiying.model.bean.NewsBean;
import com.example.administrator.weiying.presenter.RecyPresenter;
import com.example.administrator.weiying.view.IRecyView;
import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.administrator.weiying.R.id.mrv;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_find extends Fragment implements IRecyView{
    int page;
    @BindView(mrv)
    RecyclerView mMrv;
    Button change;
    TextView tvchange;
    private Unbinder unbinder;
    RecyPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment03, container, false);
        change=view.findViewById(R.id.change);
        tvchange=view.findViewById(R.id.tv_change);
        page=1;
        String pnumm=String.valueOf(page);
        presenter=new RecyPresenter(Fragment_find.this);
        presenter.relevance("402834815584e463015584e539330016",pnumm);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page=getNextPage();
                String pnum=String.valueOf(page);
                presenter.relevance("402834815584e463015584e539330016",pnum);
            }
        });
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getData(NewsBean newsBean) {
        List<NewsBean.RetBean.ListBean> list=newsBean.getRet().getList();
        List<String> imglist=new ArrayList<>();
        List<String> title=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            String img=list.get(i).getPic();
            imglist.add(img);
        }
        MyRecyAdapter mAdapter=new MyRecyAdapter(getActivity(),newsBean);
        mMrv.setLayoutManager(new OverLayCardLayoutManager());
        CardConfig.initConfig(getActivity());
        ItemTouchHelper.Callback callback = new RenRenCallback(mMrv, mAdapter,list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mMrv);
        mMrv.setAdapter(mAdapter);
    }
    private int getNextPage() {

        page = getRandomNumber(1, 108);

        return page;
    }
    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }
}
