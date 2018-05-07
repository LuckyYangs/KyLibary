package com.ls.kylibary.vlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.kylibary.R;
import com.ls.kylibary.banner.GlideImageLoader;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.Transformer;
import com.ls.libarys.banner.listener.OnBannerListener;
import com.ls.libarys.utils.ToastUtil;
import com.ls.libarys.view.MarqueeView;
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
 * | 简  述: |  轮播图布局适配器                          |
 *  -----------------------------------------------
 */
 

public class MarqueeAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder>  {

    private Context mContext;
    private LayoutHelper mHelper;
    private List<String> mData;

    public MarqueeAdapter(Context mContext, LayoutHelper mHelper, List<String> mData) {
        this.mContext = mContext;
        this.mHelper = mHelper;
        this.mData = mData;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vlayout_news, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
//        recyclerViewHolder.tv_name.startWithList(mData);
        // 在代码里设置自己的动画
        recyclerViewHolder.tv_name.startWithList(mData, R.anim.anim_bottom_in, R.anim.anim_top_out);
        recyclerViewHolder.tv_name.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(mContext, textView.getText().toString(), Toast.LENGTH_SHORT).show();
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

        public MarqueeView tv_name;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.marqueeView1);
        }
    }
}
