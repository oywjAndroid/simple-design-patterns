package com.lerke.android_views.graphics_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description: 饼图
 * @date :2020-02-08 16:30
 */
public class PieChartView extends View {

    private static final float RADIUS = Utils.dp2px(150);
    private static final float OFFSET_LENGTH = Utils.dp2px(15);

    private RectF rectF = new RectF();
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private int selectArea = 2;

    int[] ANGLES = {60, 100, 120, 80};
    int[] COLORS = {Color.parseColor("#448AFF"), Color.parseColor("#9575CD"),
            Color.parseColor("#FF8F00"), Color.parseColor("#00C853")};

    {
        paint.setStyle(Paint.Style.FILL);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (w != oldw || h != oldh) {
            float halfW = w * 0.5f;
            float halfH = h * 0.5f;
            rectF.set(halfW - RADIUS, halfH - RADIUS, halfW + RADIUS, halfH + RADIUS);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float currentAngle = 0f;
        for (int i = 0; i < ANGLES.length; i++) {

            if (i == selectArea) {
                canvas.save();
                canvas.translate(
                        OFFSET_LENGTH * (float) Math.cos(Math.toRadians(currentAngle + ANGLES[i] * 0.5f)),
                        OFFSET_LENGTH * (float) Math.sin(Math.toRadians(currentAngle + ANGLES[i] * 0.5f))
                );
            }

            paint.setColor(COLORS[i]);
            canvas.drawArc(rectF, currentAngle, ANGLES[i], true, paint);
            currentAngle += ANGLES[i];

            if (i == selectArea) {
                canvas.restore();
            }
        }
    }

    public int getSelectArea() {
        return selectArea;
    }

    public void setSelectArea(int selectArea) {
        this.selectArea = selectArea;
    }
}
