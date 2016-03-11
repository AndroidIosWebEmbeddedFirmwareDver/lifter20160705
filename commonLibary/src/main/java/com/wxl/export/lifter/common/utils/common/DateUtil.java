package com.wxl.export.lifter.common.utils.common;

import android.annotation.SuppressLint;

import java.util.*;
import java.sql.Timestamp;
import java.text.*;
import java.util.Calendar;

/**
 * 
 * @Description: 时间转换工具
 * @ClassName: DateUtil
 * @author wxl.sinto.cto
 * @date 2014-9-20 上午11:01:40
 * 
 */
@SuppressLint("SimpleDateFormat")
public class DateUtil
{
	public static final String DATE_STYLE1 = "yyyy-MM-dd";
	public static final String DATE_STYLE2 = "yyyy/MM/dd";
	public static final String DATE_STYLE3 = "yyyy年MM月dd日";
	public static final String DATE_STYLE4 = "yyyyMMdd";

	public static final String TIME_STYLE1 = "HH:mm:ss";
	public static final String TIME_STYLE2 = "HHmmss";
	public static final String TIME_STYLE3 = "HH时mm分ss秒";

	public static final String DTIME_STYLE1 = "yyyy-MM-dd HH:mm:ss";
	public static final String DTIME_STYLE2 = "yyyyMMdd HHmmss";
	public static final String DTIME_STYLE3 = "yyyy/MM/dd HH:mm:ss";
	public static final String DTIME_STYLE4 = "yyyy年MM月dd日 HH时mm分ss秒";

