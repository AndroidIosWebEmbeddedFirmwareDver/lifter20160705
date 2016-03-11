package com.wxl.export.lifter.common.event;

/**
 * 
 * @ClassName: 事件编码
 * @Description: TODO
 * @author wxl.sinto.cto
 * @date 2014-9-12 下午2:44:16
 * 
 */

public class EventCode
{

	protected static int CODE_INC = 0;
	public static final int ZERO_CODE = CODE_INC++;
	public static final int HTTPGET_Download = CODE_INC++;// 网络获取——下载
	/**
	 * 网络常量编码
	 */
	public static final int HTTP_POST_VERIFY_ACCOUNT_EVENT = CODE_INC++;// 账号验证
	public static final int HTTP_POST_SET_PASSWORD_EVENT = CODE_INC++;// 设置密码
	public static final int HTTP_GET_APPVERSION_QUERYLATEST= CODE_INC++;// major登陆
	public static final int HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_IN = CODE_INC++;// major登陆
	public static final int HTTP_POST_SHOPMANAGERACCOUNT_LOGIN_OUT = CODE_INC++;// major登陆
	public static final int HTTP_POST_ORDER_CREATE = CODE_INC++;//
	public static final int HTTP_GET_ORDER_QUERY_STATUS = CODE_INC++;//
	public static final int HTTP_POST_ORDER_QUERY = CODE_INC++;//
	public static final int HTTP_POST_ORDER_QUERYTOTALMONEY = CODE_INC++;//

	public static final int POS_CRASH_EVENT = CODE_INC++;//pos机收银事件





	public static final int HTTP_GET_LOGOUT_EVENT = CODE_INC++;// major登出
	public static final int HTTP_POST_REGIST_DEVICE_EVENT = CODE_INC++;// 注册设备
	public static final int HTTP_GET_REGIST_ACCOUNT_EVENT = CODE_INC++;// 注册账户（告诉服务器该账户已经登录）

	public static final int HTTP_POST_RESETPASSWORD_EVENT = CODE_INC++;// 重置密码
	public static final int HTTP_POST_CHECKVERIFICATIONCODE_EVENT = CODE_INC++;// 验证验证码

	public static final int HTTP_POST_QUERYPERFORMANCE_RESULTS = CODE_INC++;// 业绩查询
	public static final int HTTP_POST_QUERYRECOED_RESULTS = CODE_INC++;// 流水查询
	public static final int HTTP_POST_QUERYSTATISTICS_RESULTS = CODE_INC++;// 统计查询

	public static final int HTTP_GET_QUERYCONSUME_INFO = CODE_INC++;// 消费详情查询
	public static final int HTTP_GET_QUERYRECHARGE_INFO = CODE_INC++;// 充值详情查询
	public static final int HTTP_GET_QUERYPACKAGE_INFO = CODE_INC++;// 套餐详情查询

	public static final int HTTP_GET_QUERYVERSION = CODE_INC++;// 版本查询
	public static final int HTTP_POST_UPDATEPASSWORD_EVENT = CODE_INC++;// 修改密码
	public static final int HTTP_GET_QUERYUSERINFO = CODE_INC++;// 个人信息查询
	public static final int HTTP_POST_GETIDENTIFYINGCODE = CODE_INC++;// 店铺排行查询
	public static final int HTTP_POST_BINDPHONE = CODE_INC++;// 店铺排行查询

	public static final int HTTP_POST_UPDATE_PHOTO = CODE_INC++;//修改头像事件
	public static final int HTTP_POST_QUERY_FIRST_CATEGORY_LIST = CODE_INC++;// 获取一级行业列表
	public static final int HTTP_POST_QUERY_SECOND_CATEGORY_LIST = CODE_INC++;// 获取二级行业列表
	public static final int HTTP_POST_GET_VERIFICATION_CODE = CODE_INC++;// 获取验证码
	public static final int HTTP_POST_REGISTER_ENTERPRISE = CODE_INC++;// 注册企业
	public static final int HTTP_GET_QUERY_ENTERPRISE_INFO = CODE_INC++;// 查询企业信息
	public static final int HTTP_POST_UPDATE_ENTERPRISE_INFO = CODE_INC++;// 更新企业信息
	public static final int HTTP_POST_QUERY_SHOP_LIST = CODE_INC++;// 查询店铺列表
	public static final int HTTP_POST_ADD_SHOP = CODE_INC++;// 添加店铺
	public static final int HTTP_POST_UPDATE_SHOP_INFO = CODE_INC++;// 更新店铺
	public static final int HTTP_POST_QUERY_SHOP_CASHIER_LIST = CODE_INC++;// 查询管理员列表
	public static final int HTTP_POST_ADD_SHOP_CASHIER = CODE_INC++;// 添加管理员
	public static final int HTTP_GET_DELETE_SHOP_CASHIER = CODE_INC++;// 删除管理员
	public static final int HTTP_POST_UPDATE_SHOP_CASHIER = CODE_INC++;// 更新管理员
	public static final int HTTP_POST_QUERY_BANK_LIST = CODE_INC++;// 查询银行列表
	public static final int HTTP_POST_QUERY_BINDING_BANK_LIST = CODE_INC++;// 查询提现账户列表
	public static final int HTTP_POST_ADD_BINDING_BANK = CODE_INC++;// 添加提现账户
	public static final int HTTP_GET_DELETE_BANDING_BANK = CODE_INC++;// 删除提现账户
	public static final int HTTP_GET_QUERY_BANLANCE = CODE_INC++;// 查询企业到账金额
	public static final int HTTP_POST_WALLET_WITHDRAW = CODE_INC++;// 提现

