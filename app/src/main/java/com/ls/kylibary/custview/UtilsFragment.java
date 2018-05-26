package com.ls.kylibary.custview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ls.kylibary.R;
import com.ls.kylibary.banner.GlideImageLoader;
import com.ls.kylibary.main.MainActivity;
import com.ls.kylibary.vlayout.Common;
import com.ls.kylibary.vlayout.IconEntity;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.listener.OnBannerListener;
import com.ls.libarys.baseadapter.BaseQuickAdapter;
import com.ls.libarys.logger.Logger;
import com.ls.libarys.lsrefreshlayout.layout.LsRefreshLayout;
import com.ls.libarys.lsrefreshlayout.layout.api.RefreshLayout;
import com.ls.libarys.lsrefreshlayout.layout.listener.OnLoadMoreListener;
import com.ls.libarys.lsrefreshlayout.layout.listener.OnRefreshListener;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.ToastUtil;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UtilsFragment extends Fragment  {

    public static List<?> images=new ArrayList<>();
    public static List<String> titles=new ArrayList<>();
    private View view;
    private Toolbar toolbar;
    private TextView tilte;
    private Banner banner;
    private static final int PAGE_SIZE = 3;
    private RecyclerView recyclerView;
    private LsRefreshLayout refreshLayout;
    private List<IconEntity> utilsdata =new ArrayList<>();
    private UtilsBaseAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_guanggao, null);
        initData();
        intview();

        return view;
    }

    private void intview() {
        toolbar =view.findViewById(R.id.toolbara);
        tilte =view.findViewById(R.id.title);
        tilte.setText("Utils");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getActivity(), MainActivity.class);
                getActivity().finish();
            }
        });
        recyclerView=view.findViewById(R.id.util_rvlist);
        refreshLayout=view.findViewById(R.id.util_refreshLayout);
//创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        //创建适配器
        mAdapter = new UtilsBaseAdapter(getActivity(),R.layout.util_item_view, utilsdata);

        //给RecyclerView设置适配器
        recyclerView.setAdapter(mAdapter);
//        设置加载动画
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
//        动画只第一次加载
        mAdapter.isFirstOnly(true);
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.show(getActivity(),"This is "+utilsdata.get(position).getTitle());
            }
        });
        mAdapter.setHeaderView(getheadview());
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mAdapter.setNewData(utilsdata);
                refreshLayout.finishRefresh();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if(utilsdata.size()<34) {
                    mAdapter.addData(utilsdata);
                    refreshLayout.finishLoadMore();
                }else {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    refreshLayout.setNoMoreData(true);
                }
            }
        });
    }

    protected void initData() {
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles= new ArrayList(list1);

        getdata();

    }

    private View getheadview() {
        View view = getLayoutInflater().inflate(R.layout.bannar_item, (ViewGroup) recyclerView.getParent(), false);
        banner=view.findViewById(R.id.biv);

        banner .setImages(images).setImageLoader(new GlideImageLoader())
                .setBannerTitles(titles)
                .setIndicatorGravity(6)
                .setBannerStyle(1)
                .start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.show(getContext(),"别瞎点");
            }
        });
        return view;
    }


    private void getdata() {
        utilsdata.clear();
        StringBuilder dpstringBuilder = new StringBuilder();
        InputStream inputStream = null;
        try {
            inputStream = getResources().getAssets().open("util.json");
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
        Logger.json(result);
        Gson gson = new Gson();
        Common common = gson.fromJson(result, Common.class);
        utilsdata=common.getUtil();
    }




}
