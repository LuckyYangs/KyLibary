package com.ls.libarys.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;



/**
 * @ClassName: TimeUtil
 * @Description: 倒计时工具类
 * @author 李洋（liyangman@163.com）
 * @date 2016年7月21日 下午4:35:14
 *
 */
public class TimeUtil extends CountDownTimer{
    private Activity mActivity;
    private TextView tv;

    public TimeUtil(Activity mActivity, long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.mActivity=mActivity;
        this.tv=tv;
    }
    @Override
    public void onTick(long millisUntilFinished) {
        tv.setClickable(false);
        //设置不能点击
        tv.setText(millisUntilFinished  /1000+ "秒");   //设置倒计时时间

        //设置按钮为灰色，这时是不能点击的
//		tv.setBackground(mActivity.getResources().getDrawable(R.drawable.bg_duck_back));
        //获取按钮的文字
        Spannable span = new SpannableString(tv.getText().toString());
        //讲倒计时时间显示为红色
        span.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(span);

    }
    @Override
    public void onFinish() {
        tv.setText("重新获取");
        //重新获得点击
        tv.setClickable(true);
//		tv.setBackground(mActivity.getResources().getDrawable(R.drawable.bg_btn_back));//还原背景色

    }

}
