package com.design.patterns.create.singleton;

import android.util.Log;

public class Staff implements Person {

    private static final String TAG = Staff.class.getSimpleName();

    @Override
    public void talk() {
        Log.i(TAG,"普通员工:"+toString()+",发表意见");
    }
}
