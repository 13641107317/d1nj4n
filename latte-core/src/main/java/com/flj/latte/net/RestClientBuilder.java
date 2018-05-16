package com.flj.latte.net;

import com.flj.latte.net.callback.IError;
import com.flj.latte.net.callback.IFailure;
import com.flj.latte.net.callback.IRequest;
import com.flj.latte.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by wp on 2018/5/16.
 */

public class RestClientBuilder {
    private  String mUrl;
    private  Map<String,Object> mParams;
    private  IRequest mIRequest;
    private  ISuccess mISuccess;
    private  IError mIError;
    private  IFailure mIFailure;
    private  RequestBody mBody;
    RestClientBuilder(){

    }
    public  final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }
    public  final RestClientBuilder params(Map<String,Object> params){
        this.mParams = params;
        return this;
    }

    public  final RestClientBuilder params(String key,Object value){
        if (mParams ==null){
            mParams = new WeakHashMap<>();
        }
        this.mParams.put(key,value);
        return this;
    }

    public  final RestClientBuilder raw(String raw){
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public  final RestClientBuilder success(ISuccess iSuccess){
        this.mISuccess = iSuccess;
        return this;
    }
    public  final RestClientBuilder failure(IFailure iFailure){
        this.mIFailure = iFailure;
        return this;
    }
    public  final RestClientBuilder error(IError iError){
        this.mIError = iError;
        return this;
    }

    private Map<String,Object> checkParams(){
        if (mParams ==null){
            mParams = new WeakHashMap<>();
        }
        return mParams;
    }
}
