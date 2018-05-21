package com.flj.latte.wechat.templates;

import com.flj.latte.wechat.BaseWXEntryActivity;
import com.flj.latte.wechat.LatteWechat;

/**
 * Created by wp on 2018/5/21.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {


    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }
    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWechat.getIntance().getmSignInCallback().onSignInSuccess(userInfo);
    }
}
