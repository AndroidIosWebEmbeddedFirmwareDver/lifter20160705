package com.wxl.export.lifter.common.utils.core;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * 
 * @Description: TODO
 * @ClassName: LoggerSystemOutHandler
 * @author wxl.sinto.cto
 * @date 2014-9-15 上午10:50:10
 * 
 */
public class LoggerSystemOutHandler extends Handler
{

	@Override
	public void close()
	{
	}

	@Override
	public void flush()
	{
	}

	@Override
	public void publish(LogRecord record)
	{
		System.out.println(record.getMessage());
	}

}
