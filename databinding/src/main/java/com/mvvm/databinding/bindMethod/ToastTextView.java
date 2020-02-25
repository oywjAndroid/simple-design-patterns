package com.mvvm.databinding.bindMethod;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

/**
 * @author allen
 * @description: BindMethod的用法
 * @date :2020-02-23 14:30
 */

@BindingMethods({@BindingMethod(type = ToastTextView.class, attribute = "showText", method = "showToastText")})
public class ToastTextView extends AppCompatTextView {

    public ToastTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void showToastText(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
