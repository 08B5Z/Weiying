package com.example.administrator.weiying.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.weiying.R;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Fragment_mine extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout mHistory;
    private LinearLayout mCache;
    private LinearLayout mShoucang;
    private LinearLayout mZhuti;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mHistory = (LinearLayout) view.findViewById(R.id.history);
        mHistory.setOnClickListener(this);
        mCache = (LinearLayout) view.findViewById(R.id.cache);
        mCache.setOnClickListener(this);
        mShoucang = (LinearLayout) view.findViewById(R.id.shoucang);
        mShoucang.setOnClickListener(this);
        mZhuti = (LinearLayout) view.findViewById(R.id.zhuti);
        mZhuti.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.history:
               break;
            case R.id.cache:
                Toast.makeText(getActivity(), "敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shoucang:

                break;
            case R.id.zhuti:
                break;
        }
    }
}
