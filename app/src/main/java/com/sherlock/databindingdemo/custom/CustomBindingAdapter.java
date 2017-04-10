package com.sherlock.databindingdemo.custom;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Description:
 * author         xulei
 * Date           2017/4/5
 */

public class CustomBindingAdapter {
    //不能加app，加上会报错找不到setter
//    @BindingAdapter({"app:imageUrl", "app:placeholder"})
    @BindingAdapter({"imageUrl", "placeholder"})
    public static void setImageUrl(ImageView view, String url, Drawable drawable) {
        Picasso.with(view.getContext()).load(url).placeholder(drawable).into(view);
        Log.e("imageUrl", url);
    }
}
