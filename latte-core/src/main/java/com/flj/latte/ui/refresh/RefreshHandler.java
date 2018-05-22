package com.flj.latte.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.flj.latte.app.Latter;

/**
 * Created by wp on 2018/5/22.
 * 下拉刷新
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {


    private final SwipeRefreshLayout REFRESH_LAYOUT;


    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    private void refresh() {

        REFRESH_LAYOUT.setRefreshing(true);
        Latter.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
