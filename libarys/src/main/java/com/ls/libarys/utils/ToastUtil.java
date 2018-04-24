package com.ls.libarys.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间：2018/4/4
 * 包  名：com.ls.libarys.utils
 * 类  名： ToastUtil
 * 简  述:  单例吐司工具类
 */

public class ToastUtil {
    private static Toast toast;
    /**
     * 自定义Toast
     *
     * @param context
     * @param message
     */
    public static void show(Context context, CharSequence message) {
        if (toast == null) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            toast.setText(message);
        }
        toast.show();
    }
}
