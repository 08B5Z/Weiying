package com.example.administrator.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.administrator.weiying.R;
import com.youth.banner.Banner;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_choice extends Fragment {
    private View view;
    private Banner mBan;
    /**
     * 一念天堂
     */
    private EditText mFind;
    private RecyclerView mRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mBan = (Banner) view.findViewById(R.id.ban);
        mFind = (EditText) view.findViewById(R.id.find);
        mRv = (RecyclerView) view.findViewById(R.id.rv);
    }
}
