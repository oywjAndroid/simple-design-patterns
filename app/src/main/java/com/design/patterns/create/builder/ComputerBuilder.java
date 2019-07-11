package com.design.patterns.create.builder;

/**
 * (2)
 * 定义建造者，明确建造信息（建造信息与产品所需信息一致）
 */
public interface ComputerBuilder {

    void buildCpu(int core);

    void buildRam(int gb);

    void buildOs(String os);
}
