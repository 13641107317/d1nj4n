package com.flj.latte.delegates.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

import com.flj.latte.delegates.LatteDelegate;
import com.flj.latte.delegates.web.WebDelegate;
import com.flj.latte.delegates.web.WebDelegateImpl;

/**
 * Created by wp on 2018/5/24.
 */

public class Router {
    private Router() {
    }

    private static final class Holder {
        private static final Router instance = new Router();
    }

    public static Router getInstace() {
        return Holder.instance;
    }

    public final boolean handlerWebUrl(WebDelegate delegate, String url) {
        //如果是电话协议
        if (url.contains("tel:")) {
            callPhone(delegate.getContext(), url);
            return true;
        }
        final LatteDelegate parentDelegate = delegate.getParentDelegate();
        final WebDelegateImpl webDelegate = WebDelegateImpl.create(url);
        //如果没有父容器
        if (parentDelegate == null) {
            delegate.start(webDelegate);
        } else {
            parentDelegate.start(webDelegate);
        }
        return true;
    }

    private void callPhone(Context context, String uri) {
        //提醒用户是否拨打电话
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        final Uri data = Uri.parse(uri);
        intent.setData(data);
        ContextCompat.startActivity(context, intent, null);
    }
}
