package com.example.administrator.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.model.bean.CommentaryBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */

public class CommentAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<CommentaryBean.RetBean.ListBean> list = new ArrayList<>();

    public CommentAdapter(Context context, List<CommentaryBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent, false);
        return new MyCommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CommentaryBean.RetBean.ListBean listBean = list.get(position);
        MyCommentViewHolder myCommentViewHolder = (MyCommentViewHolder) holder;
        myCommentViewHolder.name.setText(listBean.getPhoneNumber());
        myCommentViewHolder.time.setText(listBean.getTime());
        myCommentViewHolder.commentary.setText(listBean.getMsg());
        Uri parse = Uri.parse(listBean.getUserPic());
        myCommentViewHolder.sdv.setImageURI(parse);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyCommentViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView name;
        private final TextView time;
        private final TextView commentary;

        public MyCommentViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            name = itemView.findViewById(R.id.name);
            time = itemView.findViewById(R.id.time);
            commentary = itemView.findViewById(R.id.commentary);
        }
    }
}
