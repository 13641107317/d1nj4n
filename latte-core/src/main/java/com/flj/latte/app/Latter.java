package com.flj.latte.app;

import android.content.Context;
import android.os.Handler;

import java.util.WeakHashMap;

/**
 * Created by mac on 2018/5/15.
 */

public final class Latter {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatterConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
    public static Context getApplication(){
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT.name());
    }
    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER.name());
    }

}
