package com.flj.latte.wechat.templates;

import com.flj.latte.wechat.BaseWXEntryActivity;
import com.flj.latte.wechat.LatteWechat;

/**
 * Created by wp on 2018/5/21.
 */

public class WPayEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWechat.getIntance().getmSignInCallback().onSignInSuccess(userInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        //关闭activity不需要动画
        overridePendingTransition(0,0);
    }
}
