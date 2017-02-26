package com.mobcent.common;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.litesuits.android.log.Log;
import com.mobcent.discuz.application.DiscuzApplication;

/**
 * Created by sun on 2016/8/20.
 *  图片加载
 */
public class ImageLoader {
    public static final boolean DEBUG = false;
    // 示例
    public static void load(final String url, ImageView target) {
        if (DEBUG) {
            Glide.with(DiscuzApplication._instance).load(url).listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    Log.d("Glide","load:" + url + " errro" + e);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    Log.d("Glide","load:" + url + " Ok!");
                    return false;
                }
            })
                    .into(target);
        } else {
            Glide.with(DiscuzApplication._instance).load(url).into(target);
        }
    }

    /**
     * 圆角图片
     * @param url
     * @param target
     * @param radius  dp value
     */
    public static void load(String url, ImageView target, int radius) {
        Glide.with(DiscuzApplication._instance)
                .load(url)
                .centerCrop()
                .transform(new CenterCrop(DiscuzApplication._instance), new GlideRoundTransform(DiscuzApplication._instance, radius))
                .into(target);

    }
}
