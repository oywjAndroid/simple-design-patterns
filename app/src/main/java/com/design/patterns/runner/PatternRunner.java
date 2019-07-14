package com.design.patterns.runner;

import com.design.patterns.base.TestUnit;

/**
 * 设计模式Demo运行器
 */
public class PatternRunner {

    private PatternRunner() {

    }

    private static final class Holder {
        private static final PatternRunner instance = new PatternRunner();
    }

    public static PatternRunner getInstance() {
        return Holder.instance;
    }

    public void execPattern(TestUnit unit) {
        if (null == unit) {
            throw new IllegalArgumentException("unit not's null.");
        }
        unit.main();
    }
}
