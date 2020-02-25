package com.lerke.android_views.text_draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description:
 * @date :2020-02-09 12:06
 */
public class SportRecordView extends View {
    private static final float RADIUS = Utils.dp2px(150);
    private static final float START_ANGLE = -90;
    private static final float PROGRESS_TO_ARC_PARAMS = 3.6f;

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF sportRect = new RectF();
    private Rect textBounds = new Rect();

    private int bgColor;
    private int progressColor;
    private int curProgress;
    private float textSize;

    {
        bgColor = getResources().getColor(android.R.color.holo_orange_light);
        progressColor = getResources().getColor(android.R.color.holo_blue_light);
        textSize = Utils.dp2px(80);
    }

    public SportRecordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w != oldw || h != oldh) {
            sportRect.set(w / 2f - RADIUS, h / 2f - RADIUS, w / 2f + RADIUS, h / 2f + RADIUS);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.dp2px(20));
        // 绘制背景圆
        paint.setColor(bgColor);
        canvas.drawCircle(sportRect.centerX(), sportRect.centerY(), RADIUS, paint);

        // 绘制进度条
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(progressColor);
        canvas.drawArc(sportRect, START_ANGLE, curProgress * PROGRESS_TO_ARC_PARAMS, false, paint);

        // 绘制文本
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);
        String drawText = curProgress + "%";

        // 文本居中绘制
        // 计算文字视觉中点（方式一）
//        paint.getTextBounds(drawText, 0, drawText.length(), textBounds);
//        float offset = (textBounds.top + textBounds.bottom) / 2f;
        // 计算文字视觉中点（方式二）
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float offset = (fontMetrics.ascent + fontMetrics.descent) / 2f;
        canvas.drawText(drawText, sportRect.centerX(), sportRect.centerY() - offset, paint);
    }

    public void setProgress(int progress) {
        if (progress < 0) {
            progress = 0;
        }

        if (progress > 100) {
            progress = 100;
        }

        this.curProgress = progress;
        invalidate();
    }
}
