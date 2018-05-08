package com.ls.kylibary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ls.kylibary.banner.BannarActivity;
import com.ls.kylibary.resfresh.ResFreshActivity;
import com.ls.kylibary.vlayout.BannerAdapter;
import com.ls.kylibary.vlayout.Common;
import com.ls.kylibary.vlayout.DpGridAdapter;
import com.ls.kylibary.vlayout.DpStragAdapter;
import com.ls.kylibary.vlayout.GnewAdapter;
import com.ls.kylibary.vlayout.GridAdapter;
import com.ls.kylibary.vlayout.GussAdapter;
import com.ls.kylibary.vlayout.IconEntity;
import com.ls.kylibary.vlayout.LinearAdapter;
import com.ls.kylibary.vlayout.MarqueeAdapter;
import com.ls.kylibary.vlayout.NewAdapter;
import com.ls.kylibary.vlayout.OnGridAdapter;
import com.ls.libarys.baseadapter.BaseQuickAdapter;
import com.ls.libarys.logger.AndroidLogAdapter;
import com.ls.libarys.logger.DiskLogAdapter;
import com.ls.libarys.logger.FormatStrategy;
import com.ls.libarys.logger.Logger;
import com.ls.libarys.logger.PrettyFormatStrategy;
import com.ls.libarys.recyclerviewitemDecoration.ListDecoration;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.DrawerLeftEdgeSize;
import com.ls.libarys.utils.StatusBarUtil;
import com.ls.libarys.vlayout.DelegateAdapter;
import com.ls.libarys.vlayout.VirtualLayoutManager;
import com.ls.libarys.vlayout.layout.GridLayoutHelper;
import com.ls.libarys.vlayout.layout.LinearLayoutHelper;
import com.ls.libarys.vlayout.layout.OnePlusNLayoutHelper;
import com.ls.libarys.vlayout.layout.StaggeredGridLayoutHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
 *  ------------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）         |
 *  ------------------------------------------------
 * | 时  间：| 2018/5/4                             |
 *  ------------------------------------------------
 * | 包  名：| com.ls.kylibary                      |
 *  ------------------------------------------------
 * | 类  名：| MainActivity                         |
 *  ------------------------------------------------
 * | 简  述: | <功能简述>                           |
 *  -----------------------------------------------
 */
 
 
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final Class<?>[] ACTIVITY = {ResFreshActivity.class, BannarActivity.class};
    private static final String[] TITLE = {"刷新", "轮播"};
    private static final int[] IMG = { R.mipmap.gv_pulltorefresh,R.mipmap.gv_animation};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;
    TextView tilte;
    private int mStatusBarColor;
    private int mAlpha = StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA;
    private boolean isDrawer=false;
    LinearLayout ll_main;
    NavigationView navigationView;
    DrawerLayout drawer;
    VirtualLayoutManager layoutManager;

    DelegateAdapter delegateAdapter;
    List<DelegateAdapter.Adapter> adapters;
    public List<String> titles=new ArrayList<>();
    public  List<String> images=new ArrayList<>();

    private List<IconEntity> iconlist=new ArrayList<>();
    private List<IconEntity> dplist=new ArrayList<>();
    private List<IconEntity> newlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mains);
        log();
        mStatusBarColor = ContextCompat.getColor(this,R.color.colorPrimary);
        StatusBarUtil.setColorForDrawerLayout(this, (DrawerLayout) findViewById(R.id.drawer_layout), mStatusBarColor, mAlpha);
        initView();
        initData();
