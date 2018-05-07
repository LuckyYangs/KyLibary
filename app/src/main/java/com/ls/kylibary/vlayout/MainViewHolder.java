package com.ls.kylibary.vlayout;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间：2018/5/3
 * 项目名：KyLibary
 * 包  名：com.ls.kylibary
 * 类  名：  Activity
 * 简  述:  <功能简述>
 */
public class MainViewHolder extends RecyclerView.ViewHolder {
    public static volatile int existing = 0;
    public static int createdTimes = 0;

    public MainViewHolder(View itemView) {
        super(itemView);
        createdTimes++;
        existing++;
    }

    @Override
    protected void finalize() throws Throwable {
        existing--;
        super.finalize();
    }
}
