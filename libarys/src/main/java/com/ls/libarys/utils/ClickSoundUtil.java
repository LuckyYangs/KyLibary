package com.ls.libarys.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

/**
 * 作  者：@author李 洋（295803379）
 * 时  间：2018/8/29 16:14
 * 类  名：ClickSoundUtil
 * 描  述: 点击音效工具类
 */
public class ClickSoundUtil {

    private Context context;
    private static SoundPool soundPool;
    private static int soundID;

    public static void play(Context context, int resId) {

        if (soundPool == null) {

           // 版本兼容
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                soundPool= new SoundPool.Builder().setMaxStreams(10).build();
            } else {
                  //第一个参数是可以支持的声音数量，第二个是声音类型，第三个是声音品质
                soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);
            }

        }
        soundID = soundPool.load(context, resId, 1);
       // 该方法防止sample not ready错误
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                soundPool.play(
                        soundID,  //声音id
                        1, //左声道
                        1, //右声道
                        1, //播放优先级【0表示最低优先级】
                        0, //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                        1);//播放速度【1是正常，范围从0~2】一般为1
            }
        });

    }
}
