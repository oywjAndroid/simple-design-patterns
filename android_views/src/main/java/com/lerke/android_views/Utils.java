package com.lerke.android_views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * @author allen
 * @description:
 * @date :2020-02-08 10:52
 */
public class Utils {

    public static final float dp2px(float dp) {
        return Resources.getSystem().getDisplayMetrics().density * dp + 0.5f;
    }

    public static final Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap( drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap getAvatar(Context context, int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), R.drawable.avatar_rengwuxian, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.avatar_rengwuxian, options);
    }

    public static Bitmap decodeSampledFromResuorce(Resources res,
                                                   int resId, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //加载图片
        BitmapFactory.decodeResource(res, resId, options);
        //计算缩放比
        options.inSampleSize = calculateInSampleSize(options,reqHeight, reqWidth);
        //重新加载图片
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(res, resId, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options,
                                             int reqHeight, int reqWidth){
        int height= options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height>reqHeight||width>reqWidth){
            int halfHeight = height / 2;
            int halfWidth = width / 2;

            //计算缩放比，是2的指数
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth){
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static float getZForCamera(int zLocation) {
        return zLocation * Resources.getSystem().getDisplayMetrics().density;
    }

}
