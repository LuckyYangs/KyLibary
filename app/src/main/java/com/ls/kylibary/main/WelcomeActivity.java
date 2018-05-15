package com.ls.kylibary.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.ls.kylibary.R;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.SharedPreferencesUtil;
import com.ls.libarys.utils.StatusBarUtil;
import com.ls.libarys.view.CountDownView;

public class WelcomeActivity extends Activity {
    private boolean isfirst;
    private CountDownView cdvTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        //隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //隐藏状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this,0);

        setContentView(R.layout.activity_welcome);
        isfirst= (boolean) SharedPreferencesUtil.getData(this,"user","isfirst",false);
        Log.i("isfirst", isfirst+"");
        cdvTime = findViewById(R.id.cdv_time);
        ImageView sc=findViewById(R.id.sc);
        cdvTime.setTime(3);
        cdvTime.start();
        cdvTime.setOnLoadingFinishListener(new CountDownView.OnLoadingFinishListener() {
            @Override
            public void finish() {
                jump();
            }
        });
        cdvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdvTime.stop();
                jump();
            }
        });


//
//        sc.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        },5000);
    }
  public  void jump(){
      if(!isfirst){
          //第一次进入应用，进入导航界面
          SharedPreferencesUtil.putData(WelcomeActivity.this,"user","isfirst",true);
          ActivityUtil.startAty(WelcomeActivity.this,GuideActivity.class);
          Log.i("isfirst", isfirst+"是第一次进入");
      }else{
          //不是第一次进入应用,直接跳转到主界面
          Log.i("isfirst", "是第二次进入"+isfirst);
          ActivityUtil.startAty(WelcomeActivity.this,MainActivity.class);
      }
      finish();
  }
}
