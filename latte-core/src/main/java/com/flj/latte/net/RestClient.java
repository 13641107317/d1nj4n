package com.flj.latte.net;

import com.flj.latte.net.callback.IError;
import com.flj.latte.net.callback.IFailure;
import com.flj.latte.net.callback.IRequest;
import com.flj.latte.net.callback.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by wp on 2018/5/16.
 */

public class RestClient {
    private final String URL;
    private final Map<String,Object> PARAMS;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;

    public RestClient(String URL,
                      Map<String, Object> PARAMS, IRequest REQUEST,
                      ISuccess SUCCESS, IError ERROR,
                      IFailure FAILURE, RequestBody BODY) {
        this.URL = URL;
        this.PARAMS = PARAMS;
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.ERROR = ERROR;
        this.FAILURE = FAILURE;
        this.BODY = BODY;
    }
    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }

}
