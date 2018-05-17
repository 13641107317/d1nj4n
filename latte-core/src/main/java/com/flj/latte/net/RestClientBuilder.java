package com.flj.latte.net;

import android.content.Context;
import com.flj.latte.net.callback.IError;
import com.flj.latte.net.callback.IFailure;
import com.flj.latte.net.callback.IRequest;
import com.flj.latte.net.callback.ISuccess;
import com.flj.latte.ui.LoaderStyle;
import java.util.Map;
import java.util.WeakHashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by wp on 2018/5/16.
 */

public class RestClientBuilder {
    private String mUrl = null;
    private final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IError mIError = null;
    private IFailure mIFailure = null;
    private RequestBody mBody = null;
    private Context mcContext = null;
    private LoaderStyle mLoaderStyle = null;

    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {

        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle loaderStyle) {
        this.mcContext = context;
        this.mLoaderStyle = loaderStyle;
        return this;
    }

    /**
     * 默认
     * @param context
     * @return
     */
    public final RestClientBuilder loader(Context context) {
        this.mcContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }
    public final RestClient builder() {
        return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIError, mIFailure, mBody, mcContext, mLoaderStyle);
    }
}
