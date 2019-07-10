package com.design.patterns.create.singleton;

import android.util.Log;

/**
 * CEO 单例模式实现
 */
public class CEO implements Person {
    private static final String TAG = CEO.class.getSimpleName();

    private CEO() {

    }

    public static CEO getInstance() {
        return Holder.instance;
    }

    @Override
    public void talk() {
        Log.i(TAG, "CEO：" + toString() + ",发表演讲");
    }

    private static final class Holder {
        private static final CEO instance = new CEO();
    }
}
