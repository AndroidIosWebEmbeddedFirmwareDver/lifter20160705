package com.wxl.export.lifter.common.utils.common;

import java.util.Hashtable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * @com.wxl.export.lifter.common.utils.common
 * @HuiyuantongVenusShopCash-V3.x
 * @QRImageUtils.java
 * @Author:Wxl@Sintn.Inc
 * @Desc: 生成二维码图片
 * @2015-5-7下午5:42:15
 */
public class QRImageUtils {
    private static int QR_WIDTH = 500, QR_HEIGHT = 500;
    private static final int IMAGE_HALFWIDTH = 40;//宽度值，影响中间图片大小

    public static int getQR_WIDTH() {
        return QR_WIDTH;
    }

    public static int getQR_HEIGHT() {
        return QR_HEIGHT;
    }

    public static int getQrWidth() {
        return QR_WIDTH;
    }

    public static void setQrWidth(int qrWidth) {
        QR_WIDTH = qrWidth;
    }

    public static int getQrHeight() {
        return QR_HEIGHT;
    }

    public static void setQrHeight(int qrHeight) {
        QR_HEIGHT = qrHeight;
    }

    private static void initParams(Context context) {
        int screenWith = DensityManagerUtils.getScreenWithPx(context) / 3 * 2;
        if (screenWith > getQR_WIDTH()) {
            setQrHeight(screenWith);
            setQrWidth(screenWith);
        } else {
            setQrHeight(500);
            setQrWidth(500);
        }
    }

    /**
     * 生成二维码图片
     *
     * @param url 要转换的地址或字符串,可以是中文
     * @return
     */
    public static Bitmap createQRImage(Context context,String url) {
        initParams(context);
        try {
            // 判断URL合法性
            if (url == null || "".equals(url) || url.length() < 1) {
                return null;
            }
            Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            // 图像数据转换，使用了矩阵转换
            BitMatrix bitMatrix = new QRCodeWriter().encode(url, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT, hints);
            int[] pixels = new int[QR_WIDTH * QR_HEIGHT];
            // 下面这里按照二维码的算法，逐个生成二维码的图片，
            // 两个for循环是图片横列扫描的结果
            for (int y = 0; y < QR_HEIGHT; y++) {
                for (int x = 0; x < QR_WIDTH; x++) {
                    if (bitMatrix.get(x, y)) {
                        pixels[y * QR_WIDTH + x] = 0xff000000;
                    } else {
                        pixels[y * QR_WIDTH + x] = 0xffffffff;
                    }
                }
            }
            // 生成二维码图片的格式，使用ARGB_8888
            Bitmap bitmap = Bitmap.createBitmap(QR_WIDTH, QR_HEIGHT, Bitmap.Config.ARGB_8888);
            bitmap.setPixels(pixels, 0, QR_WIDTH, 0, 0, QR_WIDTH, QR_HEIGHT);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 生成二维码
     *
     * @param string  二维码中包含的文本信息
     * @param context 上下文信息
     * @param src     logo图片
     * @return Bitmap 位图
     */
    public static Bitmap createCode(String string, Context context, int src) {
        initParams(context);
        //获得资源图片，可改成获取本地图片或拍照获取图片
        Bitmap mBitmap = BitmapFactory.decodeResource(context.getResources(), src);
        BarcodeFormat format = BarcodeFormat.QR_CODE;
        Matrix m = new Matrix();
        float sx = (float) 2 * IMAGE_HALFWIDTH / mBitmap.getWidth();
        float sy = (float) 2 * IMAGE_HALFWIDTH
                / mBitmap.getHeight();
        m.setScale(sx, sy);//设置缩放信息
        //将logo图片按martix设置的信息缩放
        mBitmap = Bitmap.createBitmap(mBitmap, 0, 0,
                mBitmap.getWidth(), mBitmap.getHeight(), m, false);
        MultiFormatWriter writer = new MultiFormatWriter();
        Hashtable hst = new Hashtable();
        hst.put(EncodeHintType.CHARACTER_SET, "UTF-8");//设置字符编码
        BitMatrix matrix = null;//生成二维码矩阵信息
        try {
            matrix = writer.encode(string, format, QR_WIDTH, QR_HEIGHT, hst);
            int width = matrix.getWidth();//矩阵高度
            int height = matrix.getHeight();//矩阵宽度
            int halfW = width / 2;
            int halfH = height / 2;
            int[] pixels = new int[width * height];//定义数组长度为矩阵高度*矩阵宽度，用于记录矩阵中像素信息
            for (int y = 0; y < height; y++) {//从行开始迭代矩阵
                for (int x = 0; x < width; x++) {//迭代列
                    if (x > halfW - IMAGE_HALFWIDTH && x < halfW + IMAGE_HALFWIDTH
                            && y > halfH - IMAGE_HALFWIDTH
                            && y < halfH + IMAGE_HALFWIDTH) {//该位置用于存放图片信息
                        //记录图片每个像素信息
                        pixels[y * width + x] = mBitmap.getPixel(x - halfW
                                + IMAGE_HALFWIDTH, y - halfH + IMAGE_HALFWIDTH);
                    } else {
                        if (matrix.get(x, y)) {//如果有黑块点，记录信息
                            pixels[y * width + x] = 0xff000000;//记录黑块信息
                        }
                    }
                }
            }
            Bitmap bitmap = Bitmap.createBitmap(width, height,
                    Bitmap.Config.ARGB_8888);
            // 通过像素数组生成bitmap
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}