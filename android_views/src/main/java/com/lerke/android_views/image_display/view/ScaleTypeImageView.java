package com.lerke.android_views.image_display.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * ScaleTypeImageView主要用于理解ImageView的ScaleType实现原理。
 */
public class ScaleTypeImageView extends View {

    private static final String TAG = "ImageView";

    private Drawable mDrawable;
    private Matrix mMatrix = new Matrix();
    private Matrix mDrawMatrix;

    private final RectF mTempSrc = new RectF();
    private final RectF mTempDst = new RectF();

    public ScaleTypeImageView(Context context) {
        super(context);
    }

    public ScaleTypeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setImageDrawable(Drawable drawable) {
        this.mDrawable = drawable;
        invalidate();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        if (mDrawable == null) {
            return;
        }

        Log.i(TAG, "width:" + getWidth() + ",height:" + getHeight());
        Log.i(TAG, "isIdentity:" + mMatrix.isIdentity());

        int vWidth = getWidth();
        int vHeight = getHeight();
        int dWidth = mDrawable.getIntrinsicWidth();
        int dHeight = mDrawable.getIntrinsicHeight();

//        configureFitXY(vWidth, vHeight);
//        configureCenter(vWidth, vHeight, dWidth, dHeight);
//        configureCenterCrop(vWidth, vHeight, dWidth, dHeight);
//        configureCenterInside(vWidth, vHeight, dWidth, dHeight);
//        configureFitCenter(vWidth, vHeight, dWidth, dHeight);
//        configureFitStart(vWidth, vHeight, dWidth, dHeight);
        configureFitEnd(vWidth, vHeight, dWidth, dHeight);

        if (mDrawMatrix != null) {
            canvas.concat(mDrawMatrix);
        }
        mDrawable.draw(canvas);
    }

    private void configureFitXY(int vWidth, int vHeight) {
        mDrawable.setBounds(0, 0, vWidth, vHeight);
    }

    private void configureCenter(int vWidth, int vHeight, int dWidth, int dHeight) {
        mDrawable.setBounds(0, 0, dWidth, dHeight);
        mDrawMatrix = mMatrix;
        mDrawMatrix.setTranslate(Math.round((vWidth - dWidth) * 0.5f),
                Math.round((vHeight - dHeight) * 0.5f));
    }

    private void configureCenterCrop(int vWidth, int vHeight, int dWidth, int dHeight) {
        mDrawable.setBounds(0, 0, dWidth, dHeight);

        mDrawMatrix = mMatrix;

        float scale;
        float dx = 0, dy = 0;

        if (dWidth * vHeight > vWidth * dHeight) {
            Log.i(TAG, "原图尺寸大于ImageView尺寸");
            scale = (float) vHeight / (float) dHeight;
            dx = (vWidth - dWidth * scale) * 0.5f;
        } else {
            Log.i(TAG, "原图尺寸小于等于ImageView尺寸");
            scale = (float) vWidth / (float) dWidth;
            dy = (vHeight - dHeight * scale) * 0.5f;
        }

        Log.i(TAG, "scale:" + scale + ",dx:" + dx + ",dy:" + dy);

        mDrawMatrix.setScale(scale, scale);
        mDrawMatrix.postTranslate(Math.round(dx), Math.round(dy));
    }

    private void configureCenterInside(int vWidth, int vHeight, int dWidth, int dHeight) {
        mDrawable.setBounds(0, 0, dWidth, dHeight);

        mDrawMatrix = mMatrix;
        float scale;
        float dx;
        float dy;

        if (dWidth <= vWidth && dHeight <= vHeight) {
            scale = 1.0f;
        } else {
            scale = Math.min((float) vWidth / (float) dWidth,
                    (float) vHeight / (float) dHeight);
        }

        dx = Math.round((vWidth - dWidth * scale) * 0.5f);
        dy = Math.round((vHeight - dHeight * scale) * 0.5f);

        Log.i(TAG, "scale:" + scale + ",dx:" + dx + ",dy:" + dy);

        mDrawMatrix.setScale(scale, scale);
        mDrawMatrix.postTranslate(dx, dy);
    }

    private void configureFitCenter(int vWidth, int vHeight, int dWidth, int dHeight) {
        mDrawable.setBounds(0, 0, dWidth, dHeight);

        mTempSrc.set(0, 0, dWidth, dHeight);
        mTempDst.set(0, 0, vWidth, vHeight);

        mDrawMatrix = mMatrix;
        mDrawMatrix.setRectToRect(mTempSrc, mTempDst, Matrix.ScaleToFit.CENTER);
    }

    private void configureFitStart(int vWidth, int vHeight, int dWidth, int dHeight) {
        mDrawable.setBounds(0, 0, dWidth, dHeight);

        mTempSrc.set(0, 0, dWidth, dHeight);
        mTempDst.set(0, 0, vWidth, vHeight);

        mDrawMatrix = mMatrix;
        mDrawMatrix.setRectToRect(mTempSrc, mTempDst, Matrix.ScaleToFit.START);
    }

    private void configureFitEnd(int vWidth, int vHeight, int dWidth, int dHeight) {
        mDrawable.setBounds(0, 0, dWidth, dHeight);

        mTempSrc.set(0, 0, dWidth, dHeight);
        mTempDst.set(0, 0, vWidth, vHeight);

        mDrawMatrix = mMatrix;
        mDrawMatrix.setRectToRect(mTempSrc, mTempDst, Matrix.ScaleToFit.END);
    }
}
