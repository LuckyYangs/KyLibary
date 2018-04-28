package com.ls.kylibary.banner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ls.kylibary.R;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.Transformer;
import com.ls.libarys.banner.listener.OnBannerListener;
import com.ls.libarys.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JuxingFragment extends Fragment implements OnBannerListener {

    Banner banner2;
    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_juxing, null);

        banner2=view.findViewById(R.id.banner2);
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles= new ArrayList(list1);
//
        banner2.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(6)//设置指示器位置
                .setOnBannerListener(this)
                .setBannerAnimation(Transformer.Tablet)//设置动画
                .start();
        return view;
    }
    @Override
    public void OnBannerClick(int position) {
        ToastUtil.show(getActivity(), "您点击了第"+position+"张图片");
    }

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
