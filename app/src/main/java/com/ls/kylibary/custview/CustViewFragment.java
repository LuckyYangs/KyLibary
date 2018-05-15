package com.ls.kylibary.custview;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ls.kylibary.R;
import com.ls.kylibary.main.MainActivity;
import com.ls.libarys.banner.Banner;
import com.ls.libarys.banner.Transformer;
import com.ls.libarys.banner.listener.OnBannerListener;
import com.ls.libarys.slidemenu.SlidingTabLayout;
import com.ls.libarys.slidemenu.listener.OnTabSelectListener;
import com.ls.libarys.slidemenu.widget.MsgView;
import com.ls.libarys.utils.ActivityUtil;
import com.ls.libarys.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CustViewFragment extends Fragment  implements OnTabSelectListener {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"CountDownView", "SwitchButton","CircleImageView","MarqueeView", "LoadingButton"};
    View view;
    ViewPager vp;
    private Toolbar toolbar;
    private TextView tilte;
    private MyPagerAdapter mAdapter;
    SlidingTabLayout tabLayout_1;
    SlidingTabLayout tabLayout_2;
    SlidingTabLayout tabLayout_3;
    SlidingTabLayout tabLayout_4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_juxing, null);
        vp = view.findViewById(R.id.vp);
        toolbar =view.findViewById(R.id.toolbara);
        tilte =view.findViewById(R.id.title);
        tilte.setText("CustView");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.startAty(getActivity(), MainActivity.class);
                getActivity().finish();
            }
        });
        tabLayout_1 = view.findViewById(R.id.tl_1);
        tabLayout_2 = view.findViewById(R.id.tl_2);
        tabLayout_3 = view.findViewById(R.id.tl_3);
        tabLayout_4 = view.findViewById(R.id.tl_4);
        intview();

        mAdapter = new MyPagerAdapter(getChildFragmentManager(),mFragments);
        vp.setAdapter(mAdapter);
        tabLayout_1.setViewPager(vp, mTitles, getActivity(), mFragments);
        tabLayout_1.setOnTabSelectListener(this);
        tabLayout_2.setViewPager(vp, mTitles, getActivity(), mFragments);
        tabLayout_3.setViewPager(vp, mTitles, getActivity(), mFragments);
        tabLayout_4.setViewPager(vp, mTitles, getActivity(), mFragments);

        tabLayout_4.showDot(2);
        tabLayout_2.showDot(1);
        tabLayout_1.showMsg(0, 2);
        tabLayout_1.setMsgMargin(0, 0, 10);
        MsgView rtv_2_3 = tabLayout_1.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }

        tabLayout_1.showMsg(2, 3);
        tabLayout_1.setMsgMargin(2, 0, 10);
        return  view;
    }

    private void intview() {
        mFragments.add(new CountDownViewFragment());
        mFragments.add(new SwitchButtonFragment());
        mFragments.add(new CircleImageViewFragment());
        mFragments.add(new MarqueeViewFragment());
//        for (String title : mTitles) {
//            mFragments.add(SimpleCardFragment.getInstance(title));
//        }
    }

    @Override
    public void onTabSelect(int position) {
        ToastUtil.show(getActivity(),"onTabSelect&position--->" + position);
    }

    @Override
    public void onTabReselect(int position) {
        ToastUtil.show(getActivity(),"onTabReselect&position--->" + position);
    }
}
