package com.ls.kylibary.vlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.kylibary.R;
import com.ls.libarys.utils.ToastUtil;
import com.ls.libarys.vlayout.DelegateAdapter;
import com.ls.libarys.vlayout.LayoutHelper;

import java.util.List;

/**

             /~~~~~\        /~~~~~\
            |    (~'        ~~~)   |
             \    \__________/    /
             /~::::::::         ~\
  /~~~~~~~-_| ::::::::             |_-~~~~~~~\
 \ ======= /|  ::A::;      A     :|\ ====== /
  ~-_____-~ |  _----------------_::| ~-____-~
            |/~                  ~\|
            /                      \
           (        ()    ()        )
            `\                   ./'
              ~-_______________-~
                     /~~~~\
                    |      |
                    |      |
                   (________)
                       ()
 *  -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）        
 *  -----------------------------------------------
 * | 时  间：| 2018/5/7                             
 *  -----------------------------------------------
 * | 包  名：| com.ls.kylibary.vlayout                     
 *  -----------------------------------------------
 * | 类  名：| LinearAdapter.java                             
 *  -----------------------------------------------
 * | 简  述: |  线性布局适配器                          |
 *  -----------------------------------------------
 */
 

public class GussAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private LayoutHelper mHelper;

    public GussAdapter(Context mContext, LayoutHelper mHelper) {
        this.mContext = mContext;
        this.mHelper = mHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.like_item, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
        recyclerViewHolder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(mContext,"跳入全部商家界面");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public TextView tv_name;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_more);
        }
    }
}
