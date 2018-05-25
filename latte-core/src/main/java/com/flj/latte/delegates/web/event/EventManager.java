package com.flj.latte.delegates.web.event;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * Created by wangpeng on 2018/5/25.
 * 事件管理
 */

public class EventManager {
    private static final HashMap<String, Event> EVENTS = new HashMap<>();

    private EventManager() {
    }

    private static final class Holder {
        private static final EventManager INSTANCE = new EventManager();
    }

    public static EventManager getInstance() {
        return Holder.INSTANCE;
    }

    public EventManager addEvent(@NonNull String name, @NonNull Event event) {
        EVENTS.put(name, event);
        return this;
    }

    public Event createEvent(String action) {
        final Event event = EVENTS.get(action);
        if (event==null){
            return new UndefineEvent();
        }
        return event;
    }
}
