package com.flj.latte.ui.banner;

import android.support.v4.view.ViewPager;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.diabin.latte.R;

import java.util.ArrayList;

/**
 * Created by wp on 2018/5/23.
 */

public class BannerCreator {
    public static void setDefault(ConvenientBanner<String> convenientBanner,
                                  ArrayList<String> banners,
                                  OnItemClickListener listener){

        convenientBanner.setPages(new HolderCreator(),banners)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
        .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
        .setOnItemClickListener(listener)
        .setPageTransformer(new DefaultTransformer())
        .startTurning(3000)
        .setCanLoop(true);

    }
}
