package com.ls.libarys.utils;

import android.widget.ImageView;

import com.ls.libarys.R;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;


public class ImageUtils {


    /**
     * 显示圆角图片
     *
     * @param imageView 图像控件
     * @param iconUrl   图片地址
     * @param radius    圆角半径，
     */
    public static void display(ImageView imageView, String iconUrl, int radius) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setRadius(DensityUtil.dip2px(radius))
                .setIgnoreGif(false)
                //是否对图片进行裁剪
                .setCrop(true)
                .setUseMemCache(true)
                .setUseMemCache(true)
//                .setFailureDrawableId(R.mipmap.ic_launcher)
                .setLoadingDrawableId(R.drawable.loading)
                .build();
                x.image().bind(imageView, iconUrl, imageOptions);
    }

    /**
     * 显示圆形头像，第三个参数为true
     *
     * @param imageView  图像控件
     * @param iconUrl    图片地址
     * @param isCircluar 是否显示圆形
     */
    public static void display(ImageView imageView, String iconUrl, boolean isCircluar) {
        ImageOptions imageOptions = new ImageOptions.Builder()
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setCircular(isCircluar)
                .setCrop(true)
                .setIgnoreGif(true)
                .setUseMemCache(true)
                .setLoadingDrawableId(R.drawable.loading)
//                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
                x.image().bind(imageView, iconUrl, imageOptions);
    }

}
