package com.lerke.android_views.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.tabs.TabLayout;
import com.lerke.android_views.Utils;
import com.lerke.android_views.custom_view.drawable.BottomNavigationBgDrawable;

/**
 * @author allen
 * @description:
 * @date :2020-02-17 19:38
 */
public class MyTabLayout extends TabLayout {
    BottomNavigationBgDrawable drawable = new BottomNavigationBgDrawable();
    private int color;

    public MyTabLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        color = ContextCompat.getColor(context, android.R.color.holo_orange_light);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            drawable.setBounds(0, 0, w, h);
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        drawable.setPadding(Utils.dp2px(10), Utils.dp2px(30), Utils.dp2px(10), 0);
        drawable.setRadius(10);
        drawable.setColor(color);
        drawable.draw(canvas);
    }

}
