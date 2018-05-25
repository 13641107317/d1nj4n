package com.flj.latte.delegates.web.client;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.flj.latte.delegates.web.WebDelegate;
import com.flj.latte.delegates.web.route.Router;


/**
 * Created by wp on 2018/5/24.
 */

public class WebViewClientImpl extends WebViewClient {
    private final WebDelegate DELEGATE;

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        return Router.getInstace().handlerWebUrl(DELEGATE,url);
    }
}
