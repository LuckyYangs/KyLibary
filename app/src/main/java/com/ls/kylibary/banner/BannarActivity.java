package com.ls.kylibary.banner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.ls.kylibary.BaseActivity;
import com.ls.kylibary.MainActivity;
import com.ls.kylibary.R;
import com.ls.libarys.bottombar.BottomNavigationBar;
import com.ls.libarys.bottombar.BottomNavigationItem;
import com.ls.libarys.utils.ActivityUtil;

import java.util.ArrayList;

public class BannarActivity extends BaseActivity {
    private TextView tilte;
    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    Toolbar toolbar;
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_bannar);
    }

    @Override
    protected void initView() {
        toolbar =findViewById(R.id.toolbara);
        tilte = findViewById(R.id.title);
        tilte.setText("BannerView");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getApplicationContext(),MainActivity.class);
                finish();
            }
        });

        mVpHome =  findViewById(R.id.vp_home);
        mBottomNavigationBar =  findViewById(R.id.bottom_navigation_bar);
//        mBottomNavigationBar.setBackgroundColor(R.color.colorPrimary); 设置背景颜色
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mFragmentList.add(new DollFragment());
        mFragmentList.add(new JuxingFragment());
        mFragmentList.add(new GuanggaoFragment());
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ab, "圆点"))
                .addItem(new BottomNavigationItem(R.mipmap.app, "长条"))
                .addItem(new BottomNavigationItem(R.mipmap.zfj, "广告"))
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mVpHome.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mVpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

    }

    @Override
    protected void initData() {


    }



    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtil.startAty(this,MainActivity.class);
        finish();
    }
}
