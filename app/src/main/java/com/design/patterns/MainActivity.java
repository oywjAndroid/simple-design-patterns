package com.design.patterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.design.patterns.behavior.command.CommandSimple1Demo;
import com.design.patterns.create.builder.BuilderDemo;
import com.design.patterns.create.singleton.SingletonDemo;
import com.design.patterns.runner.PatternRunner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1.单例模式
        PatternRunner.getInstance().execPattern(new SingletonDemo());

        // 2.Builder模式
        PatternRunner.getInstance().execPattern(new BuilderDemo());

        // 3.命令模式
        PatternRunner.getInstance().execPattern(new CommandSimple1Demo());
    }
}
