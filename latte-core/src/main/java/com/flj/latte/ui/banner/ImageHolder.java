package com.flj.latte.ui.banner;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.flj.latte.image.GlideApp;
import com.flj.latte.ui.recycle.MultipleRecycleAdapter;

/**
 * Created by wp on 2018/5/23.
 */

public class ImageHolder implements Holder<String> {
    private AppCompatImageView imageView = null;

    @Override
    public View createView(Context context) {
        imageView = new AppCompatImageView(context);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        GlideApp.with(context)
                .load(data)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(imageView);
    }
}
