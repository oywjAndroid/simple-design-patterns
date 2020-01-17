package com.lerke.android_views;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.lerke.android_views.image_display.ScaleTypeImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScaleTypeImageView imageView_01 = findViewById(R.id.image_01);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.goose_300x200);
        imageView_01.setImageDrawable(drawable);

    }
}
