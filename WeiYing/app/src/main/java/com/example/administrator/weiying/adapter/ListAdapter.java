package com.example.administrator.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.model.bean.ShouYeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/13.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ShouYeBean.RetBean.ListBean.ChildListBean> list = new ArrayList<>();
    private OnClickListener onClickListener;

    public interface OnClickListener{
        void OnClick(int position);
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    public ListAdapter(Context context, List<ShouYeBean.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ShouYeBean.RetBean.ListBean.ChildListBean childListBean = list.get(position);
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.tv.setText(childListBean.getTitle());
        Uri parse = Uri.parse(childListBean.getPic());
        myViewHolder.sdv.setImageURI(parse);
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onClickListener!=null){
                    onClickListener.OnClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv = itemView.findViewById(R.id.tv);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
