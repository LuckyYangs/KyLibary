package com.ls.kylibary.vlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ls.kylibary.R;
import com.ls.kylibary.banner.BannarActivity;
import com.ls.kylibary.resfresh.ResFreshActivity;
import com.ls.libarys.utils.ActivityUtil;
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


public class OnGridAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder>  {

    private Context mContext;
    private LayoutHelper mHelper;
    private List<IconEntity> mData;

    public OnGridAdapter(Context mContext, LayoutHelper mHelper, List<IconEntity> mData) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.on_item, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
        recyclerViewHolder.tv_on.setText(mData.get(position).getTitle());
        Glide.with(mContext).load(mData.get(position).getImageUrl()).placeholder(R.mipmap.sxjz).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(recyclerViewHolder.iv_title);
        recyclerViewHolder.gd_itme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 1:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 2:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 3:
                        ActivityUtil.startAty(mContext, BannarActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }



    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        private ImageView iv_title;
        private FrameLayout gd_itme;
        private TextView tv_on;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            iv_title = itemView.findViewById(R.id.iv_otn);
            gd_itme = itemView.findViewById(R.id.ont_itme);
            tv_on = itemView.findViewById(R.id.tv_on);
        }
    }
}
