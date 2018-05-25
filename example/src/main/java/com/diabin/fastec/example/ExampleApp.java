package com.diabin.fastec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.flj.latte.app.Latter;
import com.flj.latte.ec.database.DataBaseManager;
import com.flj.latte.ec.icon.FontEcModule;
import com.flj.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latter.init(this)
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withApiHost("http://127.0.0.1/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withWechatAppId("")
                .withWechatAppSecret("")
                .withLoaderDelayed(5000)
                .configure();

        //数据库初始化
        DataBaseManager.getDataBaseManager().init(this);
//        initStetho();
    }

    private void initStetho() {
//            Stetho.initializeWithDefaults(this);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
