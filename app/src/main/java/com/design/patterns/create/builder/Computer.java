package com.design.patterns.create.builder;

/**
 * (1)
 * 定义产品接口(明确产品类需要配置的信息)
 */
public interface Computer {

    void setCpu(int core);

    void setRam(int gb);

    void setOs(String os);

    void boot();
}
