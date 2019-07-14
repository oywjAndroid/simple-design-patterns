package com.design.patterns.behavior.command.simple2;

import android.util.Log;

public class TetrisTransfer implements Transfer {

    private static final String TAG = TetrisTransfer.class.getSimpleName();

    @Override
    public void moveUp() {
        Log.i(TAG,"方块向上移动");
    }

    @Override
    public void moveDown() {
        Log.i(TAG,"方块向下移动");
    }

    @Override
    public void moveLeft() {
        Log.i(TAG,"方块向左移动");
    }

    @Override
    public void moveRight() {
        Log.i(TAG,"方块向右移动");
    }
}
