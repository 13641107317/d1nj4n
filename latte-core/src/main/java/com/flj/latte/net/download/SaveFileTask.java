package com.flj.latte.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.flj.latte.app.Latter;
import com.flj.latte.net.callback.IError;
import com.flj.latte.net.callback.IFailure;
import com.flj.latte.net.callback.IRequest;
import com.flj.latte.net.callback.ISuccess;
import com.flj.latte.util.fileutil.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * Created by wp on 2018/5/17.
 */

public class SaveFileTask extends AsyncTask<Object, Void, File> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;

    public SaveFileTask(IRequest REQUEST, ISuccess SUCCESS) {
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downLoadDir = (String) params[0];
        String extension = (String) params[1];
        final ResponseBody body = (ResponseBody) params[2];
        String name = (String) params[3];
        final InputStream in = body.byteStream();
        //下载目录不能为空
        if (downLoadDir == null || downLoadDir.equals("")) {
            downLoadDir = "down_loads";
        }
        //根据需求添加以后
        if (extension == null || extension.equals("")) {
            extension = "";
        }
        if (name == null) {//文件没有完整名字
            return FileUtil.writeToDisk(in, downLoadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(in, downLoadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (SUCCESS != null) {
            SUCCESS.onSuccess(file.getPath());
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
    }

    /**
     * apk安装
     * @param file
     */
    private void autoInstallApk(File file) {
        if (FileUtil.getExtension(file.getPath()).equals(".apk")) {
            final Intent intent = new Intent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Latter.getApplication().startActivity(intent);
        }
    }
}
