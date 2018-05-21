package com.flj.latte.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.flj.latte.app.Latter;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Created by wp on 2018/5/21.
 */

public abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须卸载oncreate()
        LatteWechat.getIntance().getWxapi().handleIntent(getIntent(),this);
    }
//确保在各种手机上不出错
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        LatteWechat.getIntance().getWxapi().handleIntent(getIntent(),this);
    }
}
