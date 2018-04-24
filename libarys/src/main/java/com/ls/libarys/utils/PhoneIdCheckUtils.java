package com.ls.libarys.utils;

/**
 * @Author： AndroidBigGuy（QQ295803379）>
 * 时  间： 2018/4/17
 * 包  名： com.md.personnelfiles.utils
 * 类  名： PhoneIdCheckUtils
 * 简  述:  手机号身份证验证工具类
 */
public class PhoneIdCheckUtils {
    /**
     * 判断是否是手机号
     */
    public  static  boolean isphone(String s){
        String phone = "^(13|14|15|16|18|19|17)[0-9]{9}$";
        return s.matches(phone);
    }
    /**
     *判断是否是身份证
     */
    public  static  boolean isId(String s){
        String idnum = "^\\d{15}|\\d{18}$";
        return s.matches(idnum);
    }
}
