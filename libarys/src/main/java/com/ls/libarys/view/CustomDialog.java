package com.ls.libarys.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/5/25.
 */

public class CustomDialog extends Dialog {

    private static int default_width = 120; // 默认宽度
    private static int default_height = 120;// 默认高度

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int layout, int style) {
        this(context, default_width, default_height, layout, style);
    }

    public CustomDialog(Context context, int width, int height, int layout,
                        int style) {
        super(context, style);
        // 设置内容
        setContentView(layout);
        // 设置窗口属性
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        // 设置宽度、高度、密度、对齐方式
        float density = getDensity(context);
        params.width = (int) (width * density);
        params.height = (int) (height * density);
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);

    }

    /**
     * 获取显示密度
     *
     * @param context
     * @return
     */
    public float getDensity(Context context) {
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        return dm.density;
    }

}
