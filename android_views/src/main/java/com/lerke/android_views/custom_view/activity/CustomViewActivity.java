package com.lerke.android_views.custom_view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.lerke.android_views.R;

/**
 * @author allen
 * @description:
 * @date :2020-02-17 17:43
 */
public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ViewPager viewPager = findViewById(R.id.viewPager);

    }
}
