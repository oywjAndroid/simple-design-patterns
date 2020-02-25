package com.lerke.android_views.text_draw.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lerke.android_views.R;
import com.lerke.android_views.text_draw.SportRecordView;

/**
 * @author allen
 * @description:
 * @date :2020-02-12 09:46
 */
public class DemoActivity extends AppCompatActivity {

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_demo);
//        final SportRecordView sportRecordView = findViewById(R.id.sport_record_view);
//
//        for (int i = 0; i <= 100; i++) {
//            final int progress = i;
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    sportRecordView.setProgress(progress);
//                }
//            }, i * 100);
//        }
    }
}
