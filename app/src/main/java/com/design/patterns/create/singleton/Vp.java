package com.design.patterns.create.singleton;

import android.util.Log;

public class Vp implements Person {
    private static final String TAG = Vp.class.getSimpleName();

    @Override
    public void talk() {
        Log.i(TAG,"副总裁："+toString()+",发表讲话");
    }
}
