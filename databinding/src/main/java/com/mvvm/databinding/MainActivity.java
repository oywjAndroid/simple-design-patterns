package com.mvvm.databinding;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;

import com.mvvm.databinding.databinding.ActivityMain2Binding;
import com.mvvm.databinding.databinding.ActivityMain2BottomViewBinding;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1.生成绑定对象
        final ActivityMain2Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);

        // 2.绑定数据源
        final User user = new User();
        MainViewModel viewModel = new MainViewModel();
        binding.setVariable(BR.userData, user);
        binding.setVariable(BR.viewModel, viewModel);

        // 3.可观察字段
        user.name.set("Allen");
        user.password.set("19930621");
        user.imageUrl.set("http://img1.imgtn.bdimgm=26&gp=0.jpg");
        user.errorDrawableId.set(R.drawable.error_drawable);
        user.paddingLeft.set(30);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 4.数据源发生改变
                user.name.set("Kobe");
                user.password.set("8 & 24");
                user.paddingLeft.set(60);
                binding.passwordTv.setTextSize(50);

                // 5.关于ViewStub
                View inflateView = binding.viewStub.getViewStub().inflate();
                ActivityMain2BottomViewBinding bottomViewBinding = DataBindingUtil.bind(inflateView);
                if (bottomViewBinding != null) {
                    bottomViewBinding.setBackground(getDrawable(R.color.colorAccent));
                    bottomViewBinding.executePendingBindings();
                }
            }
        }, 3000);


    }
}
