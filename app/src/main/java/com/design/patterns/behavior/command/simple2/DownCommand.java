package com.design.patterns.behavior.command.simple2;

/**
 * 下行命令
 */
public class DownCommand extends TransferCommand {

    public DownCommand(Transfer transfer) {
        super(transfer);
    }

    @Override
    public void execute() {
        mTransfer.moveDown();
    }
}
