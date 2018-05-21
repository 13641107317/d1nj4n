package com.flj.latte.bottom;

/**
 * Created by mac on 2018/5/21.
 */

public final class BottomTabBean {
    private final CharSequence ICON;
    private final CharSequence TITTLE;

    public BottomTabBean(CharSequence icon, CharSequence tittle) {
        this.ICON = icon;
        this.TITTLE = tittle;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTittle() {
        return TITTLE;
    }
}
