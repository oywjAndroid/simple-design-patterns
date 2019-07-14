package com.design.patterns.behavior.command;

import android.content.Context;
import android.content.Intent;

import com.design.patterns.base.TestUnit;
import com.design.patterns.behavior.command.simple2.TetrisActivity;

/**
 * CommandSimple2 主要通过一个简单的实例来加深对命令模式的理解。
 * 《俄罗斯方块》中通过上、下、左、右来控制方块的移动。
 */
public class CommandSimple2Demo extends TestUnit {

    private Context mContext;

    public void attachContext(Context context) {
        this.mContext = context;
    }

    @Override
    public void main() {
        Intent intent = new Intent();
        intent.setClassName(mContext.getPackageName(), TetrisActivity.class.getName());
        mContext.startActivity(intent);
    }
}
