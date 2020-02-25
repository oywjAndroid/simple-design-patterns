package com.lerke.android_views.text_draw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lerke.android_views.Utils;

/**
 * @author allen
 * @description:
 * @date :2020-02-12 14:41
 */
public class ImageTextView extends View {
    private static final float IMAGE_WIDTH = Utils.dp2px(150);
    private static final float IMAGE_OFFSET = Utils.dp2px(100);

    private Bitmap bitmap;
    private float[] measuredWidth = new float[1];

    private Paint paint = new Paint();
    private Rect bounds = new Rect();
    private String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean justo sem, sollicitudin in maximus a, vulputate id magna. Nulla non quam a massa sollicitudin commodo fermentum et est. Suspendisse potenti. Praesent dolor dui, dignissim quis tellus tincidunt, porttitor vulputate nisl. Aenean tempus lobortis finibus. Quisque nec nisl laoreet, placerat metus sit amet, consectetur est. Donec nec quam tortor. Aenean aliquet dui in enim venenatis, sed luctus ipsum maximus. Nam feugiat nisi rhoncus lacus facilisis pellentesque nec vitae lorem. Donec et risus eu ligula dapibus lobortis vel vulputate turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In porttitor, risus aliquam rutrum finibus, ex mi ultricies arcu, quis ornare lectus tortor nec metus. Donec ultricies metus at magna cursus congue. Nam eu sem eget enim pretium venenatis. Duis nibh ligula, lacinia ac nisi vestibulum, vulputate lacinia tortor.";

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = Utils.getAvatar(context, (int) IMAGE_WIDTH);
    }

    {
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(Utils.dp2px(18));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 图片消耗宽度
        final float imageConsumeWidth = IMAGE_WIDTH + Utils.dp2px(10);

        // 绘制图片
        canvas.drawBitmap(bitmap, getWidth() - imageConsumeWidth, IMAGE_OFFSET, paint);

        // 测量文本（测量出每行能够绘制多少个字符，以此实现自动换行效果）
        int length = text.length();
        float fontSpacing = paint.getFontSpacing();
        float baselineOffset = fontSpacing;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();

        for (int start = 0, count; start < length; start += count, baselineOffset += fontSpacing) {

            // 排除不可绘制文本区域
            float usableWidth;
            float textTop = baselineOffset + fontMetrics.top;
            float textBottom = baselineOffset + fontMetrics.bottom;

            if ((textTop < IMAGE_OFFSET && textBottom < IMAGE_OFFSET)
                    || (textTop > IMAGE_OFFSET + IMAGE_WIDTH && textBottom > IMAGE_OFFSET + IMAGE_WIDTH)) {
                usableWidth = getWidth();
            } else {
                usableWidth = getWidth() - imageConsumeWidth;
            }

            // 绘制文本自动换行效果
            count = paint.breakText(text, start, length, true, usableWidth, measuredWidth);
            int end = start + count;
            canvas.drawText(text, start, end, 0, baselineOffset, paint);
        }

    }

}
