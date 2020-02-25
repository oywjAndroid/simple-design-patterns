package com.mvvm.databinding.bindAdapter.image;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

/**
 * @author allen
 * @description:
 * @date :2020-02-23 14:51
 */
public class ViewBindingAdapter {

    @BindingAdapter("imageUrl")
    public static void bindImageUrl(ImageView imageView, String url) {
        Glide.with(imageView).load(url).into(imageView);
    }

    @BindingAdapter(value = {"imageUrl", "errorDrawableId"}, requireAll = true)
    public static void bindImageUrl(ImageView imageView, String url, int errorDrawableId) {
        Glide.with(imageView).load(url).error(errorDrawableId).into(imageView);
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int oldPadding, int newPadding) {
        System.out.println("oldPadding:" + oldPadding + ",newPadding:" + newPadding);

        if (oldPadding != newPadding) {
            view.setPadding(newPadding,
                    view.getPaddingTop(),
                    view.getPaddingRight(),
                    view.getPaddingBottom());
        }
    }

}
