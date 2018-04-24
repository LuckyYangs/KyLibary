package com.ls.libarys.utils;

/**
 * 作  者：@author李 洋（295803379）
 * 时  间：2018/3/28 11:44
 * 项目名：CompanyProject
 * 包  名：com.md.personnelfiles.utils
 * 类  名：StringsUtil
 * 描  述: 判断字符串是否为空的工具类
 */
public class StringsUtil {
    public  static  boolean isEmpty(String s){
            return s!=null&&s.trim().length()>0;

    }
}