//        initAdapter();

    }

    private void log() {




        Log.d("Tag", "I'm a log which you don't see easily, hehe");
        Log.d("json content", "{ \"key\": 3, \n \"value\": something}");
        Log.d("error", "There is a crash somewhere or any warning");

        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("message");

        Logger.clearLogAdapters();


        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(0)         // (Optional) How many method line to show. Default 2
                .methodOffset(3)        // (Optional) Skips some method invokes in stack trace. Default 5
//        .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag("My custom tag")   // (Optional) Custom tag for each log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });

        Logger.addLogAdapter(new DiskLogAdapter());


        Logger.w("no thread info and only 1 method");

        Logger.clearLogAdapters();
        formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        Logger.i("no thread info and method info");

        Logger.t("tag").e("Custom tag for only one use");

        Logger.json("{ \"key\": 3, \"value\": something}");

        Logger.d(Arrays.asList("foo", "bar"));

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value2");

        Logger.d(map);

        Logger.clearLogAdapters();
        formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .tag("MyTag")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        Logger.w("my log message with my tag");
    }

    private void initView() {

        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);//取消图标灰色效果
        navigationView.setNavigationItemSelectedListener(this);
        drawer =  findViewById(R.id.drawer_layout);
        drawer.openDrawer(GravityCompat.START);//设置一启动就显示菜单界面
        ll_main=findViewById(R.id.ll_main);
        Toolbar toolbar = findViewById(R.id.toolbara);
        tilte = findViewById(R.id.title);
        tilte.setText("复杂UI布局");
        toolbar.setNavigationIcon(R.mipmap.caidan);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        mRecyclerView =findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

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
    }

    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeAdapter(R.layout.home_item_view, mDataList);
        homeAdapter.openLoadAnimation();
        View top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);
        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, ACTIVITY[position]);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        String[] urls = getResources().getStringArray(R.array.url4);

        List list = Arrays.asList(urls);
        images = new ArrayList(list);

        String[] tips = getResources().getStringArray(R.array.titledata);
        List list1 = Arrays.asList(tips);
        titles= new ArrayList(list1);


//初始化VirtualLayoutManager对象，与RecycleView绑定
        layoutManager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
//设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        RecyclerView.RecycledViewPool recycledViewPool =new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,20);
        mRecyclerView.setRecycledViewPool(recycledViewPool);
//设置RecyclerView分割线,Item之间的间隔


        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(5, 5, 5, 5);
            }
        });

        delegateAdapter = new DelegateAdapter(layoutManager, true);

        mRecyclerView.setAdapter(delegateAdapter);
        adapters = new LinkedList<>();
//添加bannar布局----------------------------------------
        LinearLayoutHelper bHelper = new LinearLayoutHelper(1);
        delegateAdapter.addAdapter(new BannerAdapter(this, bHelper,images));

//添加分类布局---------------------------------------------------

        geticon();

        //构造中传入相应的列的数量
        GridLayoutHelper gridHelper = new GridLayoutHelper(4);
        gridHelper.setMarginTop(30);
//        gridHelper.setWeights(new float[]{20.0f,20.0f,20.0f,20.0f,20.0f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(5);
        //设置水平方向条目的间隔
        gridHelper.setHGap(5);
//        gridHelper.setMarginLeft(30);
//        gridHelper.setMarginRight(30);
        gridHelper.setMarginBottom(20);
        gridHelper.setBgColor(ContextCompat.getColor(this,R.color.white));
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        delegateAdapter.addAdapter(new GridAdapter(this, gridHelper,iconlist));

        ////添加广告格兰布局------------------------------------------------

        List<String> info2 = new ArrayList<>();
        info2.add("这个是用来搞笑的，不要在意这写小细节！");
        info2.add("啦啦啦啦，我就是来搞笑的！");

        LinearLayoutHelper linearHelpers = new LinearLayoutHelper(1);
//        linearHelpers.setMarginLeft(30);
//        linearHelpers.setMarginRight(30);
        linearHelpers.setBgColor(ContextCompat.getColor(this,R.color.white));
        delegateAdapter.addAdapter(new MarqueeAdapter(this, linearHelpers,info2));

        ////添加一拖N布局------------------------------------------------
        OnePlusNLayoutHelper helper = new OnePlusNLayoutHelper(4);
        helper.setBgColor(ContextCompat.getColor(this,R.color.white));
        helper.setMargin(10, 10, 10,10);
