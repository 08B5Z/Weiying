package com.example.administrator.weiying.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.weiying.R;
import com.example.administrator.weiying.model.bean.ShouYeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/14.
 */

public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.ClassifyViewHolder> {
    private Context context;
    private List<ShouYeBean.RetBean.ListBean> list = new ArrayList<>();

    private OnItemClickListener onitemclicklistener = null;
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public void setOnitemclicklistener(OnItemClickListener onitemclicklistener) {
        this.onitemclicklistener = onitemclicklistener;
    }

    public ClassifyAdapter(Context context, List<ShouYeBean.RetBean.ListBean> shouYeBean) {
        this.context = context;
        this.list = shouYeBean;
    }

    @Override
    public ClassifyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context , R.layout.zhuantiitem , null);
        return new ClassifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClassifyViewHolder holder, final int position) {

        holder.textView.setText(list.get(position).getTitle());
        String s = list.get(position).getChildList().get(position).getPic();
        Uri uri = Uri.parse(s);
        holder.imageView.setImageURI(uri);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclicklistener.onItemClick(v , position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ClassifyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ClassifyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.miv);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
