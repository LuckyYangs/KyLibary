package com.ls.libarys.utils;

import android.content.Context;
import android.content.Intent;

public class ActivityUtil {
	public static void startAty(Context context,Class<?> clazz){
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);  
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}
}
