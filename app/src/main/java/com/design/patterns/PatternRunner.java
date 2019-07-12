package com.design.patterns;

import com.design.patterns.base.PatternTestUnit;

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

    public void execPattern(PatternTestUnit unit) {
        if (null == unit) {
            throw new IllegalArgumentException("unit not's null.");
        }
        unit.main();
    }
}
