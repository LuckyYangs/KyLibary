package com.ls.kylibary.main;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.ls.kylibary.R;
import com.ls.kylibary.banner.GlideImageLoader;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.Transformer;
import com.ls.libarys.banner.listener.OnBannerListener;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements OnBannerListener {
    Button bt_gomain;
    Banner banner2;
    public static List<String> images=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.nocolor),0);
        setContentView(R.layout.activity_guide);

        banner2=findViewById(R.id.ba_guide);
        bt_gomain=findViewById(R.id.bt_gomain);
        bt_gomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(GuideActivity.this,MainActivity.class);
                finish();
            }
        });
        String[] urls = getResources().getStringArray(R.array.urlg);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        banner2.setImages(images)
                .setImageLoader(new GlideImageLoader())//加载图片
                .setIndicatorGravity(Gravity.CENTER_HORIZONTAL)//设置指示器位置
                .setBannerAnimation(Transformer.ZoomOut)
                .setOnBannerListener(this)
                .start();
        banner2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             * This method will be invoked when the current page is scrolled, either as part
             * of a programmatically initiated smooth scroll or a user initiated touch scroll.
             *
             * @param position             Position index of the first page currently being displayed.
             *                             Page position+1 will be visible if positionOffset is nonzero.
             * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
             * @param positionOffsetPixels Value in pixels indicating the offset from position.
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position==2){
                    bt_gomain.setVisibility(View.VISIBLE);
                }else {
                    bt_gomain.setVisibility(View.INVISIBLE);
                }
            }

            /**
             * This method will be invoked when a new page becomes selected. Animation is not
             * necessarily complete.
             *
             * @param position Position index of the new selected page.
             */
            @Override
            public void onPageSelected(int position) {

            }

            /**
             * Called when the scroll state changes. Useful for discovering when the user
             * begins dragging, when the pager is automatically settling to the current page,
             * or when it is fully stopped/idle.
             *
             * @param state The new scroll state.
             * @see ViewPager#SCROLL_STATE_IDLE
             * @see ViewPager#SCROLL_STATE_DRAGGING
             * @see ViewPager#SCROLL_STATE_SETTLING
             */
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void OnBannerClick(int position) {

    }
}
