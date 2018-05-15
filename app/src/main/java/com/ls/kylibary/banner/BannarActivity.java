package com.ls.kylibary.banner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.ls.kylibary.BaseActivity;
import com.ls.kylibary.custview.UtilsFragment;
import com.ls.kylibary.main.MainActivity;
import com.ls.kylibary.R;
import com.ls.kylibary.custview.CustViewFragment;
import com.ls.libarys.bottombar.BottomNavigationBar;
import com.ls.libarys.bottombar.BottomNavigationItem;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.StringsUtil;

import java.util.ArrayList;

public class BannarActivity extends BaseActivity {

    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private String type;
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_bannar);
    }

    @Override
    protected void initView() {
        type=getIntent().getStringExtra("type");


        mVpHome =  findViewById(R.id.vp_home);
        mBottomNavigationBar =  findViewById(R.id.bottom_navigation_bar);
//        mBottomNavigationBar.setBackgroundColor(R.color.colorPrimary); 设置背景颜色
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mFragmentList.add(new BannerFragment());
        mFragmentList.add(new CustViewFragment());
        mFragmentList.add(new UtilsFragment());
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ab, "Banner"))
                .addItem(new BottomNavigationItem(R.mipmap.app, "CustView"))
                .addItem(new BottomNavigationItem(R.mipmap.zfj, "Utils"))
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
        setcurrent();
    }

    private void setcurrent() {

       if (StringsUtil.equals(type,"custview")) {
           mVpHome.setCurrentItem(1);
       }else if (StringsUtil.equals(type,"utils")){
           mVpHome.setCurrentItem(2);
       }


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
