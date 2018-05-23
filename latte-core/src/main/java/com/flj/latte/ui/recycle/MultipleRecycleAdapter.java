package com.flj.latte.ui.recycle;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.diabin.latte.R;
import com.flj.latte.ui.banner.BannerCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wp on 2018/5/22.
 * 适配多布局的adapter
 */

public class MultipleRecycleAdapter
        extends BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>
        implements BaseQuickAdapter.SpanSizeLookup,OnItemClickListener{
    //确保recycleview只加载一次banner
    private boolean isInitBanner = false;

    protected MultipleRecycleAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public static MultipleRecycleAdapter create(List<MultipleItemEntity> data) {
        return new MultipleRecycleAdapter(data);
    }

    public static MultipleRecycleAdapter create(DataConverter dataConverter) {
        return new MultipleRecycleAdapter(dataConverter.converter());
    }


    private void init() {
        //设置不同item的布局
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image);
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_image_text);
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner);
        //设置宽度监听
        setSpanSizeLookup(this);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        final String text;
        final String imageUrl;
        final ArrayList<String> banners;
        switch (holder.getItemViewType()) {
            case ItemType.TEXT:
                text = entity.getField(MultipleFields.TEXT);
                holder.setText(R.id.item_text_single, text);
                break;
            case ItemType.IMAGE:
                imageUrl = entity.getField(MultipleFields.IMAGE_URL);
                Glide
                        .with(mContext)
                        .load(imageUrl)
                        .into((ImageView) holder.getView(R.id.item_image_single));
                break;
            case ItemType.TEXT_IMAGE:
                text = entity.getField(MultipleFields.TEXT);
                holder.setText(R.id.item_tv_text, text);
                imageUrl = entity.getField(MultipleFields.IMAGE_URL);
                Glide
                        .with(mContext)
                        .load(imageUrl)
                        .into((ImageView) holder.getView(R.id.item_iv_image_text));
                break;
            case ItemType.BANNER:
                if (!isInitBanner){
                    banners = entity.getField(MultipleFields.BANNERS);
                   final ConvenientBanner<String> convenientBanner = holder.getView(R.id.item_banner);
                    BannerCreator.setDefault(convenientBanner,banners,this);
                    isInitBanner = true;
                }
                break;
        }
    }

    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return getData().get(position).getField(MultipleFields.SPAN_SIZE);
    }

    @Override
    public void onItemClick(int position) {

    }
}
