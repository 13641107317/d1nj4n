package com.flj.latte.ec.main.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.diabin.latte.ec.R2;
import com.flj.latte.delegates.bottom.BottomItemDelegate;
import com.diabin.latte.ec.R;
import com.flj.latte.ec.main.sort.content.ContentDelegate;
import com.flj.latte.ec.main.sort.list.VerticalListDelegate;

import butterknife.BindView;

/**
 * Created by wp
 */

public class SortDelegate extends BottomItemDelegate {

    @BindView(R2.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R2.id.nav)
    View view;


    @Override
    public Object setLayout() {
        return R.layout.delegate_sort;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
       getProxyActivity().setOrChangeTranslucentColor(mToolbar, view, getProxyActivity().getResources().getColor(R.color.app_main));
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        final VerticalListDelegate listDelegate = new VerticalListDelegate();
        getSupportDelegate().loadRootFragment(R.id.vertical_list_container, listDelegate);
        //设置右侧第一个分类显示，默认显示分类一
        getSupportDelegate().loadRootFragment(R.id.sort_content_container, ContentDelegate.newInstance(1));
    }
}
