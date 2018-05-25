package com.flj.latte.ui.recycle;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by wp on 2018/5/23.
 * recycleView分割线
 */

public class BseDecoration extends DividerItemDecoration {
    private BseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DividerLookUpImpl(color, size));
    }

    public static BseDecoration create(@ColorInt int color, int size) {
        return new BseDecoration(color, size);
    }
}
