package com.design.patterns.behavior.command.simple1;

import android.util.Log;

/**
 * 具体命令实现类
 */
public class ConcreteCommand implements Command {

    private static final String TAG = ConcreteCommand.class.getSimpleName();

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        Log.i(TAG,"收到命令");
        receiver.action();
    }
}
