package com.ls.kylibary;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.ls.libarys.utils.StatusBarUtil;

public class WelcomeActivity extends Activity {
    private ImageView qd;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucent(this, 0);
//        //隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//         //隐藏状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        qd=findViewById(R.id.qd);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            a=50;
        }else {
            a=1000;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation(qd);
            }
        },a);
    }
    private void startAnimation(View view) {
        //因为CircularReveal动画是api21之后才有的,所以加个判断语句,免得崩溃
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cicular_R = view.getHeight() / 2 > view.getWidth() / 2 ? view.getHeight() / 2 : view.getWidth() / 2;
            Animator animator = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth() / 2, (int) view.getHeight() / 2, 0, cicular_R);
            animator.setDuration(3000);
            animator.start();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            },3000);

        } else {
            Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
