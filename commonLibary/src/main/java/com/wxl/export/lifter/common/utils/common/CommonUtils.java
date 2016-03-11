package com.wxl.export.lifter.common.utils.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.wxl.export.lifter.common.manager.SharedPreferenceManager;

/**
 * @com.wxl.export.lifter.common.utils.core
 * @HuiyuantongVenusShopCash-V3.x
 * @CommonUtils.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 公用工具类
 * @2015-2-4下午2:50:37
 */
@SuppressLint(
        {"DefaultLocale", "SimpleDateFormat"})
public class CommonUtils {

    public static String APPUPDATECACHENAME = "HeraMobileCash_upldate_cache.apk";


    /**
     * 判断Activity是否存在
     *
     * @param context
     * @param clazz
     */
    public static boolean checkActivity(Context context, Class clazz) {
        //、判断Activity是否存在
        Intent intent = new Intent();
        intent.setClassName(clazz.getPackage().getName(), clazz.getName());
        //方法一：
        if (context.getPackageManager().resolveActivity(intent, 0) == null) {
            // 说明系统中不存在这个activity
            return false;
        }
        return true;
//		//方法二：
//		if(intent.resolveActivity(getPackageManager()) == null) {
//			// 说明系统中不存在这个activity
//		}
//		//方法三：
//		List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, 0);
//		if (list.size() == 0) {
//			// 说明系统中不存在这个activity
//		}
    }

