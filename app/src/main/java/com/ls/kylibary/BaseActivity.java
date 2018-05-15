package com.ls.kylibary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ls.kylibary.KyApplication;
import com.ls.kylibary.R;
import com.ls.libarys.utils.StatusBarUtil;


/**
 * 作  者：@author李 洋（liyangman518@163.com）
 * 时  间：2017/11/24 16:10
 * 项目名：CompanyProject
 * 包  名：com.md.personnelfiles.ui
 * 类  名：BaseActivity
 * 描  述: activity基类
 */


public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    /**
     * 1. 设置布局
     */

    protected abstract void setContentView();

    /**
     * 2. 初始化布局
     */
    protected abstract void initView();


    /**
     * 3. 初始化ui数据
     */
    protected abstract void initData();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        KyApplication.getInstance().addActivity(this);
        initView();
        initData();
    }

}
