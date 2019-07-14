package com.design.patterns.behavior.command;

import com.design.patterns.base.TestUnit;
import com.design.patterns.behavior.command.simple1.ConcreteCommand;
import com.design.patterns.behavior.command.simple1.Invoker;
import com.design.patterns.behavior.command.simple1.Receiver;

/**
 * CommandSimple1 是命令模式最简单的示例，能够与其UML类图有很好的对应关系，方便理解命令模式。
 */
public class CommandSimple1Demo extends TestUnit {

    @Override
    public void main() {
        // 1. 创建接收者（电视机）
        Receiver receiver = new Receiver();
        // 2. 创建命令处理器（遥控器）
        ConcreteCommand command = new ConcreteCommand(receiver);
        // 3. 创建调用者（人）
        Invoker invoker = new Invoker(command);
        // 4. 人 --> 遥控器 --> 电视机
        invoker.action();
    }
}
