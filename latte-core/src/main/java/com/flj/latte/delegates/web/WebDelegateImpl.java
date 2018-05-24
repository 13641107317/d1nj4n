package com.flj.latte.delegates.web;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.flj.latte.delegates.web.route.RouteKeys;

/**
 * Created by wp on 2018/5/24.
 */

public class WebDelegateImpl extends WebDelegate {

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
        }
    }

    @Override
    public IWebViewInitializer setIWebViewInitializer() {
        return null;
    }
}
