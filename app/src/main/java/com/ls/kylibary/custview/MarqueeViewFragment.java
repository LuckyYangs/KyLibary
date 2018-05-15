package com.ls.kylibary.custview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ls.kylibary.R;
import com.ls.libarys.utils.ToastUtil;
import com.ls.libarys.view.MarqueeView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MarqueeViewFragment extends Fragment {


    View view;
    MarqueeView marqueeView1,marqueeView2,marqueeView3;
    List<String> info2 = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_marqueeview, null);
        marqueeView1= view.findViewById(R.id.marqueeView1);
        marqueeView2= view.findViewById(R.id.marqueeView2);
        marqueeView3= view.findViewById(R.id.marqueeView3);
        indata();
        return view;
    }

    private void indata() {
        info2.add("最大网红孵化基地落户武汉");
        info2.add("第一夫人剽窃风波");
        // 在代码里设置自己的动画
        marqueeView1.startWithList(info2, R.anim.anim_bottom_in, R.anim.anim_top_out);
        marqueeView1.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                ToastUtil.show(getActivity(),textView.getText().toString());
            }
        });
        // 在代码里设置自己的动画
        marqueeView2.startWithList(info2, R.anim.anim_bottom_in, R.anim.anim_top_out);
        marqueeView2.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                ToastUtil.show(getActivity(),textView.getText().toString());
            }
        });
        // 在代码里设置自己的动画
        marqueeView3.startWithList(info2, R.anim.anim_bottom_in, R.anim.anim_top_out);
        marqueeView3.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                ToastUtil.show(getActivity(),textView.getText().toString());
            }
        });
    }

}
