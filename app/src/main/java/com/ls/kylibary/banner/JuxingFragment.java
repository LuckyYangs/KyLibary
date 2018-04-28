package com.ls.kylibary.banner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ls.kylibary.R;
import com.ls.libarys.lybanner.LsBanner;
import com.ls.libarys.lybanner.Transformer;
import com.ls.libarys.lybanner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JuxingFragment extends Fragment implements OnBannerListener {

    LsBanner banner2;
    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.fragment_juxing, container, false);
        banner2=view.findViewById(R.id.banner2);
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles= new ArrayList(list1);
        banner2.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(6)//设置指示器位置
                .setOnBannerListener(this)
                .setBannerAnimation(Transformer.ScaleInOut)//设置动画
                .start();
        return view;
    }
    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getActivity(), "执行相关点击操作", Toast.LENGTH_SHORT).show();
    }

    //如果你需要考虑更好的体验，可以这么操作


    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner2.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //开始轮播
        banner2.stopAutoPlay();
    }
}
