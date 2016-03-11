package com.wxl.export.lifter.enty.constenty;

import com.wxl.export.lifter.common.utils.common.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sintn on 16/3/11.
 */
public class RedoamLuncherImageUrlConst {
    public static List<String> resource;

    static {
        init();
    }

    public static void init() {
        resource = new ArrayList<>();
        resource.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1305/29/c0/21415233_1369808105811.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/093/10369093.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/366/855/10366855.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/098/10369098.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/374/076/10374076.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/370/287/10370287.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/421/10369421.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/373/840/10373840.jpg");
        resource.add("http://p18.qhimg.com/t01eecaf4e9200f782e.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/374/333/10374333.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/123/10369123.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/373/975/10373975.jpg");
        resource.add("http://p16.qhimg.com/t013065ed8a8a9148be.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/368/814/10368814.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/368/992/10368992.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/366/883/10366883.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/368/982/10368982.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/365/937/10365937.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/368/837/10368837.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/311/10369311.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/085/10369085.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/366/948/10366948.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/368/190/10368190.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/314/10369314.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/367/911/10367911.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/366/182/10366182.jpg");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/366/137/10366137.jpg");
        resource.add("http://attach.bbs.miui.com/forum/201411/16/121257cfrtzt8srj8f77cv.png");
        resource.add("http://mg.soupingguo.com/bizhi/big/10/369/143/10369143.jpg");
    }

    public static String redomeImageUrl() {
        Random random = new Random();
        return resource.get(random.nextInt(resource.size()));
    }
}
