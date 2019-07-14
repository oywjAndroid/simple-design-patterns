package com.design.patterns.behavior.command.simple2;

/**
 * 向上移动命令
 */
public class UpCommand extends TransferCommand {

    public UpCommand(Transfer transfer) {
        super(transfer);
    }

    @Override
    public void execute() {
        mTransfer.moveUp();
    }
}
