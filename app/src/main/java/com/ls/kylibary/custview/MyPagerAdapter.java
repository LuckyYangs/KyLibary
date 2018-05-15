package com.ls.kylibary.custview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**

             /~~~~~\        /~~~~~\
            |    (~'        ~~~)   |
             \    \__________/    /
             /~::::::::         ~\
  /~~~~~~~-_| ::::::::             |_-~~~~~~~\
 \ ======= /|  ::A::;      A     :|\ ====== /
  ~-_____-~ |  _----------------_::| ~-____-~
            |/~                  ~\|
            /                      \
           (        ()    ()        )
            `\                   ./'
              ~-_______________-~
                     /~~~~\
                    |      |
                    |      |
                   (________)
                       ()
 *  -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）
 *  -----------------------------------------------
 * | 时  间：| 2018/5/12
 *  -----------------------------------------------
 * | 包  名：| com.ls.kylibary.custview
 *  -----------------------------------------------
 * | 类  名：| MyPagerAdapter.java
 *  -----------------------------------------------
 * | 简  述: | <功能简述>                          |
 *  -----------------------------------------------
 */


public class MyPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments ;
//    private  String[] mTitles;



    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
//        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mTitles[position];
//    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

}
