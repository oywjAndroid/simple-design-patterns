package com.lerke.android_views.custom_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.lerke.android_views.R;
import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description: 导航栏添加的View
 * @date :2020-02-17 16:33
 */
public class NavigationView extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float mNavigationImageSize;
    private float navigationImageUseAreaPercent = 0.6f;

    private Bitmap bitmap;
    private String text = "导航提示";

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            configNavigationImageParams(w, h);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 绘制图片
        float left = getWidth() / 2f - mNavigationImageSize / 2f;
        float top = getHeight() / 2f - mNavigationImageSize / 2f;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, left, top, paint);
        }
        // 绘制文字
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(Utils.dp2px(16));
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, getWidth() / 2f, top + mNavigationImageSize + Utils.dp2px(4), paint);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /*
     * 设置导航视图中图片占用View的百分比
     *
     * @param percent 百分比
     */
    public void setNavigationImageUseAreaPercent(float percent) {
        this.navigationImageUseAreaPercent = percent;
        invalidate();
    }

    public float getNavigationImageUseAreaPercent() {
        return navigationImageUseAreaPercent;
    }

    private void configNavigationImageParams(int vW, int vH) {
        mNavigationImageSize = (vW <= vH ? vW : vH) * navigationImageUseAreaPercent;
        if (bitmap == null) {
//            bitmap = Utils.decodeSampledFromResuorce(getResources(), R.drawable.avatar_rengwuxian, (int) mNavigationImageSize, (int) mNavigationImageSize);
              bitmap = Utils.drawableToBitmap(ContextCompat.getDrawable(getContext(),R.drawable.icon_home_checked));
        }
    }
}
