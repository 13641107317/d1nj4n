package com.diabin.fastec.example;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.flj.latte.activities.ProxyActivity;
import com.flj.latte.delegates.LatteDelegate;

import com.flj.latte.ec.launcher.LauncherDelegate;
import com.flj.latte.ec.launcher.LauncherScrollDelegate;
import com.flj.latte.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }


}
