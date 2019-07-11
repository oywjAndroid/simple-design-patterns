package com.design.patterns.create.builder;

public class AppleComputerBuilder implements ComputerBuilder {
    private int core;
    private int gb;
    private String os;

    @Override
    public void buildCpu(int core) {
        this.core = core;
    }

    @Override
    public void buildRam(int gb) {
        this.gb = gb;
    }

    @Override
    public void buildOs(String os) {
        this.os = os;
    }

    public AppleComputer build() {
        AppleComputer appleComputer = new AppleComputer();
        appleComputer.setCpu(this.core);
        appleComputer.setRam(this.gb);
        appleComputer.setOs(this.os);
        return appleComputer;
    }
}
