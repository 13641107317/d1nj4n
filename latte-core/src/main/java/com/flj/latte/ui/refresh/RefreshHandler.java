package com.flj.latte.ui.refresh;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flj.latte.app.Latter;
import com.flj.latte.net.RestClient;
import com.flj.latte.net.callback.ISuccess;
import com.flj.latte.ui.loader.LatteLoader;
import com.flj.latte.ui.loader.LoaderStyle;
import com.flj.latte.ui.recycle.DataConverter;
import com.flj.latte.ui.recycle.MultipleRecycleAdapter;
import com.google.auto.value.extension.AutoValueExtension;

/**
 * Created by wp on 2018/5/22.
 * 下拉刷新
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener{
    private static final String TAG = "way";
    private final SwipeRefreshLayout REFRESH_LAYOUT;

    private final PagingBean BEAN;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecycleAdapter mAdapter = null;
    private final DataConverter CONVERTER;

    private RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT, RecyclerView recyclerView, DataConverter dataConverter, PagingBean pagingBean) {
        this.RECYCLERVIEW = recyclerView;
        this.CONVERTER = dataConverter;
        this.BEAN = pagingBean;
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout REFRESH_LAYOUT,
                                        RecyclerView recyclerView,
                                        DataConverter dataConverter) {
        return new RefreshHandler(REFRESH_LAYOUT, recyclerView, dataConverter, new PagingBean());

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
        BEAN.setDelayed(1000);
        RestClient
                .builder()
                .url(url)
                .loader(context)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        LatteLoader.stopLoading();
                        final JSONObject object = JSON.parseObject(response);
                        BEAN.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        //设置adapter
                        mAdapter = MultipleRecycleAdapter.create(CONVERTER.setJsonData(response));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this,RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        BEAN.addIndex();
                    }
                }).builder()
                .get();
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }
}
