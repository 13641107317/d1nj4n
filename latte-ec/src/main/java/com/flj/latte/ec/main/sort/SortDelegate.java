package com.flj.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.ec.R;
import com.flj.latte.bottom.BottomItemDelegate;
import com.flj.latte.ec.main.sort.content.ContentDelegate;
import com.flj.latte.ec.main.sort.list.VerticalListDelegate;

/**
 * Created by wp on 2018/5/22.
 */

public class SortDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        final VerticalListDelegate verticalListDelegate = new VerticalListDelegate();

        getSupportDelegate().loadRootFragment(R.id.sort_list_container, verticalListDelegate);

        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
    }
}