	/**
	 * 将Calendar转换成String
	 * 
	 * @param calendar
	 * @param styel
	 * @return
	 */
	public static String calendarToString(Calendar calendar, String styel)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(styel);
		String dateStr = sdf.format(calendar.getTime());
		return dateStr;
	}

	/**
	 * 将String转换成 Calendar
	 * 
	 * @param dateStr
	 * @param styel
	 * @return
	 */
	public static Calendar stringToCalendar(String dateStr, String styel)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(styel);
		Date date = null;
		Calendar calendar = null;
		try
		{
			date = sdf.parse(dateStr);
			calendar = Calendar.getInstance();
			calendar.setTime(date);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar;
	}

	/**
	 * 将日期转换成标准日期格式
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String stringToDateString(String dateStr)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE1);
		Date date = null;
		try
		{
			date = formatter.parse(dateStr);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 将Date转换成String
	 * 
	 * @param date
	 * @param styel
	 * @return
	 */
	public static String dateToString(Date date, String styel)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(styel);
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * 将String转换成Date
	 * 
	 * @param dateStr
	 * @param styel
	 * @return
	 */
	public static Date stringToDate(String dateStr, String styel)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(styel);
		Date date = null;
		try
		{
			date = sdf.parse(dateStr);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * Date转化Calendar
	 * 
	 * @param date
	 * @param styel
	 * @return
	 */
	public static Calendar dateToCalendar(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

	/**
	 * Calendar转化Date
	 * 
	 * @param calendar
	 * @param styel
	 * @return
	 */
	public static Date calendarToDate(Calendar calendar)
	{
		return calendar.getTime();
	}

	/**
	 * String 转成 Timestamp
	 * 
	 * @param timeStr
	 * @return
	 */
	public static Timestamp stringToTimestamp(String timeStr)
	{
		Timestamp ts = Timestamp.valueOf(timeStr);
		return ts;
	}

	/**
	 * Date 转 TimeStamp
	 * 
	 * @param date
	 * @param styel
	 * @return
	 */
	public static Timestamp dateToTimestamp(Date date, String styel)
	{
		SimpleDateFormat df = new SimpleDateFormat(styel);
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort()
	{
		Date date = strToDate(getStringDateShort());
		return date;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate()
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE1);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy/MM/dd HH:mm:ss
	 */
	public static String getStringDateStyle3()
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE3);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort()
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STYLE1);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyyMMdd
	 */
	public static String getDateShort(String dateStyle)
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(dateStyle);
		String dateStr = formatter.format(currentTime);
		return dateStr;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyyMMdd
	 */
	public static String getDateShort()
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STYLE4);
		String dateStr = formatter.format(currentTime);
		return dateStr;
	}

	/**
	 * 获得当前时间一个月前的日期
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getOneMonthBeforeCurrentTime()
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
		cal.add(cal.MONTH, -1);
		return calendarToString(cal, DATE_STYLE1);
	}

	/**
	 * 获得当前时间一个月后的日期
	 * 
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static String getOneMonthAfterCurrentTime()
	{
		Calendar cal = Calendar.getInstance(Locale.getDefault());
		cal.add(cal.MONTH, 1);
		return calendarToString(cal, DATE_STYLE1);
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort()
	{
		SimpleDateFormat formatter = new SimpleDateFormat(TIME_STYLE1);
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateLong(String strDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE1);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE1);
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(Date dateDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STYLE1);
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(Date dateDate, String format)
	{
		if (dateDate == null)
		{
			return "";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STYLE1);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	/**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 */
	public static Date strToDateWithFromatString(String strDate, String format)
	{
		try
		{
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			ParsePosition pos = new ParsePosition(0);
			Date strtodate = formatter.parse(strDate, pos);
			return strtodate;
		} catch (Exception e)
		{
			// TODO: handle exception
			return null;
		}

	}

	/**
	 * 得到现在日期时间
	 * 
	 * @return
	 */
	public static Date getNow()
	{
		Date currentTime = new Date();
		return currentTime;
	}

	//获取当前日期(yyyy-MM-dd)
	@SuppressLint("SimpleDateFormat")
	public static String getNowDate()
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTimeInMillis(System.currentTimeMillis());
		String nowTime = sdf.format(calendar.getTime());
		return nowTime;
	}

	/**
	 * 得到现在时间 HH:mm:ss
	 * 
	 * @return
	 */
	public static Date getNowTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat(TIME_STYLE1);
		ParsePosition pos = new ParsePosition(0);
		Date currentTime = formatter.parse(getTimeShort(), pos);
		return currentTime;
	}

	/**
	 * 提取一个月中的最后一天
	 * 
	 * @param day
	 * @return
	 */
	public static Date getLastDate(long day)
	{
		Date currentTime = new Date();
		long date_3_hm = currentTime.getTime() - 3600000 * 34 * day;
		Date date_3_hm_date = new Date(date_3_hm);
		return date_3_hm_date;
	}

	/**
	 * 得到现在时间
	 * 
	 * @return 字符串 yyyyMMdd HHmmss
	 */
	public static String getStringToday()
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE2);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 得到现在小时
	 */
	public static String getHour()
	{
		// Calendar calendar = Calendar.getInstance();// 获取当前日历对象
		// long unixTime = calendar.getTimeInMillis();// 获取当前时区下日期时间对应的时间戳
		// long unixTimeGMT = unixTime - TimeZone.getDefault().getRawOffset();//
		// 获取标准格林尼治时间下日期时间对应的时间戳
		// Date currentTime = new Date(unixTimeGMT);
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE1);
		String dateString = formatter.format(currentTime);
		String hour;
		hour = dateString.substring(11, 13);
		return hour;
	}

	/**
	 * 得到现在分钟
	 * 
	 * @return
	 */
	public static String getTime()
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(DTIME_STYLE1);
		String dateString = formatter.format(currentTime);
		String min;
		min = dateString.substring(14, 16);
		return min;
	}

	/**
	 * 根据用户传入的时间表示格式，返回当前时间的格式 如果是yyyyMMdd，注意字母y不能大写。
	 * 
	 * @param sformat
	 *            yyyyMMddhhmmss
	 * @return
	 */
	public static String getUserDate(String sformat)
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(sformat);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 二个小时时间间的差值,必须保证二个时间都是"HH:MM"的格式，返回字符型的分钟
	 */
	public static String getTwoHour(String st1, String st2)
	{
		String[] kk = null;
		String[] jj = null;
		kk = st1.split(":");
		jj = st2.split(":");
		if (Integer.parseInt(kk[0]) < Integer.parseInt(jj[0]))
			return "0";
		else
		{
			double y = Double.parseDouble(kk[0]) + Double.parseDouble(kk[1]) / 60;
			double u = Double.parseDouble(jj[0]) + Double.parseDouble(jj[1]) / 60;
			if ((y - u) > 0)
				return y - u + "";
			else
				return "0";
		}
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static int getTwoDay(String sj1, String sj2)
	{
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATE_STYLE4);
		long day = 0;
		try
		{
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e)
		{
			return 0;
		}
		return (int) day;
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static int getTwoDayByStyle2(String sj1, String sj2)
	{
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATE_STYLE2);
		long day = 0;
		try
		{
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e)
		{
			return 0;
		}
		return (int) day;
	}

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static int getTwoDayByStyle1(String sj1, String sj2)
	{
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATE_STYLE1);
		long day = 0;
		try
		{
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		} catch (Exception e)
		{
			return 0;
		}
		return (int) day;
	}

	/**
	 * 时间前推或后推分钟,其中JJ表示分钟.
	 */
	public static String getPreTime(String sj1, String jj)
	{
		SimpleDateFormat format = new SimpleDateFormat(DTIME_STYLE1);
		String mydate1 = "";
		try
		{
			Date date1 = format.parse(sj1);
			long Time = (date1.getTime() / 1000) + Integer.parseInt(jj) * 60;
			date1.setTime(Time * 1000);
			mydate1 = format.format(date1);
		} catch (Exception e)
		{
		}
		return mydate1;
	}

	/**
	 * 得到一个时间延后或前移几天的时间,nowdate为时间,delay为前移或后延的天数
	 */
	public static String getNextDay(String nowdate, String delay)
	{
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(DATE_STYLE1);
			String mdate = "";
			Date d = strToDate(nowdate);
			long myTime = (d.getTime() / 1000) + Integer.parseInt(delay) * 24 * 60 * 60;
			d.setTime(myTime * 1000);
			mdate = format.format(d);
			return mdate;
		} catch (Exception e)
		{
			return "";
		}
	}

	public static String getTheDealayTime(String nowdate, String delay)
	{
		try
		{
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(delay));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mString = format.format(calendar.getTime());
			return mString;
		} catch (Exception e)
		{
			// TODO: handle exception
			return "";
		}
	}

	/**
	 * 日期加减天数、小时、分钟、秒、毫秒
	 * 
	 * @param dateYMDHMS
	 *            - 日期字符串（格式为format指定的格式）
	 * @param format
	 *            - 指定dateYMDHMS的日期格式
	 * @param unit
	 *            - 日期加减的单位（可以是天数、小时、分钟、秒、毫秒）
	 * @param amount
	 *            - 要加减的数量
	 * @return 返回加减后的日期（格式为format指定的格式）
	 */
	public static String addDate(String dateYMDHMS, String format, String unit, int amount)
	{
		try
		{

			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			calendar.setTime(sdf.parse(dateYMDHMS));
			if (unit.equals("day") || unit.equals("days"))
			{
				calendar.add(Calendar.DAY_OF_YEAR, amount);
			} else if (unit.equals("hour") || unit.equals("hours"))
			{
				calendar.add(Calendar.HOUR_OF_DAY, amount);
			} else if (unit.equals("minute") || unit.equals("minutes"))
			{
				calendar.add(Calendar.MINUTE, amount);
			} else if (unit.equals("second") || unit.equals("seconds"))
			{
				calendar.add(Calendar.SECOND, amount);
			} else if (unit.equals("millisecond") || unit.equals("milliseconds"))
			{
				calendar.add(Calendar.MILLISECOND, amount);
			}
			return sdf.format(calendar.getTime());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate)
	{

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0)
		{
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	/**
	 * 返回美国时间格式 26 Apr 2006
	 * 
	 * @param str
	 * @return
	 */
	@SuppressLint("DefaultLocale")
	public static String getEDate(String str)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_STYLE1);
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(str, pos);
		String j = strtodate.toString();
		String[] k = j.split(" ");
		return k[2] + k[1].toUpperCase() + k[5].substring(2, 4);
	}

	/**
	 * 获取一个月的最后一天
	 * 
	 * @param dat
	 * @return
	 */
	public static String getEndDateOfMonth(String dat)
	{// yyyy-MM-dd
		String str = dat.substring(0, 8);
		String month = dat.substring(5, 7);
		int mon = Integer.parseInt(month);
		if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)
		{
			str += "31";
		} else if (mon == 4 || mon == 6 || mon == 9 || mon == 11)
		{
			str += "30";
		} else
		{
			if (isLeapYear(dat))
			{
				str += "29";
			} else
			{
				str += "28";
			}
		}
		return str;
	}

	/**
	 * 判断二个时间是否在同一个周
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameWeekDates(Date date1, Date date2)
	{
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);
		int subYear = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
		if (0 == subYear)
		{
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (1 == subYear && 11 == cal2.get(Calendar.MONTH))
		{
			// 如果12月的最后一周横跨来年第一周的话则最后一周即算做来年的第一周
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		} else if (-1 == subYear && 11 == cal1.get(Calendar.MONTH))
		{
			if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
				return true;
		}
		return false;
	}

	/**
	 * 产生周序列,即得到当前时间所在的年度是第几周
	 * 
	 * @return
	 */
	public static String getSeqWeek()
	{
		Calendar c = Calendar.getInstance(Locale.CHINA);
		String week = Integer.toString(c.get(Calendar.WEEK_OF_YEAR));
		if (week.length() == 1)
			week = "0" + week;
		String year = Integer.toString(c.get(Calendar.YEAR));
		return year + week;
	}

	/**
	 * 获得一个日期所在的周的星期几的日期，如要找出2002年2月3日所在周的星期一是几号
	 * 
	 * @param sdate
	 * @param num
	 * @return
	 */
	public static String getWeek(String sdate, String num)
	{
		// 再转换为时间
		Date dd = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(dd);
		if (num.equals("1")) // 返回星期一所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		else if (num.equals("2")) // 返回星期二所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		else if (num.equals("3")) // 返回星期三所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		else if (num.equals("4")) // 返回星期四所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		else if (num.equals("5")) // 返回星期五所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		else if (num.equals("6")) // 返回星期六所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		else if (num.equals("0")) // 返回星期日所在的日期
			c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
	}

	/**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getWeek(String sdate)
	{
		// 再转换为时间
		Date date = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// int hour=c.get(Calendar.DAY_OF_WEEK);
		// hour中存的就是星期几了，其范围 1~7
		// 1=星期日 7=星期六，其他类推
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	public static String getWeekStr(String sdate)
	{
		String str = "";
		str = DateUtil.getWeek(sdate);
		if ("1".equals(str))
		{
			str = "星期日";
		} else if ("2".equals(str))
		{
			str = "星期一";
		} else if ("3".equals(str))
		{
			str = "星期二";
		} else if ("4".equals(str))
		{
			str = "星期三";
		} else if ("5".equals(str))
		{
			str = "星期四";
		} else if ("6".equals(str))
		{
			str = "星期五";
		} else if ("7".equals(str))
		{
			str = "星期六";
		}
		return str;
	}

	/**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDays(String date1, String date2)
	{
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat(DATE_STYLE1);
		Date date = null;
		Date mydate = null;
		try
		{
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e)
		{
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 形成如下的日历 ， 根据传入的一个时间返回一个结构 星期日 星期一 星期二 星期三 星期四 星期五 星期六 下面是当月的各个时间
	 * 此函数返回该日历第一行星期日所在的日期
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getNowMonth(String sdate)
	{
		// 取该时间所在月的一号
		sdate = sdate.substring(0, 8) + "01";

		// 得到这个月的1号是星期几
		Date date = DateUtil.strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int u = c.get(Calendar.DAY_OF_WEEK);
		String newday = DateUtil.getNextDay(sdate, (1 - u) + "");
		return newday;
	}

	/**
	 * 取得数据库主键 生成格式为yyyymmddhhmmss+k位随机数
	 * 
	 * @param k
	 *            表示是取几位随机数，可以自己定
	 */

	public static String getNo(int k)
	{

		return getUserDate("yyyyMMddhhmmss") + getRandom(k);
	}

	/**
	 * 返回一个随机数
	 * 
	 * @param i
	 *            表示是取几位随机数，可以自己定
	 * @return
	 */
	public static String getRandom(int i)
	{
		Random jjj = new Random();
		if (i == 0)
			return "";
		String jj = "";
		for (int k = 0; k < i; k++)
		{
			jj = jj + jjj.nextInt(9);
		}
		return jj;
	}

	/**
	 * 
	 * @param args
	 */
	public static boolean RightDate(String date)
	{

		SimpleDateFormat sdf = new SimpleDateFormat(DTIME_STYLE1);
		;
		if (date == null)
			return false;
		if (date.length() > 10)
		{
			sdf = new SimpleDateFormat(DTIME_STYLE1);
		} else
		{
			sdf = new SimpleDateFormat(DATE_STYLE1);
		}
		try
		{
			sdf.parse(date);
		} catch (ParseException pe)
		{
			return false;
		}
		return true;
	}

	/**
	 * 判断当前时间是否在给定两个时间之间
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean currentIsBetween(String startTime, String endTime)
	{
		String nowTime = getTimeShort();
		Calendar startDate = stringToCalendar(startTime, TIME_STYLE1);
		Calendar endDate = stringToCalendar(endTime, TIME_STYLE1);
		Calendar currentDate = stringToCalendar(nowTime, TIME_STYLE1);
		return (currentDate.after(startDate) && currentDate.before(endDate)) || nowTime.equals(startTime) || nowTime.equals(endTime);
	}

	/**
	 * 获取当前时间与给定时间之间的差值
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String getStringNowToEnd(String endTime, int chaoShiShiKe)
	{
		String nowTime = getTimeShort();
		Calendar endDate = stringToCalendar(endTime, TIME_STYLE1);
		Calendar currentDate = stringToCalendar(nowTime, TIME_STYLE1);
		int H = 0, M = 0, S = 0;
		if (currentDate.getTime().getHours() > endDate.getTime().getHours())
		{// 当前时间先于计划时间
			H = currentDate.getTime().getHours() - endDate.getTime().getHours() - chaoShiShiKe;
			M = currentDate.getTime().getMinutes() - endDate.getTime().getMinutes();
			S = currentDate.getTime().getSeconds() - endDate.getTime().getSeconds();
		} else if (currentDate.getTime().getHours() == endDate.getTime().getHours())
		{// 当前时间等于计划时间
			H = endDate.getTime().getHours() - currentDate.getTime().getHours();
			M = 60 - Math.abs((endDate.getTime().getMinutes() - currentDate.getTime().getMinutes()));
			S = 60 - Math.abs((endDate.getTime().getSeconds() - currentDate.getTime().getSeconds()));
		} else
		{// 当前时间晚于计划时间
			H = endDate.getTime().getHours() - currentDate.getTime().getHours() + chaoShiShiKe;
			M = endDate.getTime().getMinutes() - currentDate.getTime().getMinutes();
			S = endDate.getTime().getSeconds() - currentDate.getTime().getSeconds();
		}

		if (M < 0 && H > 0)
		{
			M += 60;
			H -= 1;
		}

		if (S < 0 && M > 0)
		{
			S += 60;
			M -= 1;
		}
		if (S < 0 && M < 0 && H > 0)
		{
			H -= 1;
			M += 60;
			M -= 1;
			S += 60;
		}
		if (S >= 0)
		{
			// 改为倒计时
			S = 60 - S;
		} else
		{
			// 改为倒计时
			S = 60 + S;
		}
		// 当天一个小时以内
		if (H >= 0 && H < 1)
		{
			return ("0" + Math.abs(H)) + "时" + Math.abs(M) + "分" + Math.abs((S)) + "秒";
		} else if (H >= 1)
		{
			return ("1" + Math.abs(H)) + "时" + Math.abs(M) + "分" + Math.abs((S)) + "秒";
		} else if (H < 0)
		{
			return ("2" + Math.abs(H)) + "时" + Math.abs(M) + "分" + Math.abs((S)) + "秒";
		}
		return nowTime;

	}

	/**
	 * A时间是否晚于B时间
	 * 
	 * @param aTime
	 * @param bTime
	 * @return
	 */
	public static boolean isAAfterB(String aTime, String bTime)
	{
		Calendar A = stringToCalendar(aTime, DATE_STYLE1);
		Calendar B = stringToCalendar(bTime, DATE_STYLE1);
		return A.after(B) || aTime.equals(bTime);
	}

	/**
	 * A时间是否晚于B时间
	 * 
	 * @param aTime
	 * @param bTime
	 * @return
	 */
	public static boolean isAAfterBWithFromatString(String aTime, String bTime, String format)
	{
		Calendar A = stringToCalendar(aTime, format);
		Calendar B = stringToCalendar(bTime, format);
		return A.after(B) || aTime.equals(bTime);
	}

	/**
	 * A时间是否先于B时间
	 * 
	 * @param aTime
	 * @param bTime
	 * @return
	 */
	public static boolean isABeforeB(String aTime, String bTime)
	{
		Calendar A = stringToCalendar(aTime, DATE_STYLE1);
		Calendar B = stringToCalendar(bTime, DATE_STYLE1);
		return A.before(B) || aTime.equals(bTime);
	}

	/**
	 * A时间是否晚于B时间
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean isADataAfterBData(Date A, Date B)
	{
		try
		{
			return A.after(B);
		} catch (Exception e)
		{
			// TODO: handle exception
			return false;
		}

	}

	/**
	 * A时间是否晚于B时间
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean isADataTweenBData(Date A, Date B)
	{
		return A.equals(B);
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return
	 */
	public static String getFirstDayOfNowMonth(String dateStyle)
	{
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		SimpleDateFormat formatter = new SimpleDateFormat(dateStyle);
		return formatter.format(c.getTime());
	}

	/**
	 * 获取当前月最后一天
	 * 
	 * @return
	 */
	public static String getLastDayOfNowMonth(String dateStyle)
	{
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat formatter = new SimpleDateFormat(dateStyle);
		return formatter.format(ca.getTime());
	}
}
