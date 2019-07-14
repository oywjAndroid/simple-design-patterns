package com.design.patterns.behavior.command.simple2;

/**
 * 左移命令
 */
public class LeftCommand extends TransferCommand {

    public LeftCommand(Transfer transfer) {
        super(transfer);
    }

    @Override
    public void execute() {
        mTransfer.moveLeft();
    }
}
