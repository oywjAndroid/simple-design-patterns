package com.design.patterns.behavior.command.simple2;

/**
 * 右移命令
 */
public class RightCommand extends TransferCommand {

    public RightCommand(Transfer transfer) {
        super(transfer);
    }

    @Override
    public void execute() {
        mTransfer.moveRight();
    }
}
