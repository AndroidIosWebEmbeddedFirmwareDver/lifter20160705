package com.wxl.export.lifter.common.utils.core;


import com.alibaba.fastjson.JSON;

/**
 * 
 * @com.wxl.export.lifter.common.utils.core
 * @HuiyuantongVenusShopCash-V3.x
 * @JsonCommonUtils.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: Json工具类
 * @2015-2-4下午2:49:12
 */
public class JsonCommonUtils
{
	/**
	 * 将类对象转换为json字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String objectToJson(Object object)
	{
		try
		{
			return JSON.toJSONString(object);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 按照模版类转换json字符串
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static Object jsonToObject(String json, Class<?> clazz)
	{
		try
		{
			return JSON.parseObject(json, clazz);
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
