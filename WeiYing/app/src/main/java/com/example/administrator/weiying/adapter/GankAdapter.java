package com.example.administrator.weiying.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.model.bean.GankBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by DELL on 2017/12/16.
 */

public class GankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<GankBean.ResultsBean> list;

    public GankAdapter(Context context, List<GankBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.gank_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        String url = list.get(position).getUrl();
        ImageLoader.getInstance().displayImage(url,myViewHolder.gank_iv);
    }

    @Override
    public int getItemCount() {
        return list.size()!=0?list.size():0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView gank_iv;

        public MyViewHolder(View itemView) {
            super(itemView);
            gank_iv = itemView.findViewById(R.id.gank_iv);
        }
    }
}
