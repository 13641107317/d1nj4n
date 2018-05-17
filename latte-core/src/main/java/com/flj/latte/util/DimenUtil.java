package com.flj.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.flj.latte.app.Latter;

/**
 * Created by wp on 2018/5/17.
 * 测量工具类 dialog
 */

public class DimenUtil {
    /**
     * 屏幕宽度
     * @return
     */
    public static int getScreenWidth() {
        final Resources resources = Latter.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 屏幕高度
     * @return
     */
    public static int getScreenHeight() {
        final Resources resources = Latter.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
