package com.flj.latte.util.timer;

import java.util.TimerTask;

/**
 * Created by mac on 2018/5/17.
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener iTimerListener =null;

    public BaseTimerTask(ITimerListener iTimerListener) {
        this.iTimerListener = iTimerListener;
    }

    @Override
    public void run() {

        if (iTimerListener!=null){
            iTimerListener.onTimer();
        }
    }
}
