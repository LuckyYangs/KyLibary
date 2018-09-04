package com.ls.libarys.utils;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * 作  者：@author李 洋（295803379）
 * 时  间：2018/7/26 17:45
 * 项目名：CompanyProject
 * 包  名：com.md.personnelfiles.utils
 * 类  名： $class$
 * 描  述: {描述这个类}
 */
public class DateUtil {
    private static String mYear;
    private static String mMonth;
    private static String mDay;
    private static String mWay;

    public static String getDay(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码

        return mYear + "-" + mMonth + "-" + mDay;
    }
    public static String getWeek(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if("1".equals(mWay)){
            mWay ="天";
        }else if("2".equals(mWay)){
            mWay ="一";
        }else if("3".equals(mWay)){
            mWay ="二";
        }else if("4".equals(mWay)){
            mWay ="三";
        }else if("5".equals(mWay)){
            mWay ="四";
        }else if("6".equals(mWay)){
            mWay ="五";
        }else if("7".equals(mWay)){
            mWay ="六";
        }
        return "星期"+mWay;
    }
}
