package com.flj.latte.ec.main.sort.list;

import com.flj.latte.ui.recycle.DataConverter;
import com.flj.latte.ui.recycle.ItemType;
import com.flj.latte.ui.recycle.MultipleFields;
import com.flj.latte.ui.recycle.MultipleItemEntity;

import java.util.ArrayList;

/**
 * Created by mac on 2018/5/23.
 */

public final class VerticalListDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEntity> converter() {
        final ArrayList<MultipleItemEntity> arrayList = new ArrayList<>();
        final ArrayList<BeanSort> beanSorts = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            beanSorts.add(new BeanSort("1", "栏目" + i));
        }
        for (BeanSort bean : beanSorts) {
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ItemType.VERTICAL_MENU_LIST)
                    .setField(MultipleFields.ID, bean.getId())
                    .setField(MultipleFields.TEXT, bean.getName())
                    .setField(MultipleFields.TAG, false)
                    .build();
            arrayList.add(entity);
            //设置第一个被选中
            arrayList.get(0).setField(MultipleFields.TAG, true);
        }

        return arrayList;
    }
}
