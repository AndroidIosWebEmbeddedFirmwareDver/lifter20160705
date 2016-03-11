package com.wxl.export.lifter.common.utils.core;

import com.wxl.export.lifter.common.entity.JsonEntity;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;


/**
 * 
 * @Desc: Http工具类
 * @com.wxl.export.lifter.common.utils.core
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpUtils.java
 * @Author:Wxl@Sintn.Inc
 * @2015-5-14下午2:29:50
 */

public class HttpDefaultUtils
{

	/**
	 * 请求超时8秒钟
	 */
	private static final int REQUEST_TIMEOUT = 8 * 1000;
	/**
	 * 等待数据超时时间40秒钟
	 */
	private static final int SO_TIMEOUT = 20 * 1000;
	/**
	 * httpClient客户端本地缓存
	 */
	private static DefaultHttpClient httpClient = null;

	/**
	 * 添加请求超时时间和等待时间
	 * 
	 * @param isLong
	 * @return
	 */
	public static DefaultHttpClient getHttpClient(boolean isLong)
	{
		if (httpClient == null)
		{
			synchronized (HttpDefaultUtils.class)
			{
				if (httpClient == null)
				{
					httpClient = new DefaultHttpClient();
				}
			}
		}
		HttpParams params = httpClient.getParams();
		params.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "UTF-8");
		if (isLong)
		{
			HttpConnectionParams.setConnectionTimeout(params, 1000 * 7200);
			HttpConnectionParams.setSoTimeout(params, 1000 * 7200);
		} else
		{
			HttpConnectionParams.setConnectionTimeout(params, REQUEST_TIMEOUT);
			HttpConnectionParams.setSoTimeout(params, SO_TIMEOUT);
		}
		return httpClient;
	}

	/**
	 * 获取数据
	 * 
	 * @param strUrl
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static HttpResponse doGet(String strUrl) throws UnsupportedEncodingException
	{
		HttpResponse response = null;
		try
		{
			HttpGet httpGet = new HttpGet(strUrl);
			httpGet.setHeader("Content-Type: text/html", "charset=utf-8");
			response = getHttpClient(false).execute(httpGet);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}

	public static HttpResponse doPost(String strUrl, Object object)
	{
		HttpResponse response = null;
		try
		{
			HttpPost httpPost = new HttpPost(strUrl);
			httpPost.setEntity(new JsonEntity(object));
			response = getHttpClient(false).execute(httpPost);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return response;
	}




}
