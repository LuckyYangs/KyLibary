package com.ls.libarys.lsrefreshlayout.layout.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 默认Footer创建器
 * Created by SCWANG on 2018/1/26.
 */

/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间：2018/4/11
 * 包  名：com.scwang.smartrefresh.layout.api
 * 类  名： DefaultRefreshFooterCreator
 * 简  述:  <功能简述>
 */
public interface DefaultRefreshFooterCreator {
    @NonNull
    RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout);
}
