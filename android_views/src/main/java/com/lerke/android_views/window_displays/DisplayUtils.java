package com.lerke.android_views.window_displays;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @author allen
 * @description:
 * @date :2020-02-18 16:05
 */
public class DisplayUtils {

    private static DisplayMetrics sDisplayMetrics = Resources.getSystem().getDisplayMetrics();

    /**
     * 像素密度的比例因子
     *
     * @return density: 0.75、1、1.5 etc.
     */
    public static float getDensity() {
        return sDisplayMetrics.density;
    }

    /**
     * 获取像素密度
     *
     * @return DensityDpi: 120、160、240 etc.
     */
    public static float getDensityDpi() {
        return sDisplayMetrics.densityDpi;
    }


}
