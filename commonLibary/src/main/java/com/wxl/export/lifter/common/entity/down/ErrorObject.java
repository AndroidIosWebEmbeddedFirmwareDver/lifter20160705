package com.wxl.export.lifter.common.entity.down;

/**
 * 
 * @com.sintn.hera.shop.entity.down
 * @HuiyuantongVenusShopCash-V3.x
 * @ErrorObject.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 表示错误的对象
 * @2015-3-1上午11:48:40
 */
public class ErrorObject
{
	private int code;// 错误码
	private String cause;// 错误原因
	private String solution;// 解决方案


	public ErrorObject()
	{
		super();
	}

	public ErrorObject(int code, String cause, String solution)
	{
		this.code = code;
		this.cause = cause;
		this.solution = solution;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getCause()
	{
		return cause;
	}

	public void setCause(String cause)
	{
		this.cause = cause;
	}

	public String getSolution()
	{
		return solution;
	}

	public void setSolution(String solution)
	{
		this.solution = solution;
	}

	public static String formatError(ErrorObject errorObject)
	{
		if (errorObject != null)
		{
			StringBuffer buffer = new StringBuffer();
			buffer.append("\n").append(errorObject.getCause()).append("\n").append(errorObject.getSolution());
			return buffer.toString();
		} else
		{
			return "未定义错误";
		}

	}
}
