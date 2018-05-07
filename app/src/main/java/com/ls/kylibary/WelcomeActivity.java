package com.ls.kylibary;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;


import com.ls.kylibary.vlayout.MoreUiActivity;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.StatusBarUtil;

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        StatusBarUtil.setColor(this,0);
        setContentView(R.layout.activity_welcome);
        ImageView sc=findViewById(R.id.sc);
        sc.postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityUtil.startAty(WelcomeActivity.this,MainActivity.class);
                finish();
            }
        },1000);
//        ActivityUtil.startAty(this,MoreUiActivity.class);

    }

}
