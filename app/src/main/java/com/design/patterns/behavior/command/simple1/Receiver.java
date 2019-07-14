package com.design.patterns.behavior.command.simple1;

import android.util.Log;

/**
 * 接收者
 */
public class Receiver {

    private static final String TAG = Receiver.class.getSimpleName();

    public void action(){
        Log.i(TAG,"执行具体动作");
    }

}
