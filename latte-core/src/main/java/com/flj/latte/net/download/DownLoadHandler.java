package com.flj.latte.net.download;

import android.os.AsyncTask;

import com.flj.latte.net.RestCreator;
import com.flj.latte.net.callback.IError;
import com.flj.latte.net.callback.IFailure;
import com.flj.latte.net.callback.IRequest;
import com.flj.latte.net.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wp on 2018/5/17.
 */

public class DownLoadHandler {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    //文件下载
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;

    public DownLoadHandler(String url, IRequest request,
                           ISuccess success, IError error,
                           IFailure failure, String download_dir,
                           String extension, String name) {
        this.URL = url;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.ERROR = error;
        this.FAILURE = failure;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public final void handlerDownLoad() {

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        RestCreator.getRestService().downLoad(URL, PARAMS).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    final ResponseBody body = response.body();
                    final SaveFileTask fileTask = new SaveFileTask(REQUEST, SUCCESS);
                    fileTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, DOWNLOAD_DIR, EXTENSION, body, NAME);
                    //这里一定要判断文件是否下载完全
                    if (fileTask.isCancelled()) {
                        if (REQUEST != null) {
                            REQUEST.onRequestEnd();
                        }
                    }
                } else {
                    if (ERROR != null) {
                        ERROR.onError(response.code(), response.message());
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (FAILURE != null) {
                    FAILURE.onFailure();
                }
            }
        });
    }
}
