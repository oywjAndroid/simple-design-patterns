package com.lerke.android_views.image_display.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.lerke.android_views.R;

/**
 * @author allen
 * @description: Glide示例Fragment
 * @date :2020-01-17 10:59
 */
public class GlideSimpleFragment extends Fragment {

    private static final String[] PICTURES = {"https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo_2x.jpg"};

    private AppCompatImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_glide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageView = view.findViewById(R.id.glide_image_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(this).load(PICTURES[0]).into(imageView);
    }
}
