package com.bawei.util;

import android.widget.ImageView;

import com.bawei.app.AppContext;
import com.bawei.week03.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:王楚
 *@Date: 2019/11/18
 *@Time:9:04
 *@Description:${DESCRIPTION}
 **/
public class GlideUtil {
    public static void loadImage(String url, ImageView imageView){
        Glide.with(AppContext.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(5)))
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
