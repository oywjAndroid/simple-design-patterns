package com.lerke.android_views.graphics_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lerke.android_views.R;
import com.lerke.android_views.Utils;

import static android.graphics.Canvas.ALL_SAVE_FLAG;

/**
 * @author allen
 * @description:
 * @date :2020-02-08 17:22
 */
public class AvatarView extends View {

    private static final float AVATAR_WIDTH = Utils.dp2px(300);
    private static final float RADIUS = AVATAR_WIDTH * 0.5f;

    private PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Bitmap bitmap;
    private RectF bounds = new RectF();


    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = Utils.getAvatar(context, (int) AVATAR_WIDTH);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (w != oldw || h != oldh) {
            bounds.set(w / 2f - RADIUS, h / 2f - RADIUS, w / 2f + RADIUS, h / 2f + RADIUS);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 设置离屏缓存
        int saved = canvas.saveLayer(bounds, paint, ALL_SAVE_FLAG);
        // 设置形状
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), RADIUS, paint);
        paint.setXfermode(xfermode);
        // 设置绘制内容
        canvas.drawBitmap(bitmap, bounds.left, bounds.top, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saved);

    }
}
