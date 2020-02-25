package com.lerke.android_views.text_draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description:
 * @date :2020-02-13 18:32
 */
public class CameraView extends View {

    private static final float IMAGE_WIDTH = Utils.dp2px(150);
    private static final float IMAGE_OFFSET = Utils.dp2px(100);

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;

    private Camera camera = new Camera();

    public CameraView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = Utils.getAvatar(context, (int) IMAGE_WIDTH);
        camera.rotateX(50);
        camera.setLocation(0, 0, Utils.getZForCamera(-8));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawTangent(canvas);
        drawMiterCut(canvas);
    }

    /**
     * 绘制正切
     *
     * @param canvas
     */
    private void drawTangent(Canvas canvas) {

        // 绘制未旋转部分效果
        canvas.save();
        canvas.translate(IMAGE_OFFSET + IMAGE_WIDTH / 2f, IMAGE_OFFSET + IMAGE_WIDTH / 2f);
        canvas.clipRect(-IMAGE_WIDTH / 2f, -IMAGE_WIDTH / 2f, IMAGE_WIDTH / 2f, 0);
        canvas.translate(-(IMAGE_OFFSET + IMAGE_WIDTH / 2f), -(IMAGE_OFFSET + IMAGE_WIDTH / 2f));
        canvas.drawBitmap(bitmap, IMAGE_OFFSET, IMAGE_OFFSET, paint);
        canvas.restore();

        // 绘制Camera旋转效果
        canvas.save();
        canvas.translate(IMAGE_OFFSET + IMAGE_WIDTH / 2f, IMAGE_OFFSET + IMAGE_WIDTH / 2f);
        camera.applyToCanvas(canvas);
        canvas.clipRect(-IMAGE_WIDTH / 2f, 0, IMAGE_WIDTH / 2f, IMAGE_WIDTH / 2f);
        canvas.translate(-(IMAGE_OFFSET + IMAGE_WIDTH / 2f), -(IMAGE_OFFSET + IMAGE_WIDTH / 2f));
        canvas.drawBitmap(bitmap, IMAGE_OFFSET, IMAGE_OFFSET, paint);
        canvas.restore();
    }

    /**
     * 绘制斜切
     */
    private void drawMiterCut(Canvas canvas) {

        // 绘制未旋转部分效果
        canvas.save();
        canvas.translate(IMAGE_OFFSET + IMAGE_WIDTH / 2f, IMAGE_OFFSET + IMAGE_WIDTH / 2f);
        canvas.rotate(-30);
        canvas.clipRect(-IMAGE_WIDTH, -IMAGE_WIDTH , IMAGE_WIDTH, 0);
        canvas.rotate(30);
        canvas.translate(-(IMAGE_OFFSET + IMAGE_WIDTH / 2f), -(IMAGE_OFFSET + IMAGE_WIDTH / 2f));
        canvas.drawBitmap(bitmap, IMAGE_OFFSET, IMAGE_OFFSET, paint);
        canvas.restore();

        // 绘制Camera旋转效果
        canvas.save();
        canvas.translate(IMAGE_OFFSET + IMAGE_WIDTH / 2f, IMAGE_OFFSET + IMAGE_WIDTH / 2f);
        canvas.rotate(-30);
        camera.applyToCanvas(canvas);
        canvas.clipRect(-IMAGE_WIDTH, 0, IMAGE_WIDTH , IMAGE_WIDTH);
        canvas.rotate(30);
        canvas.translate(-(IMAGE_OFFSET + IMAGE_WIDTH / 2f), -(IMAGE_OFFSET + IMAGE_WIDTH / 2f));
        canvas.drawBitmap(bitmap, IMAGE_OFFSET, IMAGE_OFFSET, paint);
        canvas.restore();

    }
}
