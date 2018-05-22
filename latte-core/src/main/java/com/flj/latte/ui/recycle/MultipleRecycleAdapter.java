package com.flj.latte.ui.recycle;

import android.support.v7.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.diabin.latte.R;


import java.util.List;
/**
 * Created by wp on 2018/5/22.
 * 适配多布局的adapter
 */

public class MultipleRecycleAdapter
        extends BaseMultiItemQuickAdapter<MultipleItemEntity,MultipleViewHolder>
        implements BaseQuickAdapter.SpanSizeLookup {

    protected MultipleRecycleAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecycleAdapter create(List<MultipleItemEntity> data){
        return new MultipleRecycleAdapter(data);
    }
    public static MultipleRecycleAdapter create(DataConverter dataConverter){
        return new MultipleRecycleAdapter(dataConverter.converter());
    }

    private void init(){
        //设置不同item的布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.TEXT, R.layout.item_multiple_image);
    }
    @Override
    protected void convert(MultipleViewHolder helper, MultipleItemEntity item) {

    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return 0;
    }
}
