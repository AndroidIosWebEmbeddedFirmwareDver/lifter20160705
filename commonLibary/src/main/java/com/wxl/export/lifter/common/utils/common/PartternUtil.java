package com.wxl.export.lifter.common.utils.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @com.wxl.export.lifter.common.utils.common
 * @HuiyuantongVenusShopCash-V3.x
 * @PartternUtil.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 正则表达式工具
 * @2015-3-9下午4:24:00
 */
public class PartternUtil
{

	/**
	 * 号段简介 手机号码前三位列表： 三大运营商最新号段 合作版 移动号段： 134 135 136 137 138 139 147 150 151
	 * 152 157 158 159 178 182 183 184 187 188 联通号段： 130 131 132 145 155 156 176
	 * 185 186 电信号段： 133 153 177 180 181 189 虚拟运营商: 170
	 * 
	 * 13(老)号段：130、131、132、133、134、135、136、137、138、139
	 * 15(新)号段：150、151、152、153、154、155、156、157、158、159
	 * 18(3G)号段：180、181、182、183、184、185、186、187、188、189 13(老)号段 130：中国联通，GѕM
	 * 131：中国联通，GѕM 132：中国联通，GѕM 133：中国联通转给中国电信，CDMA 134：中国移动，GѕM 135：中国移动，GѕM
	 * 136：中国移动，GѕM 137：中国移动，GѕM 138：中国移动，GѕM 139：中国移动，GѕM 15(新)号段 150：中国移动，GѕM
	 * 151：中国移动，GѕM 152：中国联通，暂时未对外放号 153：中国联通转给中国电信，CDMA
	 * 154：154号段暂时没有分配，估计是因为154的谐音是“要吾死”，这样的手机号码谁敢要啊？ 155：中国联通，GѕM 156：中国联通，GѕM
	 * 157：中国移动，GѕM 158：中国移动，GѕM 159：中国移动，GѕM 18(3G)号段 180：中国电信，3G，尚未开始对外放号
	 * 181：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号 182：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号
	 * 183：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号 184：3G服务的手机号段，目前没有分配给哪个运营商，也尚未开始对外放号
	 * 185：中国联通，3G，尚未开始对外放号 186：中国联通，3G，内部消息,已开始对外放号 187：中国移动，3G，尚未开始对外放号
	 * 188：中国移动，3G，目前TD测试服务在部分城市对外放号 189：中国电信，3G，сDMA，天翼189，2008年底开始对外放号
	 */
	/**
	 * 利用正则表达式验证电话号码
	 * 
	 * @param Number
	 * @return
	 */
	public static boolean isMobilePone(String Number)
	{
		// // 匹配手机号码正则字符串+匹配固话号码正则字符串（支持手机号码，3-4位区号，7-8位直播号码，1－4位分机号）
		// String phonePatternRuleString =
		// "(d{11})|^((d{7,8})|(d{4}|d{3})-(d{7,8})|(d{4}|d{3})-(d{7,8})-(d{4}|d{3}|d{2}|d{1})|(d{7,8})-(d{4}|d{3}|d{2}|d{1}))$";
		// 匹配手机号码正则字符串
		String mobilePhonePatternRuleString = "^((13[0-9])|(14[6,7])|(15[0-9])|(17[0,6-8])|(18[0-9]))\\d{8}$";
		try
		{
			/* 创建Pattern */
			Pattern pattern = Pattern.compile(mobilePhonePatternRuleString);
			/* 将Pattern 以参数传入Matcher作Regular expression */
			Matcher matcher = pattern.matcher(Number);
			return matcher.matches();
		} catch (Exception e)
		{
			// TODO: handle exception
			return false;
		}

	}

	public static boolean isHardPhone(String Number)
	{
		// 匹配固话号码正则字符串（3-4位区号，7-8位直播号码，1－4位分机号）
		String hardPhonePatternResultString = "^(0[0-9]{2,3}-?)?([2-9][0-9]{6,7})+(-?[0-9]{1,4})?$";
		try
		{
			/* 创建Pattern */
			Pattern pattern = Pattern.compile(hardPhonePatternResultString);
			/* 将Pattern 以参数传入Matcher作Regular expression */
			Matcher matcher = pattern.matcher(Number);
			return matcher.matches();
		} catch (Exception e)
		{
			// TODO: handle exception
			return false;
		}

	}

	/**
	 * 判断指定字符串是否是电话号码
	 * 
	 * @param Number
	 * @return
	 */
	public static boolean isPhone(String Number)
	{
		return (isMobilePone(Number)) || (isHardPhone(Number));
	}

	/**
	 * 判断金额是否符合标准
	 * 
	 * @param money
	 * @return
	 */
	public static boolean isMoneyString(String money)
	{
		if (money == null || money.isEmpty())
		{
			return false;
		}

		Pattern pattern = Pattern.compile("(\\d|([1-9]\\d{0,6}))|((\\d|([1-9]\\d{0,6}))(\\.\\d{1,2}))");
		Matcher matcher = pattern.matcher(money);
		return matcher.matches();
	}

	/**
	 * 是否是身份证
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isIdcard(String string)
	{
		if (string == null || string.isEmpty())
		{
			return false;
		}

		Pattern pattern = Pattern.compile("(\\d{17}|\\d{14})[0-9a-zA-Z]");
		Matcher matcher = pattern.matcher(string);
		return matcher.matches();
	}
}
