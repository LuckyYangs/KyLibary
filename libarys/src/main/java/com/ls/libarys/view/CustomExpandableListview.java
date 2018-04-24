package com.ls.libarys.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;


/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间：2018/4/12
 * 包  名：com.md.personnelfiles.view
 * 类  名： CustomExpandableListview
 * 简  述:  自定义ExpandableListView,解决嵌套时显示不全问题
 */
public class CustomExpandableListview extends ExpandableListView {

    public CustomExpandableListview(Context context) {
        super(context);
    }

    public CustomExpandableListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomExpandableListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
