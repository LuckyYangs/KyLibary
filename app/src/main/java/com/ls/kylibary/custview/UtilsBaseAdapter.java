package com.ls.kylibary.custview;


import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.animation.LinearInterpolator;

import com.bumptech.glide.util.Util;
import com.ls.kylibary.R;
import com.ls.kylibary.vlayout.IconEntity;
import com.ls.libarys.baseadapter.BaseQuickAdapter;
import com.ls.libarys.baseadapter.BaseViewHolder;
import com.ls.libarys.utils.ApplicationUtils;
import com.ls.libarys.utils.SpanUtils;

import java.util.List;

/**

             /~~~~~\        /~~~~~\
            |    (~'        ~~~)   |
             \    \__________/    /
             /~::::::::         ~\
  /~~~~~~~-_| ::::::::             |_-~~~~~~~\
 \ ======= /|  ::A::;      A     :|\ ====== /
  ~-_____-~ |  _----------------_::| ~-____-~
            |/~                  ~\|
            /                      \
           (        ()    ()        )
            `\                   ./'
              ~-_______________-~
                     /~~~~\
                    |      |
                    |      |
                   (________)
                       ()
 *  -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）        
 *  -----------------------------------------------
 * | 时  间：| 2018/5/14
 *  -----------------------------------------------
 * | 包  名：| com.ls.kylibary.custview                     
 *  -----------------------------------------------
 * | 类  名：| UtilsBaseAdapter.java                             
 *  -----------------------------------------------
 * | 简  述: | 工具类适配器
 *  -----------------------------------------------
 */
 

public class UtilsBaseAdapter extends BaseQuickAdapter<IconEntity,BaseViewHolder> {

    Context context;
    int layoutResId;
    List<IconEntity>data;



    public UtilsBaseAdapter(Context context , int layoutResId, List<IconEntity>data) {
        super(layoutResId,data);
        this.context=context;
        this.layoutResId=layoutResId;
        this.data=data;
    }

    @Override
    protected void convert(BaseViewHolder helper,  IconEntity data) {
        float density= context.getResources().getDisplayMetrics().density;
        int position = helper.getLayoutPosition();
        int st=data.getTitle().indexOf("(");
        int end =data.getTitle().indexOf(")");
        String l=data.getTitle().substring(0, st);
        String r=data.getTitle().substring(st, end+1);
        switch (position%5) {
            case 0:
                helper.setText(R.id.tv_utils,new SpanUtils().append(l).setForegroundColor(Color.GREEN).appendLine(r).
                        setShader(new LinearGradient(0, 0, 64 * density * 4, 0, context.getResources().getIntArray(R.array.rainbow), null,
                                Shader.TileMode.REPEAT)).setFontSize(14, true).create());
                break;
            case 1:
                helper.setText(R.id.tv_utils,new SpanUtils().append(l).setForegroundColor(Color.RED).setBackgroundColor(ContextCompat.getColor(context,R.color.sectop_bg)).appendLine(r).setFontSize(12, true).create());
                break;
            case 2:
                helper.setText(R.id.tv_utils,new SpanUtils().append(l).setForegroundColor(Color.BLACK).appendLine(r).setUrl("www.baidu.com").setFontSize(12, true).setUnderline().create());
                break;
            case 3:
                helper.setText(R.id.tv_utils,new SpanUtils().append(l).setForegroundColor(ContextCompat.getColor(context,R.color.material_red)).appendLine(r).setShader(new BitmapShader(BitmapFactory.decodeResource(context.getResources(), R.mipmap.util),
                        Shader.TileMode.REPEAT,
                        Shader.TileMode.REPEAT)).setFontSize(12, true).create());
                break;
            case 4:
                helper.setText(R.id.tv_utils,new SpanUtils().append(l).setForegroundColor(ContextCompat.getColor(context,R.color.sectop_bg)).appendLine(r).setBackgroundColor(Color.LTGRAY).setShadow(24, 8, 8, Color.WHITE).setFontSize(12, true).create());
                break;
            default:

                break;
        }

        helper.setImageResource(R.id.util_icon,R.mipmap.util).addOnClickListener(R.id.util_icon);
        //获取当前条目position
        //
    }



}
