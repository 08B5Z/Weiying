package com.example.administrator.weiying.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.activity.DetailActivity;
import com.example.administrator.weiying.model.bean.DetailBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/14.
 */

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<DetailBean.RetBean.ListBean.ChildListBean> childlist = new ArrayList<>();
    private OnClickListener onClickListener;

    public interface OnClickListener{
        void OnClick(int position);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public GridAdapter(Context context, List<DetailBean.RetBean.ListBean.ChildListBean> childlist) {
        this.context = context;
        this.childlist = childlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tui_item, parent, false);
        return new MyListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DetailBean.RetBean.ListBean.ChildListBean childListBean = childlist.get(position);
        MyListViewHolder myListViewHolder = (MyListViewHolder) holder;
        myListViewHolder.title.setText(childListBean.getTitle());
        Uri parse = Uri.parse(childListBean.getPic());
        myListViewHolder.sdv.setImageURI(parse);
        myListViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                String dataId = childListBean.getDataId();
                intent.putExtra("dataId",dataId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return childlist.size();
    }

    class MyListViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final SimpleDraweeView sdv;
        private final LinearLayout ll;

        public MyListViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            sdv = itemView.findViewById(R.id.sdv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