//        helper.setPadding(10, 10, 10,10);
        delegateAdapter.addAdapter(new OnGridAdapter(this, helper,iconlist));


      //添加店铺推荐格兰布局------------------------------------------------------

        LinearLayoutHelper dplinearHelpers = new LinearLayoutHelper(1);
        dplinearHelpers.setDividerHeight(10);
        dplinearHelpers.setMarginLeft(10);
        dplinearHelpers.setMarginRight(10);
        dplinearHelpers.setMarginTop(20);
        dplinearHelpers.setBgColor(ContextCompat.getColor(this,R.color.white));
        delegateAdapter.addAdapter(new GussAdapter(this, dplinearHelpers));
//添加推荐店铺布局--------------------------------------------------------------------
        gedp();
        GridLayoutHelper dpgridHelper = new GridLayoutHelper(2);
//
        dpgridHelper.setWeights(new float[]{50.0f,50.0f});
        //设置垂直方向条目的间隔
        dpgridHelper.setVGap(30);
        //设置水平方向条目的间隔
        dpgridHelper.setHGap(30);
        dpgridHelper.setMarginLeft(10);
        dpgridHelper.setMarginRight(10);
//        dpgridHelper.setMarginBottom(20);
        dpgridHelper.setBgColor(ContextCompat.getColor(this,R.color.white));
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        dpgridHelper.setAutoExpand(true);
        delegateAdapter.addAdapter(new DpGridAdapter(this, dpgridHelper,dplist));


        //添加热点新闻格兰布局----------------------------------------------
        LinearLayoutHelper newlinearHelpers = new LinearLayoutHelper(1);
        newlinearHelpers.setDividerHeight(10);
//        newlinearHelpers.setMarginLeft(30);
//        newlinearHelpers.setMarginRight(30);
        newlinearHelpers.setMarginTop(30);
        newlinearHelpers.setBgColor(ContextCompat.getColor(this,R.color.white));
        delegateAdapter.addAdapter(new GnewAdapter(this, newlinearHelpers));
        ////添加新闻Linear 布局----------------------------------------------
        getnew();
        LinearLayoutHelper newlinearHelper = new LinearLayoutHelper(1);
//        newlinearHelper.setMarginRight(30);
//        newlinearHelper.setMarginLeft(30);
        newlinearHelper.setMarginTop(15);
        newlinearHelper.setDividerHeight(10);
        newlinearHelper.setBgColor(ContextCompat.getColor(this,R.color.white));
        delegateAdapter.addAdapter(new NewAdapter(this, newlinearHelper,newlist));

        /**
         设置瀑布流布局////添加瀑布流布局--------------------------------------------------------
         */

        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper();
        // 创建对象

        // 公有属性
        staggeredGridLayoutHelper.setItemCount(20);// 设置布局里Item个数
//        staggeredGridLayoutHelper.setPadding(10, 10, 10, 10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        staggeredGridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        staggeredGridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        staggeredGridLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        // 特有属性
        staggeredGridLayoutHelper.setLane(2);// 设置控制瀑布流每行的Item数
        staggeredGridLayoutHelper.setHGap(10);// 设置子元素之间的水平间距
        staggeredGridLayoutHelper.setVGap(10);// 设置子元素之间的垂直间距
        delegateAdapter.addAdapter(new DpStragAdapter(this, staggeredGridLayoutHelper,dplist));


    }

    private void getnew() {
        StringBuilder newstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open("news.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                newstringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result =  newstringBuilder .toString();
        Log.d("json",result);
        Gson gson = new Gson();
        Common common = gson.fromJson(result, Common.class);
        newlist=common.getNews();
    }

    private void gedp() {
        StringBuilder dpstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open("shop.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                dpstringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result =  dpstringBuilder .toString();
        Log.d("json",result);
        Gson gson = new Gson();
        Common common = gson.fromJson(result, Common.class);
        dplist=common.getShop();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void geticon() {

        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open("icon.json");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isr);
            String jsonLine;
            while ((jsonLine = reader.readLine()) != null) {
                stringBuilder.append(jsonLine);
            }
            reader.close();
            isr.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result =  stringBuilder .toString();
        Log.d("json",result);
        Gson gson = new Gson();
        Common common = gson.fromJson(result, Common.class);
        iconlist=common.getIcom();
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

        } else if (id == R.id.nav_tby) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