    /**
     * 获取全局Application SharedPreferences对象
     *
     * @return
     */
    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return SharedPreferenceManager.getSharedPreferences(context);
    }

    public static String getApplicationVersion(Context context) {
        try {// 获取当前版本号
            PackageManager pm = context.getPackageManager();
            PackageInfo pi;
            pi = pm.getPackageInfo(context.getPackageName(), 0);// getPackageName()是你当前类的包名，0代表是获取版本信息
            return pi.versionName;
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取屏幕的尺寸
     *
     * @param context
     * @return
     */
    @SuppressWarnings("deprecation")
    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();// 屏幕宽度
        int height = wm.getDefaultDisplay().getHeight();// 屏幕高度
        int[] size =
                {width, height};
        return size;
    }

    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int statusBarHeight = 0;
        // 这里只需要获取屏幕高度
        int screenHeight = getScreenSize(context)[1];

        switch (screenHeight) {
            case 240:
                statusBarHeight = 20;
                break;
            case 480:
                statusBarHeight = 25;
                break;
            case 800:
                statusBarHeight = 38;
                break;
            default:
                break;
        }

        return statusBarHeight;
    }

    @SuppressWarnings("deprecation")
    public static int getAndroidSdkVersionCode() {
        int version = 0;
        try {
            version = Integer.valueOf(android.os.Build.VERSION.SDK);
        } catch (NumberFormatException e) {
        }
        return version;
    }

    /**
     * 保留float小数
     *
     * @param ft
     * @param scale // 设置位数,几位小数就是几
     */
    public static float retainFloatDecimal(float ft, int scale) {
        int roundingMode = 4;// 表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal((double) ft);
        bd = bd.setScale(scale, roundingMode);
        return bd.floatValue();
    }

    /**
     * 保留Double小数
     *
     * @param db
     * @param scale // 设置位数,几位小数就是几
     */
    public static Double retainDoubleDecimal(Double db, int scale) {
        int roundingMode = 4;// 表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
        BigDecimal bd = new BigDecimal((double) db);
        bd = bd.setScale(scale, roundingMode);
        return bd.doubleValue();
    }

	/* 函数段end */

    /**
     * 截取IP地址
     *
     * @param str
     * @return
     */
    public static String getIp(String str) {
        String ip;
        String s = str.substring(7);
        String[] arrayStr = s.split(":");
        ip = arrayStr[0];
        return ip;
    }

    /**
     * 截取端口号
     *
     * @param str
     * @return
     */
    public static String getPort(String str) {
        String port;
        String s = str.substring(7);
        String[] arrayStr = s.split(":");
        String temp = arrayStr[1];
        String[] temp0 = temp.split("/");
        port = temp0[0];
        return port;
    }

    /**
     * 生成Sign方法
     */
    public static String makeSign(String masterSecret, Map<String, Object> params) throws IllegalArgumentException {
        if (masterSecret == null || params == null) {
            throw new IllegalArgumentException("masterSecret and params can not be null.");
        }

        if (!(params instanceof SortedMap)) {
            params = new TreeMap<String, Object>(params);
        }

        StringBuilder input = new StringBuilder(masterSecret);
        for (Entry<String, Object> entry : params.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String || value instanceof Integer || value instanceof Long) {
                input.append(entry.getKey());
                input.append(entry.getValue());
            }
        }

        return getMD5Str(input.toString());
    }

    /**
     * MD5加密
     */
    public static String getMD5Str(String sourceStr) {
        byte[] source = sourceStr.getBytes();
        String s = null;
        char hexDigits[] =
                { // 用来将字节转换成 16 进制表示的字符
                        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            // #debug
            e.printStackTrace();
        }
        if (md == null)
            return null;
        md.update(source);
        byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
        // 用字节表示就是 16 个字节
        char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
        // 所以表示成 16 进制需要 32 个字符
        int k = 0; // 表示转换结果中对应的字符位置
        for (int i = 0; i < 16; i++) {
            // 从第一个字节开始，对 MD5 的每一个字节
            // 转换成 16 进制字符的转换
            byte byte0 = tmp[i]; // 取第 i 个字节
            str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
            // >>> 为逻辑右移，将符号位一起右移
            str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
        }
        s = new String(str); // 换后的结果转换为字符串
        return s;
    }

    /**
     * 验证ip和端口是否符合格式要求
     *
     * @param ip
     * @param port
     * @return
     */

    public static boolean check(String ip, String port) {
        boolean result = false;
        String ipRegex = "^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))$";
        String portRegex = "^\\d{1,6}$";
        if (Pattern.matches(ipRegex, ip) && Pattern.matches(portRegex, port)) {
            result = true;
        }
        return result;
    }

    /**
     * 使用MD5 32位加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String md5(String str) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            re_md5 = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;

    }

    /**
     * md5二次加密
     *
     * @param str
     * @return
     */
    public static String MD5(String str) {
        return md5(md5(str).substring(8, 24));
    }

    /**
     * size 如果 小于1024 * 1024,以KB单位返回,反则以MB单位返回
     *
     * @return
     */
    public static String formatDataSize(int size) {
        String ret = "";
        if (size < (1024 * 1024)) {
            ret = String.format("%dK", size / 1024);
        } else {
            ret = String.format("%.1fM", size / (1024 * 1024.0));
        }
        return ret;
    }

    /**
     * 指定保留n位小数 不四舍五入
     *
     * @param str
     * @param keepType   "#0.##" 假如两位
     * @param keepLength ".00" 假如两位
     * @return
     */
    public static String formatDouble(Double str, String keepType, String keepLength) {
        // 定义一个数字格式化对象，格式化模板为".#"，即保留1位小数.
        DecimalFormat b = new DecimalFormat(keepType);
        b.applyPattern(keepLength);
        b.setRoundingMode(RoundingMode.FLOOR); // 不四舍五入
        String resultData = b.format(str);
        return resultData;
    }

    /**
     * 版本检查
     *
     * @param locateVersion 本地版本号
     * @param netVersion    网络版本号
     * @return
     */
    public static boolean versionCheck(String locateVersion, String netVersion) {
        boolean isUpdate = false;
        if (locateVersion == null || locateVersion.equals("0")) {
            isUpdate = true;
        } else if (netVersion == null) {
            isUpdate = false;
        } else {
            // 先将版本号转换成字符串数组
            String[] localVer = locateVersion.split("[.]");
            String[] netVer = netVersion.split("[.]");

            // 每一位都进行比较
            for (int i = 0; i < localVer.length; i++) {
                if (Integer.parseInt(localVer[i]) < Integer.parseInt(netVer[i])) {
                    isUpdate = true;
                    break;
                } else if (Integer.parseInt(localVer[i]) > Integer.parseInt(netVer[i])) {
                    isUpdate = false;
                    break;
                }
            }
        }
        // 否则没有更新
        return isUpdate;
    }

    // RenderScript是Android在API 11之后加入的，用于高效的图片处理，包括模糊、混合、矩阵卷积计算等，代码示例如下
    @SuppressLint("NewApi")
    public static Bitmap blurBitmap(Context context, Bitmap bitmap) {

        // Let's create an empty bitmap with the same size of the bitmap we want
        // to blur
        Bitmap outBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);

        // Instantiate a new Renderscript
        RenderScript rs = RenderScript.create(context);

        // Create an Intrinsic Blur Script using the Renderscript
        ScriptIntrinsicBlur blurScript = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));

        // Create the Allocations (in/out) with the Renderscript and the in/out
        // bitmaps
        Allocation allIn = Allocation.createFromBitmap(rs, bitmap);
        Allocation allOut = Allocation.createFromBitmap(rs, outBitmap);

        // Set the radius of the blur
        blurScript.setRadius(25.f);

        // Perform the Renderscript
        blurScript.setInput(allIn);
        blurScript.forEach(allOut);

        // Copy the final bitmap created by the out Allocation to the outBitmap
        allOut.copyTo(outBitmap);

        // recycle the original bitmap
        bitmap.recycle();

        // After finishing everything, we destroy the Renderscript.
        rs.destroy();

        return outBitmap;
    }

    /**
     * 获取SD卡根目录
     *
     * @return
     */
    public static String getSDPath() {
        // 判断sd卡是否存在
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))// 如果SD卡存在，则获取跟目录
        {
            return Environment.getExternalStorageDirectory().toString();// 获取跟目录
        } else {
            // 不存在返回空
            return null;
        }
    }

    /**
     * 调用相机照相
     *
     * @param activity
     * @return fileName
     */
    public static String doCamra(Activity activity, String fileName) {
        String filePath = null;
        String sdCarPath = getSDPath();
        // 判断获得的SD卡路径是否为null
        if (sdCarPath != null) {
            String hldPath = sdCarPath + "/HldImage/";
            filePath = hldPath + fileName;
            // 创建文件夹，名称为HldImage，不会重复创建
            File file = new File(hldPath);
            if (!file.exists() && !file.isDirectory())
                file.mkdir();
            // 调用android自带的照相机
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            // 指定照片存储目录
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));
            activity.startActivityForResult(intent, 1);
        } else {
            filePath = null;
        }
        return filePath;
    }

    /**
     * 调用系统图库截图
     *
     * @param activity
     * @param filePath
     */
    public static void cropImageUri(Activity activity, String filePath) {
        String sdCarPath = getSDPath();
        // 判断sd卡是否存在
        if (sdCarPath != null) {
            String hldPath = sdCarPath + "/HldImage/";
            // 创建文件夹，名称为HldImage，不会重复创建
            File file = new File(hldPath);
            if (!file.exists() && !file.isDirectory())
                file.mkdir();
            // 调用系统截图
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(Uri.fromFile(new File(filePath)), "image/*");
            intent.putExtra("scale", true);
            intent.putExtra("aspectX", 5);
            intent.putExtra("aspectY", 5);
            intent.putExtra("outputX", 900);
            intent.putExtra("outputY", 900);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));
            intent.putExtra("return-data", false);
            intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
            intent.putExtra("noFaceDetection", true); // no face detection
            activity.startActivityForResult(intent, 2);
        }
    }

    /**
     * 调用系统图库
     *
     * @param activity
     * @param fileName
     */
    public static String openSysPick(Activity activity, String fileName) {
        String filePath = null;
        String sdCarPath = getSDPath();
        // 判断sd卡是否存在
        if (sdCarPath != null) {
            String hldPath = sdCarPath + "/HldImage/";
            filePath = hldPath + fileName;
            // 创建文件夹，名称为HldImage，不会重复创建
            File file = new File(hldPath);
            if (!file.exists() && !file.isDirectory())
                file.mkdir();
            // 调用系统图库
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 5);
            intent.putExtra("aspectY", 5);
            intent.putExtra("outputX", 900);
            intent.putExtra("outputY", 900);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", false);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(filePath)));
            intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
            intent.putExtra("noFaceDetection", false); // no face detection
            activity.startActivityForResult(intent, 2);
        } else {
            filePath = null;
        }
        return filePath;
    }

    /**
     * 根据Uri获取文件地址
     *
     * @param context
     * @param uri
     * @return
     */
    public static String getFilePath(Context context, Uri uri) {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection =
                    {"_data"};
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    // 保存到SD卡
    private static String sdState = Environment.getExternalStorageState();
    private static String path = Environment.getExternalStorageDirectory().toString();

    public static void saveBitmap(Bitmap bitmap, String imageName) {
        File file;
        File PicName;
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            // 获得sd卡根目录
            file = new File(path + "/Huai/TicketsPic");
            if (!file.exists()) {
                file.mkdirs();
            }
            PicName = new File(file, imageName);
            try {
                if (!PicName.exists()) {
                    PicName.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(PicName);
                if (PicName.getName().endsWith(".png")) {
                    bitmap.compress(CompressFormat.PNG, 100, fos);
                } else if (PicName.getName().endsWith(".jpg")) {
                    bitmap.compress(CompressFormat.JPEG, 100, fos);
                }
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 从SD卡取
    public static Bitmap getBitmap(String imageName) {
        Bitmap bitmap = null;
        File imagePic;
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {

            imagePic = new File(path + "/Huai/TicketsPic", imageName);
            if (imagePic.exists()) {
                try {
                    bitmap = BitmapFactory.decodeStream(new FileInputStream(imagePic));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    // 将SD卡文件删除
    public static void deleteFile(File file) {
        if (sdState.equals(Environment.MEDIA_MOUNTED)) {
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                }
                // 如果它是一个目录
                else if (file.isDirectory()) {
                    // 声明目录下所有的文件 files[];
                    File files[] = file.listFiles();
                    for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                        deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                    }
                }
                file.delete();
            }
        }
    }

    /* ========================== */
    private static long lastClickTime;

    /**
     * 检测按钮短时间内是否重复点击
     *
     * @return
     */
    public synchronized static boolean isButtonFastClickAtALittleTime() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

	/* ========================== */
    /**
     * 隐藏系统自带输入法
     *
     * @param editText
     */
    // public static void hiddenSoftInputForEditText(EditText editText)
    // {
    // // 方法一 无光标
    // // editText.setInputType(InputType.TYPE_NULL);
    // // 方法二 有光标
    // setShowSoftInputOnClick(editText);
    // setShowSoftInputOnFocus(editText);
    // setShowSoftInputOnTouch(editText);
    // setShowSoftInputOnLongClick(editText);
    // }

    /**
     * 隐藏系统输入框
     *
     * @param editText
     */
    protected static void setShowSoftInputOnFocus(EditText editText) {
        try {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnFocus;
            setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
            setShowSoftInputOnFocus.setAccessible(true);
            setShowSoftInputOnFocus.invoke(editText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏系统输入框
     *
     * @param editText
     */
    protected static void setShowSoftInputOnTouch(EditText editText) {
        try {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnTouch;
            setShowSoftInputOnTouch = cls.getMethod("setShowSoftInputOnTouch", boolean.class);
            setShowSoftInputOnTouch.setAccessible(true);
            setShowSoftInputOnTouch.invoke(editText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏系统输入框
     *
     * @param editText
     */
    protected static void setShowSoftInputOnLongClick(EditText editText) {
        try {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnTouch;
            setShowSoftInputOnTouch = cls.getMethod("setShowSoftInputOnLongClick", boolean.class);
            setShowSoftInputOnTouch.setAccessible(true);
            setShowSoftInputOnTouch.invoke(editText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏系统输入框
     *
     * @param editText
     */
    protected static void setShowSoftInputOnClick(EditText editText) {
        try {
            Class<EditText> cls = EditText.class;
            Method setShowSoftInputOnTouch;
            setShowSoftInputOnTouch = cls.getMethod("setShowSoftInputOnClick", boolean.class);
            setShowSoftInputOnTouch.setAccessible(true);
            setShowSoftInputOnTouch.invoke(editText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 格式化数据
     *
     * @param formater
     * @return
     */
    public static String formatDouble2String(Double formater) {
        try {
            NumberFormat nbf = NumberFormat.getInstance();
            nbf.setMinimumFractionDigits(2);
            return nbf.format(formater);
        } catch (Exception e) {
            // TODO: handle exception
            return "-";
        }
    }

    /**
     * 格式化数据
     *
     * @param formater
     * @return
     */
    public static Double formatString2Double(String formater) {
        try {
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            dfs.setGroupingSeparator(',');
            dfs.setMonetaryDecimalSeparator('.');
            DecimalFormat df = new DecimalFormat("###,###.##", dfs);
            Number num = df.parse(formater);
            return num.doubleValue();
        } catch (Exception e) {
            // TODO: handle exception
            return 0.0;
        }
    }

    /**
     * 指定的字符串的长度在min与max之间
     *
     * @param string
     * @param min
     * @param max
     * @return
     */
    public static boolean isLengthbetween(String string, int min, int max) {
        if (string == null) {
            return false;
        }

        int length = string.length();

        if (length >= min && length <= max) {
            return true;
        }

        return false;
    }

    /**
     * 指定的字符串是否由ascii字母和数字组成
     *
     * @param string
     * @return
     */
    public static boolean isASCIILetterAndDigit(String string) {
        if (string == null) {
            return false;
        }

        boolean letter = false;
        boolean digit = false;

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                letter = true;
            }

            if ((ch >= '0' && ch <= '9')) {
                digit = true;
            }

            if (letter && digit) {
                return true;
            }
        }

        return false;
    }

    /**
     * 返回一个字符在指定字符串中的个数
     *
     * @param c
     * @param s
     * @return
     */
    public static int numOfSequenceAtString(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * 返回一个UUID 作为token
     *
     * @return
     */
    public static String getUuidAsAToken() {
        return UUID.randomUUID().toString();
    }

    // ////////////////////////////////////小数点处理sintn.com//////////////////////

    /**
     * 保留小数点后n位小数，
     *
     * @param number 需要格式的数字
     * @param length 保留小数点后的位数
     * @param model  零头处理方式，0或1进行四舍五入，2向下舍，3向上得
     * @author zk
     */
    public static double getTwoAfterPoint(double number, int length, int model) {
        BigDecimal bd = new BigDecimal(number);
        switch (model) {
            case 0:
            case 1:// 1（四舍五入）
            {
                bd = bd.setScale(length, BigDecimal.ROUND_HALF_UP);
                break;
            }
            case 2:// 2（抹零）
            {
                bd = bd.setScale(length, BigDecimal.ROUND_DOWN);
                break;
            }
            case 3:// 3（
            {
                bd = bd.setScale(length, BigDecimal.ROUND_UP);
                break;
            }
        }
        return bd.doubleValue();
    }

    /**
     * 判断网络是否畅通
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni != null && ni.isConnected()) {
            return true;
        }
        return false;
    }

    /**
     * 取消dialog显示
     *
     * @param pd
     */
    public static void dismissProgressDialog(ProgressDialog pd) {
        try {
            if (pd != null) {
                pd.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return String
     * @throws
     * @Title:reserveTwoDecimal
     * @Description:双精度类型整数转换为缺省格式字符串
     */
    public static String reserveTwoDecimal(Double d) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(d.doubleValue()).toString();
    }

    /**
     * 按照格式转换时间类对象为字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        try {
            if (date == null) {
                return "";
            }
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return formatter.format(date);
        } catch (Exception e) {
            // TODO: handle exception
            return "";
        }

    }

    /**
     * 按照格式转换字符串为时间类对象
     *
     * @param string
     * @param pattern
     * @return
     */
    public static Date stringToDate(String string, String pattern) {
        if (!TextUtils.isEmpty(string)) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(pattern);
                formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                return formatter.parse(string);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 得到类名
     *
     * @param c
     * @return
     */
    public static String getClassName(Class<?> c) {
        return c.getName().substring(c.getName().lastIndexOf(".") + 1, c.getName().length());
    }

    public static String concatPinyinStringArray(String[] pinyinArray) {
        StringBuffer pinyinSbf = new StringBuffer();

        if ((pinyinArray != null) && (pinyinArray.length > 0)) {
            for (String string : pinyinArray) {
                pinyinSbf.append(string);
            }
        }
        return pinyinSbf.toString();
    }

    /**
     * 深度复制
     *
     * @param src 资源
     * @return 返回的对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    /**
     * 通过PackageManager获取版本
     *
     * @return String
     */
    public static String getVersion(Application application) {
        try {
            PackageManager manager = application.getPackageManager();
            PackageInfo info = manager.getPackageInfo(application.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取一个月的第一天
     *
     * @return Date
     */
    public static Date getFirstDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获取一个月的最后一天
     *
     * @return Date
     */
    public static Date getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取一个季度的第一天
     *
     * @return Date
     */
    public static Date getFirstDayOfQuarter() {
        Calendar calendar = Calendar.getInstance();
        int curMonth = calendar.get(Calendar.MONTH);
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
            calendar.set(Calendar.MONTH, Calendar.JANUARY);
        }
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
            calendar.set(Calendar.MONTH, Calendar.APRIL);
        }
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {
            calendar.set(Calendar.MONTH, Calendar.JULY);
        }
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.OCTOBER);
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取一个季度的最后一天
     *
     * @return Date
     */
    public static Date getLastDayOfQuarter() {
        Calendar calendar = Calendar.getInstance();
        int curMonth = calendar.get(Calendar.MONTH);
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH) {
            calendar.set(Calendar.MONTH, Calendar.MARCH);
        }
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE) {
            calendar.set(Calendar.MONTH, Calendar.JUNE);
        }
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.AUGUST) {
            calendar.set(Calendar.MONTH, Calendar.AUGUST);
        }
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * 获取一年的第一天
     *
     * @return Date
     */
    public static Date getFirstDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }

    /**
     * 获取一年的最后一天
     *
     * @return Date
     */
    public static Date getLastDayOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }

    /**
     * 获取一个数（i）相对于另一个数（total）
     *
     * @param i
     * @param total
     * @return
     */
    public static String getPercentage(Integer i, Integer total) {
        if (i == 0) {
            return "0%/";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        return numberFormat.format((float) i / (float) total * 100) + "%/";
    }

    /**
     * 获取随机唯一标识码
     *
     * @return String
     */
    public static String getRandomString() {
        final int length = 10;
        // UUID uuid = UUID.randomUUID();
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
        // return uuid.toString();
    }

    /**
     * 获取随机唯一标识码
     * GUID是一个128位长的数字，一般用16进制表示。算法的核心思想是结合机器的网卡、当地时间、一个随机数来生成GUID。从理论上讲
     * ，如果一台机器每秒产生10000000个GUID，则可以保证（概率意义上）3240年不重复。
     * UUID是1.5中新增的一个类，在java.util下，用它可以产生一个号称全球唯一的ID。
     *
     * @return String
     */
    public static String getUUIDRandomString() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 判断版本是否被支持
     *
     * @param versionCode
     * @param supportFrom
     * @return
     */
    public static boolean versionUnSupport(String versionCode, String supportFrom) {
        if (supportFrom == null || supportFrom.equals("")) {
            return false;
        }
        String[] versionCodes = versionCode.split("\\.");
        String[] supportFroms = supportFrom.split("\\.");
        for (int i = 0; i < supportFroms.length; i++) {
            if (Integer.valueOf(versionCodes[i]) > Integer.valueOf(supportFroms[i])) {
                return false;
            } else if ((int) Integer.valueOf(versionCodes[i]) == (int) Integer.valueOf(supportFroms[i])) {
                if (i == supportFroms.length - 1) {
                    return false;
                } else {
                    continue;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 安装应用程序
     *
     * @param context
     */
    public static void install(Context context) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory(), CommonUtils.APPUPDATECACHENAME)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 判断指定Activity是否已经至少有一个实例被加载了
     *
     * @param context
     * @param clazz
     * @return
     */
    public static <T> boolean isActivityAreRunningBefore(Context context, Class<T> clazz) {
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        // 获得当前正在运行的activity
        List<ActivityManager.RunningTaskInfo> appLists = mActivityManager.getRunningTasks(1000);
        for (ActivityManager.RunningTaskInfo running : appLists) {
            if (clazz.getClass().getName().equals(running.baseActivity.getClassName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置按钮休眠一段时间
     *
     * @param button
     */
    public static void dormantForClick(final Button button, long time) {
        button.setClickable(false);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                button.setClickable(true);
            }
        }, time);
    }

}
