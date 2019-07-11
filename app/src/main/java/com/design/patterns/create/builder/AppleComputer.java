package com.design.patterns.create.builder;

import android.util.Log;

public class AppleComputer implements Computer {

    private static final String TAG = AppleComputer.class.getSimpleName();
    private int core;
    private int gb;
    private String os;

    @Override
    public void setCpu(int core) {
        this.core = core;
    }

    @Override
    public void setRam(int gb) {
        this.gb = gb;
    }

    @Override
    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public void boot() {
        Log.i(TAG, "apple boot...");
        Log.i(TAG, "apple cpu core:" + core);
        Log.i(TAG, "apple ram gb:" + gb);
        Log.i(TAG, "apple os:" + os);
    }

}
