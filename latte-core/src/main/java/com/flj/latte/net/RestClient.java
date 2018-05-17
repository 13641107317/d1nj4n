package com.flj.latte.net;

import android.content.Context;

import com.flj.latte.net.callback.IError;
import com.flj.latte.net.callback.IFailure;
import com.flj.latte.net.callback.IRequest;
import com.flj.latte.net.callback.ISuccess;
import com.flj.latte.net.callback.RequestCallBacks;
import com.flj.latte.net.download.DownLoadHandler;
import com.flj.latte.ui.LatteLoader;
import com.flj.latte.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by wp on 2018/5/16.
 */

public class RestClient {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final RequestBody BODY;
    //上传文件
    private final File FILE;
    //进度条
    private final LoaderStyle LOADER_STYLE;
    //文件下载
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final Context CONTEXT;

    public RestClient(String url,
                      Map<String, Object> params, IRequest request,
                      File file, String download_dir,
                      String extension, String name,
                      ISuccess success, IError error,
                      IFailure failure, RequestBody body,
                      Context context, LoaderStyle loader_style) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.FILE = file;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.BODY = body;
        this.CONTEXT = context;
        this.LOADER_STYLE = loader_style;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }


    private void request(HttpMethod method) {
        final RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        if (LOADER_STYLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }
        switch (method) {
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = restService.putRaw(URL, BODY);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = restService.postRaw(URL, BODY);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            //文件上传
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = restService.upLoad(URL, body);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallBack());
        }
    }

    private Callback<String> getRequestCallBack() {
        return new RequestCallBacks(REQUEST, SUCCESS, ERROR, FAILURE, LOADER_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
    }

    public final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }

    }
    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void downLoad() {
        new DownLoadHandler(URL,REQUEST,SUCCESS,ERROR,FAILURE,DOWNLOAD_DIR,EXTENSION,NAME)
                .handlerDownLoad();

    }
}
