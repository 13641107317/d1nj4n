package com.flj.latte.ec.main;

import android.graphics.Color;

import com.flj.latte.bottom.BaseBottomDelegate;
import com.flj.latte.bottom.BottomItemDelegate;
import com.flj.latte.bottom.BottomTabBean;
import com.flj.latte.bottom.ItemBuilder;
import com.flj.latte.ec.main.develop.DevelopDelegate;
import com.flj.latte.ec.main.index.IndexDelegate;
import com.flj.latte.ec.main.mine.MineDelegate;
import com.flj.latte.ec.main.shopcar.ShopCarDelegate;
import com.flj.latte.ec.main.sort.SortDelegate;

import java.util.LinkedHashMap;

/**
 * Created by wp on 2018/5/22.
 */

public class EcBottomDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}","主页"),new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}","分类"),new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}","发现"),new DevelopDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}","购物车"),new ShopCarDelegate());
        items.put(new BottomTabBean("{fa-user}","我的"),new MineDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickColor() {
        return Color.parseColor("#ffff8800");
    }
}
