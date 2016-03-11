package com.wxl.export.lifter.common.utils.common;


import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/**
 * 
 * @author Wxl@Sintn.Inc
 * @data 下午1:55:40
 * @desc 常用单位转换的辅助类
 */
public class DensityManagerUtils {
	private DensityManagerUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 * 
	 * @param context
	 * @param val
	 * @return
	 */
	public static int dp2px(Context context, float dpVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * 根据手机的分辨率从 sp 的单位 转成为 px(像素)
	 * 
	 * @param context
	 * @param val
	 * @return
	 */
	public static int sp2px(Context context, float spVal) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics());
	}

	/**
	 * 根据手机的分辨率从 px(像素)转成为 dp 的单位
	 * 
	 * @param context
	 * @param pxVal
	 * @return
	 */
	public static float px2dp(Context context, float pxVal) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (pxVal / scale);
	}

	/**
	 * 根据手机的分辨率从 px(像素)转成为 sp 的单位
	 * 
	 * @param fontScale
	 * @param pxVal
	 * @return
	 */
	public static float px2sp(Context context, float pxVal) {
		return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int getScreenWithPx(Context context) {
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		// Display display = manager.getDefaultDisplay();
		// return display.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(dm);
		return dm.widthPixels;
	}

	public static int getScreenHightPx(Context context) {
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		// Display display = manager.getDefaultDisplay();
		// return display.getHeight();
		DisplayMetrics dm = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(dm);
		return dm.heightPixels;
	}

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().densityDpi;
		return (int) (dipValue * (scale / 160) + 0.5f);
	}

	public static int px2dpMeth2(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) ((pxValue * 160) / scale + 0.5f);
	}

	/**
	 * 获取屏幕宽度dp数
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenWithDp(Context context) {
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		// Display display = manager.getDefaultDisplay();
		// return display.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(dm);
		return dip2px(context, dm.widthPixels);
	}

	/**
	 * 获取屏幕高度dp数
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenHightDp(Context context) {
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		// Display display = manager.getDefaultDisplay();
		// return display.getHeight();
		DisplayMetrics dm = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(dm);
		return dip2px(context, dm.heightPixels);
	}

	/**
	 * 获取屏幕物理尺寸,保留一位小数
	 * 
	 * @param context
	 * @return
	 */
	public static double getScreenPhysicSizeWithInch(Context context) {
		// 屏幕密度(每寸像素): densityDPI = 二次方(w*w + h*h) / 屏幕英寸
		// DisplayMetrics dm = getResources().getDisplayMetrics();
		// screenWidth = dm.widthPixels; // 屏幕宽（像素，如：480px）
		// screenHeight = dm.heightPixels; // 屏幕高（像素，如：800px）
		// int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
		WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm = new DisplayMetrics();
		manager.getDefaultDisplay().getMetrics(dm);
		// int widthPixels = dm.widthPixels; // 屏幕宽度（像素）
		// int heightPixels = dm.heightPixels; // 屏幕高度（像素）
		// int densityDPI = dm.densityDpi;// 屏幕密度DPI（120 / 160 / 240）
		// float density = dm.density;// 屏幕密度（0.75 / 1.0 / 1.5）
		return CommonUtils.retainDoubleDecimal(Math.sqrt(Math.pow(getRealDeviceWidthInPixels(context) / dm.xdpi, 2) + Math.pow(getRealDeviceHeightInPixels(context) / dm.ydpi, 2)), 1);
	}

	/**
	 * 获取屏幕保护状态栏、虚拟键盘在内的实际屏幕高度px数
	 * 
	 * @param context
	 * @return
	 */
	public static int getRealDeviceHeightInPixels(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);
		// since SDK_INT = 1;
		int mHeightPixels = displayMetrics.heightPixels;
		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
			try {
				mHeightPixels = (Integer) Display.class.getMethod("getRawHeight").invoke(display);
			} catch (Exception ignored) {
			}
		}
		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 17) {
			try {
				Point realSize = new Point();
				Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
				mHeightPixels = realSize.y;
			} catch (Exception ignored) {
			}
		}
		return mHeightPixels;
	}

	/**
	 * 获取屏幕保护状态栏、虚拟键盘在内的实际屏幕宽度px数
	 * 
	 * @param context
	 * @return
	 */
	public static int getRealDeviceWidthInPixels(Context context) {
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);
		// since SDK_INT = 1;
		int mWidthPixels = displayMetrics.widthPixels;
		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 14 && Build.VERSION.SDK_INT < 17) {
			try {
				mWidthPixels = (Integer) Display.class.getMethod("getRawWidth").invoke(display);
			} catch (Exception ignored) {
			}
		}
		// includes window decorations (statusbar bar/menu bar)
		if (Build.VERSION.SDK_INT >= 17) {
			try {
				Point realSize = new Point();
				Display.class.getMethod("getRealSize", Point.class).invoke(display, realSize);
				mWidthPixels = realSize.x;
			} catch (Exception ignored) {
			}
		}
		return mWidthPixels;
	}

	public static void showBar() {
		/*
		 * 恢复运行Android 4.0以上系统的平板的屏幕下方的状态栏
		 */
		try {
			Process proc = Runtime.getRuntime().exec(new String[]
			{ "am", "startservice", "-n", "com.android.systemui/.SystemUIService" });
			proc.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void hideBar() {
		/*
		 * 隐藏运行Android 4.0以上系统的平板的屏幕下方的状态栏
		 */
		try {
			String ProcID = "79";
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
				ProcID = "42"; // ICS
			// 需要root 权限
			Process proc = Runtime.getRuntime().exec(new String[]
			{ "su", "-c", "service call activity " + ProcID + " s16 com.android.systemui" }); // WAS
			proc.waitFor();
		} catch (Exception ex) {
		}
	}
}
