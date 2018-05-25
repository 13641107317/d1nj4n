package com.flj.latte.delegates.web;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.flj.latte.delegates.web.chromeclient.WebChromeClientImpl;
import com.flj.latte.delegates.web.client.WebViewClientImpl;
import com.flj.latte.delegates.web.route.RouteKeys;
import com.flj.latte.delegates.web.route.Router;

/**
 * Created by wp on 2018/5/24.
 */

public class WebDelegateImpl extends WebDelegate implements IWebViewInitializer {

    public static WebDelegateImpl create(String url) {
        final Bundle bundle = new Bundle();
        bundle.putString(RouteKeys.URL.name(), url);
        final WebDelegateImpl delegate = new WebDelegateImpl();
        delegate.setArguments(bundle);
        return delegate;
    }

    @Override
    public Object setLayout() {
        return getWebView();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

        if (getUrl() != null) {
            //用原生方式模拟web跳转并加载页面
            Router.getInstace().loadPage(this, getUrl());
        }
    }

    @Override
    public IWebViewInitializer setIWebViewInitializer() {
        return this;
    }

    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializer().creatWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClient() {
        final WebViewClientImpl client = new WebViewClientImpl(this);
        return client;
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return new WebChromeClientImpl();
    }
}
