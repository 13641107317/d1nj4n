package com.flj.latte.ec.main.index;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;
import com.flj.latte.delegates.LatteDelegate;
import com.flj.latte.ec.main.detail.GoodsDetailDelegate;

import java.lang.ref.PhantomReference;

/**
 * Created by wp on 2018/5/23.
 */

public class IndexItemClickListener extends SimpleClickListener {
    private final LatteDelegate mLatteDelegate;

    private IndexItemClickListener(LatteDelegate latteDelegate) {
        this.mLatteDelegate = latteDelegate;
    }
    public static SimpleClickListener create(LatteDelegate delegate){
        return new IndexItemClickListener(delegate);
    }
    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        mLatteDelegate.start(new GoodsDetailDelegate());

    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
