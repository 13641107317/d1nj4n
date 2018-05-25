package com.flj.latte.ui.recycle;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * Created by wp on 2018/5/23.
 */

public class DividerLookUpImpl implements DividerItemDecoration.DividerLookup {
    private final int COLOR;
    private final int SIZE;

    public DividerLookUpImpl(int color, int size) {
        this.COLOR = color;
        this.SIZE = size;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder()
                .color(COLOR)
                .size(SIZE)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return new Divider.Builder()
                .color(COLOR)
                .size(SIZE)
                .build();
    }
}
