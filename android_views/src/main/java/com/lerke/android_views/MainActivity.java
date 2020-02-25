package com.lerke.android_views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.lerke.android_views.image_display.fragment.GlideSimpleFragment;
import com.lerke.android_views.image_display.fragment.ScaleTypeSimpleFragment;

public class MainActivity extends AppCompatActivity {

    GlideSimpleFragment glideFragment;
    ScaleTypeSimpleFragment scaleTypeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        glideFragment = new GlideSimpleFragment();
        scaleTypeFragment = new ScaleTypeSimpleFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, glideFragment, GlideSimpleFragment.class.getSimpleName());
//        transaction.add(R.id.fragment_container, scaleTypeFragment, ScaleTypeSimpleFragment.class.getSimpleName());
        transaction.show(glideFragment);
//        transaction.hide(scaleTypeFragment);
        transaction.commit();
    }


}
