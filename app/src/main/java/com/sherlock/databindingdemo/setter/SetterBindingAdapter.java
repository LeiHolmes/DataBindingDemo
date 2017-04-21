package com.sherlock.databindingdemo.setter;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.databinding.InverseBindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Description:
 * author         xulei
 * Date           2017/4/5
 */

public class SetterBindingAdapter {

//    @BindingMethods({@BindingMethod(
//            type = "android.widget.ImageView", 
//            attribute = "android:tint",
//            method = "setImageTintList")
//    })

    /**
     * ImageView绑定图片url
     */
    @BindingAdapter({"imageUrl", "placeholder"})
    public static void setImageUrl(ImageView view, String url, Drawable drawable) {
        Picasso.with(view.getContext()).load(url).placeholder(drawable).into(view);
        Log.e("imageUrl", url);
        //@BindingAdapter({"app:imageUrl", "app:placeholder"})
        //不能加app，加上会报错找不到setter
    }

    /**
     * color转Drawable
     */
    @BindingConversion
    public static ColorDrawable transformColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    @InverseBindingAdapter(attribute = "android:text") 
    public static String getTextString(TextView view) {
        return view.getText().toString();
    }
}
