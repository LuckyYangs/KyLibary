package com.ls.libarys.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;


/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间：2018/4/12
 * 包  名：com.md.personnelfiles.view
 * 类  名： CustomGridView
 * 简  述:  自定义GridView,解决嵌套时显示不全问题
 */
public class CustomGridView extends GridView {

    public CustomGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGridView(Context context) {
        super(context);
    }

    /**
     * 其中onMeasure函数决定了组件显示的高度与宽度；
     * MeasureSpec.makeMeasureSpec函数中第一个参数指布局空间的大小，第二个参数是布局模式
     * MeasureSpec.AT_MOST的意思就是子控件需要多大的控件就扩展到多大的空间
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
