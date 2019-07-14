package com.design.patterns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.design.patterns.base.TestUnit;
import com.design.patterns.behavior.command.CommandSimple1Demo;
import com.design.patterns.behavior.command.CommandSimple2Demo;
import com.design.patterns.create.builder.BuilderDemo;
import com.design.patterns.create.singleton.SingletonDemo;
import com.design.patterns.runner.PatternRunner;

public class MainActivity extends AppCompatActivity {

    private static String[] sPatternData;
    private static TestUnit[] sTestUnits;

    private ListView mPatternListView;

    static {
        sPatternData = new String[]{"单例模式--Singleton", "建造者模式--Builder", "命令模式--Command Simple1", "命令模式--Command Simple2"};
        sTestUnits = new TestUnit[]{new SingletonDemo(), new BuilderDemo(), new CommandSimple1Demo(), new CommandSimple2Demo()};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setData();
        initListener();
    }

    private void initView() {
        mPatternListView = findViewById(R.id.listView);
    }

    private void setData() {
        ArrayAdapter<String> adapter
                = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, sPatternData);
        mPatternListView.setAdapter(adapter);
    }

    private void initListener() {
        mPatternListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TestUnit testUnit = sTestUnits[position];
                if (testUnit instanceof CommandSimple2Demo) {
                    ((CommandSimple2Demo) testUnit).attachContext(MainActivity.this);
                }
                PatternRunner.getInstance().execPattern(testUnit);
            }
        });
    }

}
