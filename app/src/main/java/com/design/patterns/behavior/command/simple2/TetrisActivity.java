package com.design.patterns.behavior.command.simple2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.design.patterns.R;

/**
 * 俄罗斯方块
 */
public class TetrisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tetris);

    }
}