	public static final int HTTP_POST_QUERYONLINEPAYORDER = CODE_INC++;// 收入流水
	public static final int HTTP_POST_QUERYWITHDRAWORDER = CODE_INC++;// 提现流水
	public static final int HTTP_POST_SET_WITHDRAW_PASSWORD = CODE_INC++;// 设置体现密码
	public static final int HTTP_POST_QUERY_FIRST_REGION_LIST = CODE_INC++;// 查询省份列表
	public static final int HTTP_POST_QUERY_SUB_REGION_LIST = CODE_INC++;// 查询下级地区列表
	public static final int HTTP_GET_VERIFY_WITHDRAW_PASSWORD = CODE_INC++;// 验证提现密码
	public static final int HTTP_POST_BIND_WEINXIN_QRCODE = CODE_INC++;// 绑定微信二维码
	public static final int HTTP_GET_BINDING_WEIXIN_QRCODE = CODE_INC++;// 查询已绑定的微信二维码
	public static final int HTTP_POST_BINDING_ALIPAY_QRCODE = CODE_INC++;// 绑定支付宝二维码
	public static final int HTTP_GET_BINDING_ALIPAY_QRCODE = CODE_INC++;// 查询已绑定的支付宝二维码\

	public static final int HTTP_GET_QUERY_UNREAD_NOTIFICATION_FOR_ALL_CATEGORY = CODE_INC++;// 查询所有种类的未读消息数量
	public static final int HTTP_GET_QUERY_UNREAD_NOTIFICATION_FOR_EVERY_CATEGORY = CODE_INC++;// 查询每一种种类的未读消息数量
	public static final int HTTP_GET_QUERY_TRADE_ORDER_DETAIL = CODE_INC++;// 查询交易流水详情
	public static final int HTTP_GET_QUERY_WITHDRAW_ORDER_DETAIL = CODE_INC++;// 查询体现流水详情
	public static final int HTTP_POST_UPDATE_PASSWORD = CODE_INC++;// 更新密码
	public static final int HTTP_GET_QUERY_ACCOUNT_LIST_FROM_PHONE = CODE_INC++;// 查询登录账户列表
	public static final int HTTP_POST_QUERY_NOTIFICATION_LIST = CODE_INC++;// 查询通知消息列表
	public static final int HTTP_POST_QUERY_INCOME_MESSAGE_LIST = CODE_INC++;// 查询收款消息列表
	public static final int HTTP_POST_QUERY_WITHDRAW_MESSAGE_LIST = CODE_INC++;// 查询提现消息列表
	public static final int HTTP_POST_QUERY_EVENT_MESSAGE_LIST = CODE_INC++;// 查询活动消息列表
	public static final int HTTP_GET_QUERY_ACCUMULATIVE_MONEY = CODE_INC++;// 查询自上一次领取反润奖励到现在累计交易金额
	public static final int HTTP_GET_QUERY_RETRUN_MONEY_RECODES = CODE_INC++;// 查询反润奖励领取记录
	public static final int HTTP_GET_RETURN_MONEY = CODE_INC++;// 领取反润奖励

	/**
	 * 上传系统重要BUG
	 */
	public static final int HTTP_POST_APPLICTION_ERROR = CODE_INC++;// 上传系统重要BUG

	/**
	 * 数据库常量编码
	 */
	public static final int DB_ShopHandle = CODE_INC++;

