package com.ls.libarys.utils;

import android.content.Context;
import android.widget.Toast;



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
