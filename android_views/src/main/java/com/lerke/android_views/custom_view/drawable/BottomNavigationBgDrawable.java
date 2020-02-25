package com.lerke.android_views.custom_view.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description:
 * @date :2020-02-18 12:19
 */
public class BottomNavigationBgDrawable extends Drawable {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private float radius = Utils.dp2px(5);
    private RectF effectBounds = new RectF();
    private float paddingLeft;
    private float paddingTop;
    private float paddingRight;
    private float paddingBottom;
    private int color = Resources.getSystem().getColor(android.R.color.black);
    private Path path = new Path();

    @Override
    public void draw(@NonNull Canvas canvas) {
        paint.setColor(color);
        path.setFillType(Path.FillType.WINDING);
        path.addRoundRect(effectBounds, radius, radius, Path.Direction.CW);
        path.addRect(effectBounds.left, effectBounds.top + radius, effectBounds.right, effectBounds.bottom + radius, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        configEffectBounds(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override
    public int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override
    public int getIntrinsicWidth() {
        return getBounds().width();
    }

    private void configEffectBounds(float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        int w = getIntrinsicWidth();
        int h = getIntrinsicHeight();
        this.effectBounds.set(paddingLeft, paddingTop, w - paddingRight, h - paddingBottom);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setRadius(float radius) {
        this.radius = Utils.dp2px(radius);
    }

    public float getRadius() {
        return radius;
    }

    public void setPadding(float paddingLeft, float paddingTop, float paddingRight, float paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
        configEffectBounds(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }
}
