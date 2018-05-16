package com.flj.latte.app;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by mac on 2018/5/15.
 */

public class Configurator {
    private static final String TAG = "way";
    private static final HashMap<Object, Object> LATTER_CONFIGS = new HashMap<>();


    private Configurator() {
        LATTER_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
        Log.i(TAG, "Configurator: " + LATTER_CONFIGS.get(ConfigKeys.CONFIG_READY.name()));
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object, Object> getLatterConfigs() {
        return LATTER_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        LATTER_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTER_CONFIGS.put(ConfigKeys.API_HOST.name(), host);
        return this;

    }

    private void checkConfigurator() {
        Log.i(TAG, "checkConfigurator: " + LATTER_CONFIGS.get(ConfigKeys.CONFIG_READY.name()));
        final boolean isReady = (boolean) LATTER_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("configurator is not ready,call configurator");
        }
    }


    final <T> T getConfiguration(Object key) {
        checkConfigurator();
        final Object value = LATTER_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LATTER_CONFIGS.get(key);
    }

}
