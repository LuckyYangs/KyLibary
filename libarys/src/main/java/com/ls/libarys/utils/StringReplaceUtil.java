package com.ls.libarys.utils;

/**
 * 作  者：@author李 洋（295803379）
 * 时  间：2018/4/17 13:49
 * 项目名：CompanyProject
 * 包  名：com.md.personnelfiles.utils
 * 类  名：StringReplaceUtil
 * 描  述: 字符串替换类（手机号、身份证隐藏等）
 */

public class StringReplaceUtil {
    /**
     *
     * @param s 传入的字符串
     * @param start 替换开始位置
     * @param end   替换结束位置
     * @return  返回替换结果
     */
    public  static  String replace(String s,int start,int end){
        String str = "****";
        StringBuilder sb = new StringBuilder(s);
        return sb.replace(start, end, str).toString();
    }
}
