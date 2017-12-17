package com.example.administrator.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.model.bean.NewsBean;
import com.facebook.drawee.view.SimpleDraweeView;


/**
 * Created by せしおゆ on 2017/11/21.
 */

public class MyRecyAdapter extends RecyclerView.Adapter<MyRecyAdapter.MyViewHolder>{
    Context context;
    NewsBean newsBean;

    public MyRecyAdapter(Context context, NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.find_item, parent, false);
        MyViewHolder myviewHolder = new MyViewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_title.setText(newsBean.getRet().getList().get(position).getTitle());
        holder.message.setText(newsBean.getRet().getList().get(position).getDescription());
        String ss=newsBean.getRet().getList().get(position).getPic();
        Uri uri=Uri.parse(ss);
        holder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return newsBean.getRet().getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView img;
        TextView tv_title,message;
        public MyViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv_title=itemView.findViewById(R.id.tv_title);
            message=itemView.findViewById(R.id.tv_message);
        }
    }
}
