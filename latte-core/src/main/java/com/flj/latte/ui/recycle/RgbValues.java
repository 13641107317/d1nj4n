package com.flj.latte.ui.recycle;

import com.google.auto.value.AutoValue;

/**
 * Created by wp on 2018/5/23.
 */
@AutoValue
public abstract class RgbValues {
    public abstract int red();
    public abstract int blue();
    public abstract int green();
    public static RgbValues create(int red,int blue,int green){

        return new AutoValue_RgbValues(red,blue,green);
    }
}
