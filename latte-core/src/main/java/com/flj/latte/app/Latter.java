package com.flj.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by mac on 2018/5/15.
 */

public final class Latter {

    public static Configurator init(Context context){
        getConfigurator().put(ConfigKeys.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigurator(){
        return Configurator.getInstance().getLatterConfigs();
    }
    public static <T> T getConfiguration(Object key) {
        return (T) getConfigurator().get(key);
    }
    public static Context getApplication(){
        return (Context) getConfigurator().get(ConfigKeys.APPLICATION_CONTEXT.name());
    }

}
