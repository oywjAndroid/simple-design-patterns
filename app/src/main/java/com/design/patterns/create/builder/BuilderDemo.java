package com.design.patterns.create.builder;

import com.design.patterns.base.TestUnit;

public class BuilderDemo extends TestUnit {

    @Override
    public void main() {
        AppleComputerBuilder builder = new AppleComputerBuilder();
        builder.buildCpu(12);
        builder.buildRam(8);
        builder.buildOs("MacOS10.4.12");
        AppleComputer computer = builder.build();
        computer.boot();
    }
}
