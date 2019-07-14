package com.design.patterns.behavior.command.simple1;

import android.util.Log;

/**
 * 调用者
 */
public class Invoker {

    private static final String TAG = Invoker.class.getSimpleName();

    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    public void action(){
        Log.i(TAG, "下发具体命令");
        this.command.execute();
    }

}
