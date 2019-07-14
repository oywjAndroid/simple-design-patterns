package com.design.patterns.behavior.command.simple2;


/**
 * 俄罗斯方块命令接口
 */
public abstract class TransferCommand {

    protected Transfer mTransfer;

    public TransferCommand(Transfer transfer){
        this.mTransfer = transfer;
    }

    public abstract void execute();

}
