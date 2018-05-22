package com.flj.latte.ui.refresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.flj.latte.app.Latter;
import com.flj.latte.net.RestClient;
import com.flj.latte.net.callback.ISuccess;
import com.flj.latte.ui.loader.LatteLoader;
import com.flj.latte.ui.loader.LoaderStyle;
import com.google.auto.value.extension.AutoValueExtension;

/**
 * Created by wp on 2018/5/22.
 * 下拉刷新
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "way";
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

    public void firstPage(String url, Context context) {
//        LatteLoader.showLoading(context, LoaderStyle.BallPulseIndicator);
        RestClient
                .builder()
                .url(url)
                .loader(context)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        LatteLoader.stopLoading();
                        Log.i(TAG, "onSuccess: "+response);
                    }
                }).builder()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
