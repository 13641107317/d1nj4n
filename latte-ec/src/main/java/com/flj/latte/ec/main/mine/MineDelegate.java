package com.flj.latte.ec.main.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.ec.R;
import com.flj.latte.bottom.BottomItemDelegate;

/**
 * Created by wp on 2018/5/22.
 */

public class MineDelegate extends BottomItemDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_mine;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
