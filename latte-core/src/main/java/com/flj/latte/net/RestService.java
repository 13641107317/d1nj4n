package com.flj.latte.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by wp on 2018/5/16.
 */

public interface RestService {
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @POST
    Call<String> put(@Url String url, @FieldMap Map<String,Object> params);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String,Object> params);

    @Streaming//一边下载一边写文件
    @GET
    Call<ResponseBody> downLoad(@Url String url, @QueryMap Map<String,Object> params);

    @Multipart
    @POST
    Call<String> upLoad(@Url String url, @Part MultipartBody.Part file);

}
