package com.ls.kylibary.banner;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ls.kylibary.R;
import com.ls.libarys.banner.loader.ImageLoader;


public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context.getApplicationContext()).load(path).placeholder(R.drawable.nav_header_bg).into(imageView);
    }

}
