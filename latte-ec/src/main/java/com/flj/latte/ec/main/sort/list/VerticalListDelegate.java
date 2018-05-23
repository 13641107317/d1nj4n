package com.flj.latte.ec.main.sort.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.diabin.latte.ec.R;
import com.diabin.latte.ec.R2;
import com.flj.latte.delegates.LatteDelegate;
import com.flj.latte.ec.main.sort.SortDelegate;
import com.flj.latte.ui.recycle.MultipleItemEntity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by wp on 2018/5/23.
 */

public class VerticalListDelegate extends LatteDelegate {

    @BindView(R2.id.vertical_list_delegate)
    RecyclerView mRecyclerView = null;

    private void initRecycleView() {
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(manager);
        //屏蔽动画效果
        mRecyclerView.setItemAnimator(null);
//        mRecyclerView.addItemDecoration(BseDecoration.create(Color.GRAY, 5));


    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_vertical_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initRecycleView();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        final ArrayList<MultipleItemEntity> data = new VerticalListDataConverter().converter();
        final SortDelegate delegate = getParentDelegate();
        final SortRecycleAdapter adapter = new SortRecycleAdapter(data, delegate);
        mRecyclerView.setAdapter(adapter);
    }
}
