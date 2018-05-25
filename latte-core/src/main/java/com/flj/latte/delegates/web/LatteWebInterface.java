package com.flj.latte.delegates.web;

import com.alibaba.fastjson.JSON;

/**
 * Created by wp on 2018/5/24.
 * 和原生js交互
 */

public class LatteWebInterface {
    private final WebDelegate WEBDELEGATE;

    private LatteWebInterface(WebDelegate delegate) {
        this.WEBDELEGATE = delegate;
    }
    static LatteWebInterface create(WebDelegate delegate){
        return new LatteWebInterface(delegate);
    }
    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        return null;
    }
}
