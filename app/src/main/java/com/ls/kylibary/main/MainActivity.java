package com.ls.kylibary.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.ls.kylibary.R;
import com.ls.kylibary.banner.BannarActivity;
import com.ls.kylibary.resfresh.ResFreshActivity;
import com.ls.libarys.bottombar.BottomNavigationBar;
import com.ls.libarys.bottombar.BottomNavigationItem;
import com.ls.libarys.logger.AndroidLogAdapter;
import com.ls.libarys.logger.Logger;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.DrawerLeftEdgeSize;
import com.ls.libarys.utils.StatusBarUtil;

import java.util.ArrayList;

/**
 
              .---.          .-----------
             /  /   \  __  /    ------
            / /  //  \(  )/    -----
           //////    ' \/ `   ---
          //// /     :    : ---
         // /        `    '--
        //           //..\\
       =============UU====UU================
                    '//||\\`
                      ''``
 *  -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）         
 *  -----------------------------------------------
 * | 时  间：| 2018/5/14                               
 *  -----------------------------------------------
 * | 包  名：| com.ls.kylibary.main                      |
 *  -----------------------------------------------
 * | 类  名：| MainActivity                        
 *  -----------------------------------------------
 * | 简  述: | <功能简述>                          
 *  -----------------------------------------------
 */
 


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    interface ViewType {
        int BANNER = 1;
        int MENU = 2;
        int TOUTIAO = 3;
        int ONETON = 4;
        int SHOPTITLE= 5;
        int SHOP = 6;
        int NEWTITLE= 7;
        int NEW= 8;
        int STRAGLE = 9;
    }
    private int mStatusBarColor;
    private int mAlpha = StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA;
    LinearLayout ll_main;
    NavigationView navigationView;
    DrawerLayout drawer;
    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        Logger.addLogAdapter(new AndroidLogAdapter());
        mStatusBarColor = ContextCompat.getColor(this,R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
        initView();
        initData();
    }


    private void initView() {

        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);//取消图标灰色效果
        navigationView.setNavigationItemSelectedListener(this);
        drawer =  findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);//设置一启动就显示菜单界面
        ll_main=findViewById(R.id.ll_main);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        DrawerLeftEdgeSize.setLeftEdgeSize(this,drawer,0.1f);

//设置屏幕跟随滑动
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的ll_main作为右面布局的navigationView   左面的ll_main+屏幕的宽度（或者ll_main的宽度这里是相等的）为右面布局的ll_main
                ll_main.layout(navigationView.getRight(), 0, navigationView.getRight() + display.getWidth(), display.getHeight());


            }
            @Override
            public void onDrawerOpened(View drawerView) {

            }
            @Override
            public void onDrawerClosed(View drawerView) {

            }
            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        mVpHome =  findViewById(R.id.vp_main);
        mVpHome.setOffscreenPageLimit(5);
        mBottomNavigationBar =  findViewById(R.id.mainbottom_navigation_bar);
//        mBottomNavigationBar.setBackgroundColor(R.color.colorPrimary); 设置背景颜色
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mFragmentList.add(new ShopFragment());
        mFragmentList.add(new ShiciFragment());
        mFragmentList.add(new MusicFragment());
        mFragmentList.add(new VedioFragment());
        mFragmentList.add(new MeFragment());
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.store_red, "商城"))
                .addItem(new BottomNavigationItem(R.mipmap.shici_red, "诗词"))
                .addItem(new BottomNavigationItem(R.mipmap.music_red, "音乐"))
                .addItem(new BottomNavigationItem(R.mipmap.video_red, "视频"))
                .addItem(new BottomNavigationItem(R.mipmap.me_red, "我"))
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


    private void initData() {

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_tbc) {

        } else if (id == R.id.nav_refresh) {
            ActivityUtil.startAty(this,ResFreshActivity.class);
        } else if (id == R.id.nav_banner) {
            ActivityUtil.startAty(this,BannarActivity.class);
        } else if (id == R.id.nav_tool) {
            ActivityUtil.startWithdata(this,"type","utils",BannarActivity.class);
        } else if (id == R.id.nav_tby) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
