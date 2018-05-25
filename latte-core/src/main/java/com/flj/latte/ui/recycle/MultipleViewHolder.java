package com.flj.latte.ui.recycle;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by wp on 2018/5/22.
 */

public class MultipleViewHolder extends BaseViewHolder {
    public MultipleViewHolder(View view) {
        super(view);
    }

    public static MultipleViewHolder create(View view) {
        return new MultipleViewHolder(view);
    }
}
