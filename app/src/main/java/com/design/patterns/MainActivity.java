package com.design.patterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.design.patterns.create.builder.BuilderDemo;
import com.design.patterns.create.singleton.SingletonDemo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.单例模式
        PatternRunner.getInstance().execPattern(new SingletonDemo());

        // 2.Builder模式
        PatternRunner.getInstance().execPattern(new BuilderDemo());
    }
}
