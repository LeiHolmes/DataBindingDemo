package com.sherlock.databindingdemo.custom;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Description:
 * author         xulei
 * Date           2017/4/5
 */

public class CustomBindingAdapter {
    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    public static void loadImgUrl(ImageView view, String url, Drawable drawable) {
        Glide.with(view.getContext()).load(url).placeholder(drawable).into(view);
    }
}
