package com.flj.latte.app;

import java.util.WeakHashMap;

/**
 * Created by mac on 2018/5/15.
 */

public class Configurator {

    private static final WeakHashMap<String,Object> LATTER_CONFIGS = new WeakHashMap<>();
    private Configurator(){
        LATTER_CONFIGS.put(ConfigKeys.CONFIG_READY.name(),false);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    final WeakHashMap<String,Object> getLatterConfigs(){
        return LATTER_CONFIGS;
    }
    private  static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public  final void confinurator(){
        LATTER_CONFIGS.put(ConfigKeys.CONFIG_READY.name(),true);
    }
    public final Configurator withApiHost(String host){
        LATTER_CONFIGS.put(ConfigKeys.API_HOST.name(),host);
        return this;

    }
    private  void checkConfigurator(){
        final boolean isReady = (boolean) LATTER_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("configurator is not ready,call configurator");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigKeys> key){
        checkConfigurator();
        return (T) LATTER_CONFIGS.get(key.name());

    }

}
