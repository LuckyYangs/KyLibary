package com.ls.kylibary.resfresh;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ls.kylibary.BaseActivity;
import com.ls.kylibary.main.MainActivity;
import com.ls.kylibary.R;
import com.ls.libarys.utils.ActivityUtil;

public class ResFreshActivity extends BaseActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    TextView tilte;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        lv=findViewById(R.id.lv);
        Toolbar toolbar =findViewById(R.id.toolbara);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getApplicationContext(), MainActivity.class);
                finish();
            }
        });
        tilte=findViewById(R.id.title);
        tilte.setText("LsReFresLayut");
    }

    @Override
    protected void initData() {

        String[] data={"经典","官方","太阳","贝塞尔曲线","圆圈","文字","麦点","苹果水滴","全屏水滴","气球"};
        adapter=new ArrayAdapter<String>(this,R.layout.item,data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ActivityUtil.startAty(getApplicationContext(),ClassicsActivity.class);
//                        startActivity(new Intent(this, ClassicsActivity.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                        break;
                    case 1:
                        ActivityUtil.startAty(getApplicationContext(),GeogleActivity.class);
                        break;
                    case 2:
                        ActivityUtil.startAty(getApplicationContext(),SunActivity.class);
                        break;
                    case 3:
                        ActivityUtil.startAty(getApplicationContext(),BerActivity.class);
                        break;
                    case 4:
                        ActivityUtil.startAty(getApplicationContext(),CircleActivity.class);
                        break;
                    case 5:
                        ActivityUtil.startAty(getApplicationContext(),TextActivity.class);

                        break;
                    case 6:
                        ActivityUtil.startAty(getApplicationContext(),MaiDianActivity.class);
                        break;
                    case 7:
                        ActivityUtil.startAty(getApplicationContext(),IphoneActivity.class);
                        break;
                    case 8:
                        ActivityUtil.startAty(getApplicationContext(),WaterActivity.class);
                        break;
                    case 9:
                        ActivityUtil.startAty(getApplicationContext(),BalloonActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

}