	/**
	 * 回调常量编码
	 */
	public static final int CALLBACK_Locationed = CODE_INC++;// 定位
	public static final int CALLBACK_SAME_ACCOUNT_ANOTHER_PLACE_LOGIN = CODE_INC++;// 其他设备登陆
	public static final int CALLBACK_APPLICATION_NOTIFICATION_TO_ACTIVITY = CODE_INC++;// APPLICTION发送给界面的通知
	public static final int CALLBACK_DownloadProgress = CODE_INC++;// APPLICTION发送给界面的通知
	public static final int CALLBACK_OF_BINDPHONE_SUCESS = CODE_INC++;// APPLICTION发送给界面的通知
	public static final int CALLBACK_OF_CHOICESERVER_OK = CODE_INC++;// 选择服务器OK
	public static final int CALLBACK_OF_WALLET_WITHDRAW_OK = CODE_INC++;// 提现OK
	public static final int CALLBACK_OF_WALLET_WITHDRAW_OK_TO_MYSELF = CODE_INC++;// 提现OK
	public static final int CALLBACK_IN_FRAGMENT_TASK_ACTIVITY_THAT_NET_ERROR = CODE_INC++;// 提现OK
	public static final int CALLBACK_OF_CHECKLOGIN_OK = CODE_INC++;// 检查是否登录
	public static final int CALLBACK_OF_CANUPDATE_AREYOU_SURE_TO_UPDATE = CODE_INC++;// 检查是否登录
	public static final int CALLBACK_OF_CASHIER_INFO_UPDATE = CODE_INC++;// 收银员信息更新
	public static final int CALLBACK_OF_SHOP_INFO_UPDATE = CODE_INC++;// 店铺信息更新
	public static final int CALLBACK_OF_REGISTER_DEVICE = CODE_INC++;// 注册设备
	public static final int CALLBACK_OF_RECEIVE_NEW_MESSAGE = CODE_INC++;// 接收到新消息的回调
	public static final int CALLBACK_OF_READ_MESSAGE = CODE_INC++;// 读取消息的回调
	public static final int CALLBACK_OF_READ_WITHDRAW_MESSAGE = CODE_INC++;// 读取提现消息的回调
	public static final int CALLBACK_OF_READ_NOTIFICATION = CODE_INC++;// 读取通知消息的回调
	public static final int CALLBACK_OF_READ_INCOME_MESSAGE = CODE_INC++;// 读取收款消息的回调
	public static final int CALLBACK_OF_READ_EVENT_MESSAGE = CODE_INC++;// 读取活动消息的回调
	public static final int CALLBACK_OF_ENSURE_MESSAGE = CODE_INC++;// 确认消息的回调，一般指读取提示消息的对话框
	public static final int CALLBACK_OF_CLICK_NOTIFICATION = CODE_INC++;// 通知栏通知点击的回调
	/**
	 * 对话框回调
	 */
	public static final int DIALOG_OF_NORMAL_MESSAGE_SURE_BTN_PRESS_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_PRESS_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_PERFORMANCE_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_SHOPRANK_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_COMPLAINT_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_MESSAGEACTIVITY_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_ENTER_PASSWORD_CALLBACK = CODE_INC++; //输入密码对话框回调
	public static final int DIALOG_OF_NORMAL_SET_WITHDRAW_PASSWORD_CALLBACK = CODE_INC++; //设置提现密码回调对话框
	public static final int DIALOG_OF_NORMAL_CANCEL_CALLBACK = CODE_INC++; //设置提现密码回调对话框
	public static final int DIALOG_OF_NORMAL_LOGIN_NOW_CALLBACK = CODE_INC++; //注册成功后是否登录对话框
	public static final int DIALOG_OF_NORMAL_PHONE_CALLED_PRESS_CALLBACK = CODE_INC++; //电话呼叫对话框
	public static final int DIALOG_OF_NORMAL_CHOICE_PHOTO_CALLBACK = CODE_INC++; //照片来源选择对话框

	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETIN_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_WALLETINOUTRECORDSACTIVITY_IN_FRAGMENT_TO_WALLETOUT_CALLBACK = CODE_INC++;

	public static final int DIALOG_OF_NORMAL_CHOICE_OF_SAFELOGOUT_CALLBACK = CODE_INC++;
	public static final int DIALOG_OF_NORMAL_CHOICE_OF_SURETOCALLPHONE_CALLBACK = CODE_INC++;

	public static final int DIALOG_CALLBACK_O_CANCLE_QRCODE_PAY = CODE_INC++;
	public static final int CALLBACK_OF_QRCODE_PAY_SUCESS = CODE_INC++;
	public static final int CALLBACK_OF_QRCODE_PAY_TIMEOUT = CODE_INC++;
	public static final int DIALOG_CALLBACK_OF_EXIT = CODE_INC++;


//	public static final int DIALOG_CALLBACK_OF_OPEN_BLUETOOTH = CODE_INC++;  //是否打开蓝牙回调

	// 消费业绩流水回调
	public static final int DIALOG_OF_NORMAL_CHOICE_DATE_FOR_CONSUMEORDER_CALLBACK = CODE_INC++;

}
