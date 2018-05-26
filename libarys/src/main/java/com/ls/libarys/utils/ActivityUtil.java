package com.ls.libarys.utils;

import android.content.Context;
import android.content.Intent;
/**

              .---.          .-----------
             /  /   \  __  /    ------
            / /  //  \(  )/    -----
           //////    ' \/ `   ---
          //// /     :    : ---
         // /        `    '--
        //           //..\\
       =============UU====UU================
                    '//||\\`
                      ''``
 *  -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）
 *  -----------------------------------------------
 * | 时  间：| 2018/5/14
 *  -----------------------------------------------
 * | 包  名：| com.ls.libarys.utils                      |
 *  -----------------------------------------------
 * | 类  名：| ActivityUtil
 *  -----------------------------------------------
 * | 简  述: | Activity跳转工具类
 *  -----------------------------------------------
 */

public class ActivityUtil {
	public static void startAty(Context context,Class<?> clazz){
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}
	public static void startWithdata(Context context,String key,String value,Class<?> clazz){
		Intent intent = new Intent();
		intent.putExtra(key,value);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}
}
