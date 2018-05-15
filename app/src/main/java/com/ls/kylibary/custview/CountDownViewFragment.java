package com.ls.kylibary.custview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.kylibary.R;
import com.ls.libarys.view.CountDownView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountDownViewFragment extends Fragment {

    View view;
    CountDownView countDownView1,countDownView2,countDownView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=View.inflate(getActivity(),R.layout.fragment_countdownview, null);
        countDownView1= view.findViewById(R.id.countDownView1);
        countDownView2= view.findViewById(R.id.countDownView2);
        countDownView3= view.findViewById(R.id.countDownView3);
        countDownView1.setTime(3);
        countDownView1.start();
        countDownView2.setTime(5);
        countDownView2.start();
        countDownView3.setTime(6);
        countDownView3.start();
        return view;
    }

}
