package com.ls.kylibary.banner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.kylibary.R;
import com.ls.kylibary.main.MainActivity;
import com.ls.kylibary.resfresh.ResFreshActivity;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.BannerConfig;
import com.ls.libarys.banner.Transformer;
import com.ls.libarys.banner.listener.OnBannerListener;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间：2018/4/28
 * 包  名：com.ls.kylibary.banner
 * 类  名： BannerFragment
 * 简  述:
 */

public class BannerFragment extends Fragment implements OnBannerListener {
    Banner banner1;
    Banner banner2;
    Banner banner3;
    private Toolbar toolbar;
    private TextView tilte;
    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=View.inflate(getActivity(),R.layout.fragment_doll, null);
        banner1=view.findViewById(R.id.banner2);
        banner2=view.findViewById(R.id.banner1);
        banner3=view.findViewById(R.id.banner3);

        toolbar =view.findViewById(R.id.toolbara);
        tilte =view.findViewById(R.id.title);
        tilte.setText("BannerView");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getActivity(),MainActivity.class);
                getActivity().finish();
            }
        });
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles= new ArrayList(list1);
        banner2.setImages(images)
                .setImageLoader(new GlideImageLoader())//加载图片
                .setIndicatorGravity(5)//设置指示器位置
                .setBannerAnimation(Transformer.ZoomOut)
                .setOnBannerListener(this)
                .start();
        banner1.setImages(images).setBannerTitles(titles)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImageLoader())
                .setBannerAnimation(Transformer.FlipVertical)//设置动画
                .setOnBannerListener(this).start();
        banner3.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setIndicatorGravity(6)//设置指示器位置
                .setOnBannerListener(this)
                .setBannerAnimation(Transformer.Tablet)//设置动画
                .start();
        return  view;
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
