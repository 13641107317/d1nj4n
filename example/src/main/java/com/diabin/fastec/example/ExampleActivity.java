package com.diabin.fastec.example;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.flj.latte.activities.ProxyActivity;
import com.flj.latte.app.Latter;
import com.flj.latte.delegates.LatteDelegate;
import com.flj.latte.ec.launcher.LauncherDelegate;
import com.flj.latte.ec.main.EcBottomDelegate;
import com.flj.latte.ec.sign.ISignListener;
import com.flj.latte.ec.sign.SignInDelegate;
import com.flj.latte.ui.launcher.ILauncherListener;
import com.flj.latte.ui.launcher.OnLauncherFinishTag;

public class ExampleActivity extends ProxyActivity implements ISignListener, ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latter.getConfigurator().withActivity(this);
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherDelegate();
    }

    //登录成功
    @Override
    public void onSignInSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
    }

    //注册成功
    @Override
    public void onSignUpSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
                start(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
                start(new SignInDelegate());
                break;
            default:
                break;
        }
    }
}
