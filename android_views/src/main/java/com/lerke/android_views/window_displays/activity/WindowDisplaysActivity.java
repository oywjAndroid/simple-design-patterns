package com.lerke.android_views.window_displays.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lerke.android_views.R;
import com.lerke.android_views.window_displays.DisplayUtils;

/**
 * @author allen
 * @description:
 * @date :2020-02-18 16:13
 */
public class WindowDisplaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_window_display);
        System.out.println("density:" + DisplayUtils.getDensity());
        System.out.println("densityDpi:" + DisplayUtils.getDensityDpi());
    }
}
