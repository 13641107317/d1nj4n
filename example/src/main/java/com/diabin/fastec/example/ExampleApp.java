package com.diabin.fastec.example;

import android.app.Application;

import com.flj.latte.app.Latter;
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
                .withLoaderDelayed(3000)
                .configure();
    }
}
