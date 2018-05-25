package com.flj.latte.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.flj.latte.delegates.web.event.Event;
import com.flj.latte.delegates.web.event.EventManager;

/**
 * Created by wp on 2018/5/24.
 * 和原生js交互
 */

public final class LatteWebInterface {
    private final WebDelegate WEBDELEGATE;

    private LatteWebInterface(WebDelegate delegate) {
        this.WEBDELEGATE = delegate;
    }
    static LatteWebInterface create(WebDelegate delegate){
        return new LatteWebInterface(delegate);
    }
    @JavascriptInterface
    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event!=null){
            event.setAction(action);
            event.setDelegate(WEBDELEGATE);
            event.setContext(WEBDELEGATE.getContext());
            event.setUrl(WEBDELEGATE.getUrl());

            return event.execute(params);
        }
        return null;
    }
}
