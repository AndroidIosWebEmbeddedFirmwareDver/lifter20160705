package com.wxl.export.lifter.common.utils.common;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import com.wxl.export.lifter.common.R;


public class SoundPoolUtils
{
	private static SoundPoolUtils soundPoolUtils = null;
	private SoundPool sp;// 声明一个SoundPool
	private int music;// 定义一个整型用load（）；来设置suondID

	public static SoundPoolUtils getInstance(Context contex)
	{
		if (soundPoolUtils == null)
		{
			soundPoolUtils = new SoundPoolUtils(contex);
		}
		return soundPoolUtils;
	}

	public static SoundPoolUtils getInstance(Context contex, int rawId)
	{
		if (soundPoolUtils == null)
		{
			soundPoolUtils = new SoundPoolUtils(contex, rawId);
		}
		return soundPoolUtils;
	}

	public SoundPoolUtils(Context context)
	{
		super();
		sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);// 第一个参数为同时播放数据流的最大个数，第二数据流类型，第三为声音质量
		 music = sp.load(context, R.raw.iphonesanqy, 1); //
//		 music = sp.load(context, R.raw.notification, 1); //
		// 把你的声音素材放到res/raw里，第2个参数即为资源文件，第3个为音乐的优先级
	}

	public SoundPoolUtils(Context context, int rawId)
	{
		super();
		sp = new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);// 第一个参数为同时播放数据流的最大个数，第二数据流类型，第三为声音质量
		music = sp.load(context, rawId, 1); // 把你的声音素材放到res/raw里，第2个参数即为资源文件，第3个为音乐的优先级
	}

	public void playSound()
	{
		sp.play(music, 1, 1, 0, 0, 1);
	}

}
