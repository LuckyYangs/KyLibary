package com.ls.kylibary.vlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
 

public class NewAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private LayoutHelper mHelper;
    private List<IconEntity> mData;

    public NewAdapter(Context mContext, LayoutHelper mHelper, List<IconEntity> mData) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item, parent, false);
        return new RecyclerViewItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        RecyclerViewItemHolder recyclerViewHolder = (RecyclerViewItemHolder) holder;
        recyclerViewHolder.tv_newt.setText(mData.get(position).getTitle());
        recyclerViewHolder.tv_newc.setText(mData.get(position).getContent());
        Glide.with(mContext).load(mData.get(position).getImageUrl()).placeholder(R.mipmap.sxjz).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(recyclerViewHolder.iv_new);
        recyclerViewHolder.ll_new.setOnClickListener(new View.OnClickListener() {
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
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 4:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 5:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 6:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    case 7:
                        ToastUtil.show(mContext,"敬请期待");
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 正常条目的item的ViewHolder
     */
    private class RecyclerViewItemHolder extends RecyclerView.ViewHolder {

        public TextView tv_newt;
        public ImageView iv_new;
        public TextView tv_newc;
        LinearLayout ll_new;

        public RecyclerViewItemHolder(View itemView) {
            super(itemView);
            iv_new = itemView.findViewById(R.id.iv_new);
            tv_newt = itemView.findViewById(R.id.tv_newt);
            tv_newc = itemView.findViewById(R.id.tv_newc);
            ll_new = itemView.findViewById(R.id.ll_new);
        }
    }
}
