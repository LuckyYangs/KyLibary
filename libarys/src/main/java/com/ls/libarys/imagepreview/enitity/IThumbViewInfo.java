package com.ls.libarys.imagepreview.enitity;

import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 *         Deprecated: 图片预览接口
 */
public interface IThumbViewInfo extends Parcelable {
    /****
     * 图片地址
     * @return String
     * ****/
    String getUrl();

    /**
     * 记录坐标
     * @return Rect
     ***/
    Rect getBounds();


    /**
     * 获取视频链接
     * ***/
    @Nullable
    String getVideoUrl();


}
