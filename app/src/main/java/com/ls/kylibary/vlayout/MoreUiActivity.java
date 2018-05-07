package com.ls.kylibary.vlayout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ls.kylibary.BaseActivity;
import com.ls.kylibary.R;
import com.ls.libarys.vlayout.DelegateAdapter;
import com.ls.libarys.vlayout.VirtualLayoutManager;
import com.ls.libarys.vlayout.layout.GridLayoutHelper;
import com.ls.libarys.vlayout.layout.LinearLayoutHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoreUiActivity extends BaseActivity {

    RecyclerView recyclerView;

    VirtualLayoutManager layoutManager;

    DelegateAdapter delegateAdapter;
    List<DelegateAdapter.Adapter> adapters;
    public  List<String> titles=new ArrayList<>();
    public  List<String> images=new ArrayList<>();

    private List<IconEntity> iconlist=new ArrayList<>();
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_moreui);
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_view);

    }

    @Override
    protected void initData() {
        String[] urls = getResources().getStringArray(R.array.url4);

        List list = Arrays.asList(urls);
        images = new ArrayList(list);

        String[] tips = getResources().getStringArray(R.array.titledata);
        List list1 = Arrays.asList(tips);
        titles= new ArrayList(list1);


//初始化VirtualLayoutManager对象，与RecycleView绑定
        layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//设置回收复用池大小，（如果一屏内相同类型的 View 个数比较多，需要设置一个合适的大小，防止来回滚动时重新创建 View）
        RecyclerView.RecycledViewPool recycledViewPool =new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(0,20);
        recyclerView.setRecycledViewPool(recycledViewPool);
//设置RecyclerView分割线
        RecyclerView.ItemDecoration itemDecoration = new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int position = ((VirtualLayoutManager.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
                outRect.set(4, 4, 4, 4);
            }
        };

        delegateAdapter = new DelegateAdapter(layoutManager, true);

        recyclerView.setAdapter(delegateAdapter);
        adapters = new LinkedList<>();
//添加bannar布局
        LinearLayoutHelper bHelper = new LinearLayoutHelper(1);
        delegateAdapter.addAdapter(new BannerAdapter(this, bHelper,images));

        geticon();

        //构造中传入相应的列的数量
        GridLayoutHelper gridHelper = new GridLayoutHelper(8);
        gridHelper.setMarginTop(30);
//        gridHelper.setWeights(new float[]{20.0f,20.0f,20.0f,20.0f,20.0f});
        //设置垂直方向条目的间隔
        gridHelper.setVGap(5);
        //设置水平方向条目的间隔
        gridHelper.setHGap(5);
        gridHelper.setMarginLeft(30);
        gridHelper.setMarginBottom(30);
        //自动填充满布局，在设置完权重，若没有占满，自动填充满布局
        gridHelper.setAutoExpand(true);
        delegateAdapter.addAdapter(new GridAdapter(this, gridHelper,iconlist));

        ////添加Linear 布局
        LinearLayoutHelper linearHelper = new LinearLayoutHelper(1);
        delegateAdapter.addAdapter(new LinearAdapter(this, linearHelper,titles));
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
    public void onClick(View v) {

    }


}
