package com.ls.kylibary;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import java.util.ArrayList;

/**
 * @author Administrator
 */

public class KyApplication extends Application {
    private static KyApplication instance;
    public static ArrayList<Activity> listActivity= new ArrayList<>();
    private int mStatusBarColor;



    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }



    // 单例模式中获取唯一的ExitAPPUtils实例
    public static KyApplication getInstance() {
        if(null == instance) {
            instance =new KyApplication();
        }
        return instance;
    }

    /**
     *
     * @param activity
     * 添加Activity到容器中
     */
    public void addActivity(Activity activity) {
        listActivity.add(activity);
    }

    /**
     * //1,关闭所有的activity
     */
    public void exit() {

        for (Activity activity:listActivity) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
            System.exit(0);
        }
    }

}
