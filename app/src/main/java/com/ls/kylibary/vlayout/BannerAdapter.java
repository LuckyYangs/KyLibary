package com.ls.kylibary.vlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ls.kylibary.R;
import com.ls.kylibary.banner.GlideImageLoader;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.Transformer;
import com.ls.libarys.banner.listener.OnBannerListener;
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
 * | 简  述: |  轮播图布局适配器                          |
 *  -----------------------------------------------
 */
 

public class BannerAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> implements OnBannerListener {

    private Context mContext;
    private LayoutHelper mHelper;
    private List<String> mData;

    public BannerAdapter(Context mContext, LayoutHelper mHelper, List<String> mData) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bannar_item, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
        recyclerViewHolder.tv_name.setImages(mData)
                .setImageLoader(new GlideImageLoader())//加载图片
                .setIndicatorGravity(5)//设置指示器位置
                .setBannerAnimation(Transformer.ZoomOut)
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public void OnBannerClick(int position) {
        ToastUtil.show(mContext,"您点击了第"+position+"图片");
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public Banner tv_name;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.biv);
        }
    }
}
