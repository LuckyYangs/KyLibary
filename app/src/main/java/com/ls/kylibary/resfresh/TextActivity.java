package com.ls.kylibary.resfresh;

import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ls.kylibary.BaseActivity;
import com.ls.kylibary.R;
import com.ls.libarys.lsrefreshlayout.header.StoreHouseHeader;
import com.ls.libarys.lsrefreshlayout.layout.LsRefreshLayout;
import com.ls.libarys.lsrefreshlayout.layout.api.RefreshHeader;
import com.ls.libarys.lsrefreshlayout.layout.api.RefreshLayout;
import com.ls.libarys.lsrefreshlayout.layout.listener.OnLoadMoreListener;
import com.ls.libarys.lsrefreshlayout.layout.listener.OnRefreshListener;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class TextActivity extends BaseActivity {

    ListView lv;
    TextView tilte;
    ArrayAdapter<String> adapter;
    private LsRefreshLayout refreshLayout;
    ArrayList data = new ArrayList();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_text);
    }

    @Override
    protected void initView() {
        Toolbar toolbar = findViewById(R.id.toolbara);
        tilte = findViewById(R.id.title);
        lv = findViewById(R.id.tlv);
        tilte.setText("文字模式");
        refreshLayout = findViewById(R.id.rfyt);
        refreshLayout.setEnableFooterFollowWhenLoadFinished(true);
        refreshLayout.setRefreshHeader(new StoreHouseHeader(getApplication()));
        RefreshHeader refreshHeader =refreshLayout.getRefreshHeader();
//            ((StoreHouseHeader) refreshHeader).initWithString("M D");
        ((StoreHouseHeader) refreshHeader).initWithPointList(getPointList());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getApplicationContext(), ResFreshActivity.class);
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        intdata();

        adapter = new ArrayAdapter<String>(this, R.layout.item, data);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.show(getApplicationContext(), "你点击了第" + position + "条数据");
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (data.size() < 20) {
                    adddata();
                    adapter.notifyDataSetChanged();
                    refreshLayout.finishLoadMore();
                } else {
                    refreshLayout.finishLoadMore();
                    refreshLayout.setNoMoreData(true);
                }
            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.setNoMoreData(false);
                intdata();
                adapter.notifyDataSetChanged();
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


    private  void adddata() {
        for (int j=0;j<5;j++){
            data.add("新增第"+j+"条数据");

        }
    }
    private  void intdata() {
        data.clear();
        for (int i=0;i<10;i++){
            data.add("第"+i+"条数据");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityUtil.startAty(this,ResFreshActivity.class);
        finish();
    }

    private List<float[]> getPointList() {
        // this point is taken from https://github.com/cloay/CRefreshLayout
        List<Point> startPoints = new ArrayList<>();
        startPoints.add(new Point(240, 80));
        startPoints.add(new Point(270, 80));
        startPoints.add(new Point(265, 103));
        startPoints.add(new Point(255, 65));
        startPoints.add(new Point(275, 80));
        startPoints.add(new Point(275, 80));
        startPoints.add(new Point(302, 80));
        startPoints.add(new Point(275, 107));

        startPoints.add(new Point(320, 70));
        startPoints.add(new Point(313, 80));
        startPoints.add(new Point(330, 63));
        startPoints.add(new Point(315, 87));
        startPoints.add(new Point(330, 80));
        startPoints.add(new Point(315, 100));
        startPoints.add(new Point(330, 90));
        startPoints.add(new Point(315, 110));
        startPoints.add(new Point(345, 65));
        startPoints.add(new Point(357, 67));
        startPoints.add(new Point(363, 103));

        startPoints.add(new Point(375, 80));
        startPoints.add(new Point(375, 80));
        startPoints.add(new Point(425, 80));
        startPoints.add(new Point(380, 95));
        startPoints.add(new Point(400, 63));

        List<Point> endPoints = new ArrayList<>();
        endPoints.add(new Point(270, 80));
        endPoints.add(new Point(270, 110));
        endPoints.add(new Point(270, 110));
        endPoints.add(new Point(250, 110));
        endPoints.add(new Point(275, 107));
        endPoints.add(new Point(302, 80));
        endPoints.add(new Point(302, 107));
        endPoints.add(new Point(302, 107));

        endPoints.add(new Point(340, 70));
        endPoints.add(new Point(360, 80));
        endPoints.add(new Point(330, 80));
        endPoints.add(new Point(340, 87));
        endPoints.add(new Point(315, 100));
        endPoints.add(new Point(345, 98));
        endPoints.add(new Point(330, 120));
        endPoints.add(new Point(345, 108));
        endPoints.add(new Point(360, 120));
        endPoints.add(new Point(363, 75));
        endPoints.add(new Point(345, 117));

        endPoints.add(new Point(380, 95));
        endPoints.add(new Point(425, 80));
        endPoints.add(new Point(420, 95));
        endPoints.add(new Point(420, 95));
        endPoints.add(new Point(400, 120));
        List<float[]> list = new ArrayList<>();

        int offsetX = Integer.MAX_VALUE;
        int offsetY = Integer.MAX_VALUE;

        for (int i = 0; i < startPoints.size(); i++) {
            offsetX = Math.min(startPoints.get(i).x, offsetX);
            offsetY = Math.min(startPoints.get(i).y, offsetY);
        }
        for (int i = 0; i < endPoints.size(); i++) {
            float[] point = new float[4];
            point[0] = startPoints.get(i).x - offsetX;
            point[1] = startPoints.get(i).y - offsetY;
            point[2] = endPoints.get(i).x - offsetX;
            point[3] = endPoints.get(i).y - offsetY;
            list.add(point);
        }
        return list;
    }
}
