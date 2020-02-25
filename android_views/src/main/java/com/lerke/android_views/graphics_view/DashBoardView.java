package com.lerke.android_views.graphics_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description:
 * @date :2020-02-08 10:48
 */
public class DashBoardView extends View {
    private static final String TAG = DashBoardView.class.getSimpleName();
    private static final float RADIUS = Utils.dp2px(100);
    private static final float STROKE_WIDTH = Utils.dp2px(2);
    private static final int OPEN_ANGLE = 120;
    private static final float DASH_WIDTH = Utils.dp2px(3);
    private static final float DASH_HEIGHT = Utils.dp2px(10);
    private static final float POINTER_LENGTH = Utils.dp2px(70);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF arcRect = new RectF();
    Path markArcPath = new Path();
    Path markDashPath = new Path();
    PathDashPathEffect markArcPathEffect;
    PathMeasure pathMeasure = new PathMeasure();

    private int markValue = 20;

    {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE_WIDTH);
        markDashPath.addRect(0, 0, DASH_WIDTH, DASH_HEIGHT, Path.Direction.CW);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i(TAG, "onSizeChanged()");

        if (oldw != w || oldh != h) {
            Log.i(TAG, "Size changed!");
            float halfW = w / 2f;
            float haltH = h / 2f;

            // 绘制弧形的矩形区域
            arcRect.set(halfW - RADIUS, haltH - RADIUS, halfW + RADIUS, haltH + RADIUS);

            markArcPath.reset();
            int startAngle = 90 + OPEN_ANGLE / 2;
            int sweepAngle = 360 - OPEN_ANGLE;
            markArcPath.addArc(arcRect, startAngle, sweepAngle);


            pathMeasure.setPath(markArcPath, false);
            /*
             * shape : 绘制虚线的形状（以Path设置）
             * advance : 虚线块之间的间隔
             * phase : 与第一个虚线块之间的偏移量
             * Style : 处理虚线块与路径之间的样式
             */
            markArcPathEffect = new PathDashPathEffect(markDashPath, (pathMeasure.getLength() - DASH_WIDTH) / 20f, 0, PathDashPathEffect.Style.MORPH);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG, "onDraw()");

        // 绘制圆弧
        canvas.drawPath(markArcPath, paint);

        // 绘制刻度
        paint.setPathEffect(markArcPathEffect);
        canvas.drawPath(markArcPath, paint);
        paint.setPathEffect(null);

        // 绘制指针
        // stopX、stopY需要清楚坐标远点
        // 方式一
//        canvas.drawLine(arcRect.centerX(), arcRect.centerY(),
//                arcRect.centerX() + POINTER_LENGTH * (float) Math.cos(getAngleFromMark(markValue)),
//                arcRect.centerY() + POINTER_LENGTH * (float) Math.sin(getAngleFromMark(markValue)), paint);

        // 方式二
        canvas.save();
        canvas.translate(arcRect.centerX(), arcRect.centerY());
        canvas.drawLine(0, 0,
                POINTER_LENGTH * (float) Math.cos(getAngleFromMark(markValue)),
                POINTER_LENGTH * (float) Math.sin(getAngleFromMark(markValue)), paint);
        canvas.restore();

    }

    public void setMarkValue(int markValue) {
        this.markValue = markValue;
    }

    public int getMarkValue() {
        return this.markValue;
    }

    private float getAngleFromMark(int mark) {
        return (float) Math.toRadians(90 + OPEN_ANGLE / 2f + ((360 - OPEN_ANGLE) / 20f * mark));
    }

}
