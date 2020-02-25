package com.lerke.android_views.image_display.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.lerke.android_views.R;
import com.lerke.android_views.image_display.view.ScaleTypeImageView;

/**
 * @author allen
 * @description:
 * @date :2020-01-17 11:28
 */
public class ScaleTypeSimpleFragment extends Fragment {

    private ScaleTypeImageView scaleTypeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple_scale_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        scaleTypeView = view.findViewById(R.id.image_01);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Drawable drawable = ContextCompat.getDrawable(scaleTypeView.getContext(), R.drawable.goose_300x200);
        scaleTypeView.setImageDrawable(drawable);
    }
}
