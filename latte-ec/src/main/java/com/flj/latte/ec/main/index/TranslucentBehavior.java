package com.flj.latte.ec.main.index;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.diabin.latte.ec.R;
import com.flj.latte.ui.recycle.RgbValues;

/**
 * Created by wp on 2018/5/23.
 * 状态栏随recycleview滑动而滑动
 */

public class TranslucentBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    //顶部距离
    private int mDistanceY = 0;
    //颜色变换速率
    private static final int SHOW_SPEED = 3;
    //定义变化的颜色
    private final RgbValues RGBVALUES = RgbValues.create(255, 2, 124);

    //必须使用两个参数的构造
    public TranslucentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //依赖的view
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.rv_index;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        //增加滑动距离

        mDistanceY += dy;
        //获取toolbar的高度
        final int toolBarHeight = child.getBottom();
        //当滑动时,并且距离小于toolbar 高度的时候 调整渐变色
        if (mDistanceY > 0 && mDistanceY <= toolBarHeight) {
            final float scale = (float) mDistanceY / toolBarHeight;
            final float alpha = scale * 255;
            child.setBackgroundColor(Color.argb((int) alpha,RGBVALUES.red(),RGBVALUES.blue(),RGBVALUES.green()));
        }else if (mDistanceY>toolBarHeight){
            child.setBackgroundColor(Color.rgb(RGBVALUES.red(),RGBVALUES.blue(),RGBVALUES.green()));
        }
    }
}
