package com.wxl.export.lifter.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wxl.export.lifter.lifter.R;

/**
 * ImageView创建工厂
 */
public class ViewFactory {

    /**
     * 获取ImageView视图的同时加载显示url
     *
     * @param context
     * @param url
     * @return
     */
    public static ImageView getImageView(Context context, String url) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(
                R.layout.acticity_main_banner_view, null);
//		ImageLoader.getInstance().displayImage(url, imageView);
        Glide.with(context).load(url).into(imageView);
        return imageView;
    }
}
