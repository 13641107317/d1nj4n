package com.diabin.fastec.example;

import android.app.Application;

import com.flj.latte.app.Latter;


public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latter.
                init(this)
                .withApiHost("http://127.0.0.1")
                .confinurator();
    }
}
