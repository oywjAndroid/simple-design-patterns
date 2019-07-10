package com.design.patterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.design.patterns.create.singleton.SingletonDemo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SingletonDemo singletonDemo = new SingletonDemo();
        singletonDemo.main();

    }
}
