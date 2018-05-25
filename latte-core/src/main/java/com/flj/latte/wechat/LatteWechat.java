package com.flj.latte.wechat;

import android.app.Activity;

import com.flj.latte.app.ConfigKeys;
import com.flj.latte.app.Latter;
import com.flj.latte.wechat.callbacks.IWechatSignInCallback;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by wp on 2018/5/21.
 * wechat接入
 */

public class LatteWechat {

    public static final String APP_ID = Latter.getConfiguration(ConfigKeys.WE_CHAT_APP_ID.name());
    public static final String APP_SECRET = Latter.getConfiguration(ConfigKeys.WE_CHAT_APP_SECRET.name());
    private final IWXAPI iwxapi;
    private IWechatSignInCallback mSignInCallback;
    private static final class Holder{
        private static final LatteWechat INSTANCE = new LatteWechat();
    }
    public static LatteWechat getIntance(){
        return Holder.INSTANCE;
    }
    private LatteWechat(){
        final Activity activity = Latter.getConfiguration(ConfigKeys.ACTIVITY.name());
        iwxapi = WXAPIFactory.createWXAPI(activity,APP_ID,true);
        iwxapi.registerApp(APP_ID);
    }

    public final IWXAPI getWxapi(){
        return iwxapi;
    }

    public LatteWechat onSignInSuccess(IWechatSignInCallback callback){
        this.mSignInCallback = callback;
        return this;
    }
    public IWechatSignInCallback getmSignInCallback(){
        return mSignInCallback;
    }
    public final void signIn(){
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo";
        req.state = "random_state";
        iwxapi.sendReq(req);
    }
}
