package com.ls.libarys.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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
	public static void startAty(Context context, Class<?> clazz) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}

	public static void startWithdata(Context context, String key, String value, Class<?> clazz) {
		Intent intent = new Intent();
		intent.putExtra(key, value);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}

	/**
	 * 功能描述：带数据的Activity之间的跳转
	 *
	 * @param activity
	 * @param cls
	 * @param hashMap
	 */
	public static void skipAnotherActivity(Activity activity, Class<? extends Activity> cls, HashMap<String, ? extends Object> hashMap) {
		Intent intent = new Intent(activity, cls);
		Iterator<?> iterator = hashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = (Entry<String, Object>) iterator.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof String) {
				intent.putExtra(key, (String) value);
			}
			if (value instanceof Boolean) {
				intent.putExtra(key, (boolean) value);
			}
			if (value instanceof Integer) {
				intent.putExtra(key, (int) value);
			}
			if (value instanceof Float) {
				intent.putExtra(key, (float) value);
			}
			if (value instanceof Double) {
				intent.putExtra(key, (double) value);
			}
		}
		activity.startActivity(intent);
	}
//	hashmap存读数据
	//读取数据
//        for(Map.Entry<String, String> entry: map.entrySet()){
//		System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
//	}
////	存放数据
//	Map<String,String> map=new HashMap<String,String>();
//        map.put("1", "value1");
//        map.put("2", "value2");
//        map.put("3", "value3");
//        map.put("4", "value4");
}

