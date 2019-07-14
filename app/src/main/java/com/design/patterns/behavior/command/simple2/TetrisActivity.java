package com.design.patterns.behavior.command.simple2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.design.patterns.R;

/**
 * 俄罗斯方块:命令调用者
 */
public class TetrisActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mUpBtn;
    private Button mDownBtn;
    private Button mLeftBtn;
    private Button mRightBtn;

    private UpCommand upCommand;
    private DownCommand downCommand;
    private LeftCommand leftCommand;
    private RightCommand rightCommand;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris);
        initView();
        initListener();
        initCommand();
    }

    private void initView() {
        mUpBtn = findViewById(R.id.up_btn);
        mDownBtn = findViewById(R.id.down_btn);
        mLeftBtn = findViewById(R.id.left_btn);
        mRightBtn = findViewById(R.id.right_btn);
    }

    private void initListener() {
        mUpBtn.setOnClickListener(this);
        mDownBtn.setOnClickListener(this);
        mLeftBtn.setOnClickListener(this);
        mRightBtn.setOnClickListener(this);
    }

    private void initCommand() {
        TetrisTransfer transfer = new TetrisTransfer();
        upCommand = new UpCommand(transfer);
        downCommand = new DownCommand(transfer);
        leftCommand = new LeftCommand(transfer);
        rightCommand = new RightCommand(transfer);
    }

    @Override
    public void onClick(View v) {
        if (v == mUpBtn) {
            upCommand.execute();
        } else if (v == mDownBtn) {
            downCommand.execute();
        } else if (v == mLeftBtn) {
            leftCommand.execute();
        } else if (v == mRightBtn) {
            rightCommand.execute();
        }
    }
}
