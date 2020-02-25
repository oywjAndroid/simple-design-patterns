package com.mvvm.databinding;

import android.view.View;
import android.widget.Toast;

/**
 * @author allen
 * @description:
 * @date :2020-02-21 19:34
 */
public class MainViewModel {

    public void onClickChange(View view) {
        Toast.makeText(view.getContext(),"改变数据",Toast.LENGTH_LONG).show();
    }
}
